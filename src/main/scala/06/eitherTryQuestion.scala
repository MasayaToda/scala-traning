import scala.util.Try
object eitherTryQuestion {
  def main(args: Array[String]): Unit = {
    // 問題１
    // 上記の2行目の値は、Either[A, B] となりますが、この場合の、型A, 型Bを答えてください。
    println(eitherTryQuestion1())
    // 型A:ExceptionMessage
    // 型B:UserId
    // 問題２
    val either1: Either[String, Int] = Right(200)
    val either2: Either[String, Int] = Left("Not Found")
    // val either2: Either[String, Int] = Right(100)
    val either3: Either[String, Int] = Right(100)

    val v = for {
      val1 <- either1
      val2 <- either2
      val3 <- either3
    } yield {
      val1 * val2 * val3
    }

    v.foreach(i => println(i))
    // 出力結果について、IntとStringの積がなされているため、出力なし

    // 問題3
    // 2022/11/8修正：either4の右辺から.right.map(u => u)が不要なため除去
    val tryval:Try[Int] = Try(0)
    // val tryval:Try[Int] = Try(None)
    val either4: Either[String, Int] = tryval.toEither.left.map(s => s.getMessage)
    println(either4)

    // 問題4
    // 説明：対象のEitherがRight(正常)の場合、fb(b)を実行、Left(異常)の場合、fa(a)を実行する
    // def fold[C](fa: A => C, fb: B => C): C = this match {
    //   case Right(b) => fb(b)
    //   case Left(a)  => fa(a)
    // }
    // 問題5
    // Try.toOptionがどういう実装になっているか説明してください。
    // 説明:実装は以下のようになっていた
    // https://www.scala-lang.org/api/2.11.7/scala/util/Try.html
    // def toOption: Option[T] = if (isSuccess) Some(get) else None
    // つまり、成功の場合Someをとり、失敗の時Noneを取る
  }
  // 問題1
  def eitherTryQuestion1()={
    val loginRes = LoginApplication.login(UserId(1))
    loginRes.left.map(s => ExceptionMessage(s)).right.map(u => u.id)
  }
  case class UserId(id: Int)
  case class User(id: UserId, name: String)
  case class ExceptionMessage(message: String)
  object LoginApplication {
    def login(id: UserId): Either[String, User] = {
      // implement 
      // Left("500")
      Right(User(id,"戸田"))
    }
  }

}