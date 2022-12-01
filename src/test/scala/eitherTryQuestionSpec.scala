import org.scalatest._
import scala.util.Try
class eitherTryQuestionSpec extends FunSuite {
  test("06_eitherTry 問題1") {
    assert(eitherTryQuestion.eitherTryQuestion1() === Right(eitherTryQuestion.UserId(1)))
  }
  test("06_eitherTry 問題2") {
    // テストパターンなし
  }
  test("06_eitherTry 問題3") {
    val tryval:Try[Int] = Try(0)
    val either4: Either[String, Int] = tryval.toEither.left.map(s => s.getMessage).right.map(u => u)
    assert(either4 === either4)
  }
  test("06_eitherTry 問題4") {
    // テストパターンなし
  }
  test("06_eitherTry 問題5") {
    // テストパターンなし
  }
}
