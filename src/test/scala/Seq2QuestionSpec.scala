import org.scalatest._
import java.time.LocalDate
class Seq2QuestionSpec extends FunSuite {
  val seq2Q1 :Seq[Seq2Question.Score] = Seq(
    Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
    Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
    Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
    Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
  )
  val seq2Q21 :Seq[Option[String]] = Seq(
    Some("Alice"),
    None,
    Some("Bob"),
    Some("Charlie"),
    Some("Dave"),
  )
  val seq2Q22 :Seq[Option[String]] = Seq(
    Some("Alice"),
    None,
    Some("ボブ"),
    Some("ちゃーりー"),
    Some("出伊武"),
  )
  val seq2Q4 :Seq[Seq2Question.Score] = Seq(
    Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
    Seq2Question.Score(name = "Alice",   english = 80,  math = 80, science = 30, date = LocalDate.of(2020, 1, 30)),
    Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
    Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
    Seq2Question.Score(name = "Charlie", english = 100, math = 80, science = 100, date = LocalDate.of(2020, 1, 26)),
    Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
  )
  test("02_Seq応用 問題１") {
    assert(Seq2Question.getTotalRanking(seq2Q1) === Seq("Charlie", "Dave", "Bob", "Alice"))
  }
  test("02_Seq応用 問題２") {
    assert(seq2Q21.sorted(Seq2Question.nullsLastOptionStringOrdering) === Seq(Some("Alice"), Some("Bob"), Some("Charlie"), Some("Dave"),None))
  }
  test("02_Seq応用 問題3") {
    assert(Seq2Question.sortScore(seq2Q1,Seq(1))=== Seq(
      Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
    ))
    assert(Seq2Question.sortScore(seq2Q1,Seq(-2,1))=== Seq(
      Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
    ))
    assert(Seq2Question.sortScore(seq2Q1,Seq(0,3,6,2,-10,1))=== Seq(
      Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
    ))
    assert(Seq2Question.sortScore(seq2Q1,Seq(5,1))=== Seq(
      Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
    ))
    assert(Seq2Question.sortScore(seq2Q1,Seq(5,5,1,1))=== Seq(
      Seq2Question.Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30)),
      Seq2Question.Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26)),
      Seq2Question.Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26)),
    ))
  }
  test("02_Seq応用 問題4") {
    // assert(Seq2Question.getDateNameScoreMap(seq2Q1)(LocalDate.of(2020, 1, 30))("Alice") == 177)
    println(Seq2Question.getDateNameScoreMap(seq2Q4))
  }
  test("02_Seq応用 XX") {
    assert(Seq2Question.getDateNameScoreMap(seq2Q1)(LocalDate.of(2020, 1, 30))("Alice") == 177)
  }
}
