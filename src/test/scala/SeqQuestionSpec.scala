import org.scalatest._
class SeqQuestionSpec extends FunSuite {
  val seq1 :Seq[Int] = Seq(1,2,3)
  val seq3 :Seq[Seq[Int]] = Seq(Seq(1,2),Seq(3,4),Seq(5,6))
  val seq41 :Seq[Int] = Seq(1,2,3,4,5,6)
  val seq42 :Seq[Int] = Seq(1,3,5,7)
  val seq51 :Seq[Option[Int]] = Seq(Some(12),Some(102))
  val seq52 :Seq[Option[Int]] = Seq(Some(12),Some(112))
  val seq61 :Seq[String] = Seq("a","b","cc","ddd","ee")
  val seq62 :Seq[String] = Seq("a","b","c")
  val seq71 :Seq[Int] = Seq(1,10,100,500)
  val seq72 :Seq[Int] = Seq(1,10,20,99)
  val seq81 :Seq[Int] = Seq(1,10,100,299)
  val seq82 :Seq[Int] = Seq()
  val seq91 :Seq[Int] = Seq(1,10,100,299)
  val seq101 :Seq[Int] = Seq(1,10,100)
  val seq102 :Seq[Int] = Seq(1,10)
  val seq103 :Seq[Int] = Seq()
  val seq11 :Seq[Int] = Seq(1,10,100,299)
  val seq121 :Seq[Int] = Seq(1,10,100,1000)
  val seq122 :Seq[Int] = Seq()
  test("02_Seq 問題1") {
    assert(SeqQuestion.seqQuestion1(seq1) === Seq(1,2,0))
  }
  test("02_Seq 問題2") {
    assert(SeqQuestion.seqQuestion2(seq1) === Seq(3))
  }
  test("02_Seq 問題3") {
    assert(SeqQuestion.seqQuestion3(seq3) === Seq(Seq(3,4),Seq(5,6)))
  }
  test("02_Seq 問題4") {
    assert(SeqQuestion.seqQuestion4(seq41) === 2)
    assert(SeqQuestion.seqQuestion4(seq42) === -1)
  }
  test("02_Seq 問題5") {
    assert(SeqQuestion.seqQuestion5(seq51) === Some(102))
    assert(SeqQuestion.seqQuestion5(seq52) === None)
  }
  test("02_Seq 問題6") {
    assert(SeqQuestion.seqQuestion6(seq61) === Seq("ccx","dddx","eex"))
    assert(SeqQuestion.seqQuestion6(seq62) === Seq())
  }
  test("02_Seq 問題7") {
    assert(SeqQuestion.seqQuestion7(seq71) === 200)
    assert(SeqQuestion.seqQuestion7(seq72) === 0)
  }
  test("02_Seq 問題8") {
    assert(SeqQuestion.seqQuestion8(seq81) === 300)
    assert(SeqQuestion.seqQuestion8(seq82) === 0)
  }
  test("02_Seq 問題9") {
    assert(SeqQuestion.seqQuestion9(seq91) === Seq(10,100))
  }
  test("02_Seq 問題10") {
    assert(SeqQuestion.seqQuestion10(seq101) === 101)
    assert(SeqQuestion.seqQuestion10(seq102) === 0)
    assert(SeqQuestion.seqQuestion10(seq103) === -1)
  }
  test("02_Seq 問題11") {
    assert(SeqQuestion.reverse(seq11) === Seq(299,100,10,1))
  }
  test("02_Seq 問題12") {
    assert(SeqQuestion.sum(seq121) === 1000000)
    assert(SeqQuestion.sum(seq122) === 1)
  }
  test("02_Seq 問題13") {
    assert(SeqQuestion.sum13(seq121) === 1111)
  }
  test("02_Seq 問題14") {
    assert(SeqQuestion.seqQuestion14() === 4)
  }
  test("02_Seq 問題15") {
    assert(SeqQuestion.seqQuestion15() === 12)
  }
}
