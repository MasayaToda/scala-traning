import org.scalatest._
class tupleCaseClassQuestionSpec extends FunSuite {
  val company:(String,String,String) = ("nextbeat","03-5423-6131","東京都渋谷区恵比寿4丁目9-10")
  case class Company(companyName:String,phoneNumber:String,address:String)
  val nextbeat = Company("nextbeat","03-5423-6131","東京都渋谷区恵比寿4丁目9-10")
  test("04_tupleCaseClass 問題1") {
    assert(company === ("nextbeat","03-5423-6131","東京都渋谷区恵比寿4丁目9-10"))
  }
  test("04_tupleCaseClass 問題2") {
    assert(company._2 === "03-5423-6131")
  }
  test("04_tupleCaseClass 問題3") {
    assert(nextbeat === nextbeat)
  }
  test("04_tupleCaseClass 問題4") {
    val nextbeatJP = nextbeat.copy(companyName = "ネクストビート")
    println(nextbeatJP)
    assert(nextbeatJP === Company("ネクストビート","03-5423-6131","東京都渋谷区恵比寿4丁目9-10"))
  }
}
