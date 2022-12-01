import org.scalatest._
class MapQuestionSpec extends FunSuite {
  val fruits = Map("りんご" -> 100, "みかん" -> 80, "ぶどう" -> 300)
  test("03_Map 問題1") {
    assert(mapQuestion.mapQuestion1(fruits) === 80)
  }
  test("03_Map 問題2") {
    assert(mapQuestion.mapQuestion2(fruits) === 0)
  }
  test("03_Map 問題3") {
    assert(mapQuestion.mapQuestion3(fruits,"いちご") === false)
    assert(mapQuestion.mapQuestion3(fruits,"ぶどう") === true)
  }
  test("03_Map 問題3-2") {
    assert(mapQuestion.mapQuestion32(fruits,Seq("ぶどう","みかん")) === true)
    assert(mapQuestion.mapQuestion32(fruits,Seq("ぶどう","いちご")) === false)
    assert(mapQuestion.mapQuestion32(fruits,Nil) === true)
  }
  test("03_Map 問題3-3") {
    assert(mapQuestion.mapQuestion33(fruits,Seq("ぶどう","みかん")) === true)
    assert(mapQuestion.mapQuestion33(fruits,Seq("ぶどう","いちご")) === false)
    assert(mapQuestion.mapQuestion33(fruits,Nil) === false)
  }
  test("03_Map 問題3-4") {
    assert(mapQuestion.mapQuestion34(fruits,Seq("りんご","みかん")) === true)
    assert(mapQuestion.mapQuestion34(fruits,Seq("ぶどう","いちご")) === true)
    assert(mapQuestion.mapQuestion34(fruits,Seq("なし","いちご")) === false)
  }
  test("03_Map 問題4") {
    assert(mapQuestion.mapQuestion4(fruits) === Map("りんご" -> "100円", "みかん" -> "80円", "ぶどう" -> "300円"))
  }
  test("03_Map 問題5") {
    assert(mapQuestion.mapQuestion5() === Map(true->Seq(2,4),false->Seq(1,3,5)))
  }
}
