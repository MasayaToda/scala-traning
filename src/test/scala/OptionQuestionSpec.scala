import org.scalatest._
class OptionQuestionSpec extends FunSuite {
  val num = 2
  val some :Option[Int] = Some(num)
  val some2 :Option[Option[Int]] = Some(Some(num))
  val none :Option[Int] = None
  val none2 :Option[Option[Int]] = Some(None)
  test("01_Option 問題1") {
    assert(OptionQuestion.optionQuestion1(some) === num)
    assert(OptionQuestion.optionQuestion1(None) === 0)
  }
  test("01_Option 問題2") {
    assert(OptionQuestion.optionQuestion2(some) === Some(num+3))
    assert(OptionQuestion.optionQuestion2(None) === None)
  }
  test("01_Option 問題3") {
    // 動作確認のためテストパターンなし
  }
  test("01_Option 問題4") {
    assert(OptionQuestion.optionQuestion4(some2) === Some(num*2))
    assert(OptionQuestion.optionQuestion4(None) === None)
    assert(OptionQuestion.optionQuestion4(none2) === None)
  }
  test("01_Option 問題4-2") {
    // 追加問題
    assert(OptionQuestion.optionQuestion42(some2) === Some(num*2))
    assert(OptionQuestion.optionQuestion42(None) === None)
    assert(OptionQuestion.optionQuestion42(none2) === None)
  }
  test("01_Option 問題4-3") {
    // 追加問題
    assert(OptionQuestion.optionQuestion43(some2) === Some(num*2))
    assert(OptionQuestion.optionQuestion43(None) === None)
    assert(OptionQuestion.optionQuestion43(none2) === None)
  }
}
