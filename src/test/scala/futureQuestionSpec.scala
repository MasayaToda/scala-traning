import org.scalatest._
// Futureを使えるようにimport
import scala.concurrent.Future
import scala.util.{Success, Failure}
// おまじないだと思って無視してください
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

class futureQuestionSpec extends FunSuite {
  test("07_future 問題1") {
    val result = futureQuestion.futureQuestion1(1)
    result.onComplete{
      case Success(organization) => {
        assert(organization === "株式会社nextbeat")
      }
    }
    Await.result(result, Duration.Inf)
  }
  test("07_future 問題2") {
    // テストパターンなし
  }
  test("07_future 問題3") {
    val start = System.currentTimeMillis()
    val futures =(1 to 3).toList.map{ i => futureQuestion.futureQuestion1(i)}
    var results = Future.sequence(futures)
    results.onComplete{
      case Success(organization) => {
        val end = System.currentTimeMillis()
        assert((end - start) <= 4000)
      }
      case Failure(e) => {
        val end = System.currentTimeMillis()
        assert((end - start) <= 4000)
      }
    }
    Await.ready(results, Duration.Inf)
  }
}
