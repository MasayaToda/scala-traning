// Futureを使えるようにimport
import scala.concurrent.Future
import scala.util.{Success, Failure}
// おまじないだと思って無視してください
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
object  futureQuestion {
  def main(args: Array[String]): Unit = {
    // 問題1
    // 2022/11/8修正:メソッド修正に合わせて、呼び出し方法を修正
    val startQ1 = System.currentTimeMillis()
    val result = futureQuestion1(1)
    result.onComplete{
      case Success(organization) => {
        val endQ1 = System.currentTimeMillis()
        println((endQ1 - startQ1) + "ミリ秒")
      }
      case Failure(e) => println(e.getMessage)
    }
    Await.result(result, Duration.Inf)
    // // 問題3
    // 2022/11/8修正:メソッド修正に合わせて、呼び出し方法を修正
    // 2022/11/8修正:明示的にマルチスレッド処理するようにsequenceを利用するよう修正
    val startQ3 = System.currentTimeMillis()
    val futures =(1 to 3).toList.map{ i => futureQuestion1(i)}
    var results = Future.sequence(futures)
    results.onComplete{
      case Success(organization) => {
        val endQ3 = System.currentTimeMillis()
        println((endQ3 - startQ3) + "ミリ秒")
      }
      case Failure(e) => {
        val endQ3 = System.currentTimeMillis()
        println((endQ3 - startQ3) + "ミリ秒")
      }
    }
    Await.ready(results, Duration.Inf)
  }
  // 問題1
  // 2022/11/8修正:コールバックを追加し、仕様通りメソッド内で標準出力できるように修正
  def futureQuestion1(branchId:Long):Future[Organization] ={
    val result = for{
      branch <- Database.getBranchById(branchId)
      organization <- Database.getOrganizationById(branch.organizationId)
    } yield organization
    result.onComplete {
      case Success(organization) => {
        println(organization.name)
      }
      case Failure(e) => {
        println(e.getMessage)
      }
    }
    (result)
  }
  case class Organization(
    id:    Long,   // 法人ID
    name:  String, // 法人名
    email: String  // 法人のEmailアドレス
  )
  // 法人(Organization)が所有している施設情報(保育園・幼稚園など)
  case class Branch (
    id:              Long,   // 施設ID
    organizationId:  Long,   // 法人ID
    name:            String  // 施設名
  )
  // Database情報
  object Database {
    // 施設のIDから、施設情報を取得する
    def getBranchById(branchId: Long): Future[Branch] = Future {
      // 時間がかかる処理という想定
      Thread.sleep(1000)
      branchList.find(_.id == branchId).getOrElse(throw new RuntimeException(s"BranchId[${branchId}] not found."))
    }
    // 法人のIDから、法人情報を取得する
    def getOrganizationById(organizationId: Long): Future[Organization] = Future {
      // 時間がかかる処理という想定
      Thread.sleep(2000)
      organizationList.find(_.id == organizationId).getOrElse(throw new RuntimeException(s"OrganizationId[${organizationId}] not found."))
    }

    //////// DBに登録されている想定の擬似データ ////////
    // 施設リスト
    private val branchList = Seq(
      Branch(
        id             = 1,
        organizationId = 11,
        name           = "nextbeat保育園"
      ),
      Branch(
        id             = 2,
        organizationId = 22,
        name           = "カワサキ保育園"
      ),
      Branch(
        id             = 3,
        organizationId = 33,
        name           = "エビス保育園"
      )
    )
    // 法人リスト
    private val organizationList = Seq(
      Organization(
        id    = 11,
        name  = "株式会社nextbeat",
        email = "nextbeat.net"
      ),
      Organization(
        id    = 22,
        name  = "株式会社カワサキ",
        email = "kawasaki.net"
      )
    )
  }
}