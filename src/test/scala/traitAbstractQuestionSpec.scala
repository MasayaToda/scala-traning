import org.scalatest._
class traitAbstractQuestionSpec extends FunSuite {
  test("05_traitAbstract 問題1") {
    assert(traitAbstractQuestion.Cuboid(2,3,4).calculate === 24)
  }
  test("05_traitAbstract 問題2") {
    assert(traitAbstractQuestion.Pyramid(2,3,4).calculate === 8)
  }
}
