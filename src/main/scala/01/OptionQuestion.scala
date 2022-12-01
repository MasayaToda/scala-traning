object OptionQuestion {
  def main(args: Array[String]): Unit = {
    // 問題1実行パターン1:引数=Someの場合
    val some :Option[Int] = Some(2)
    println(optionQuestion1(some))
    // 問題1実行パターン2:引数=Noneの場合
    val none :Option[Int] = None
    println(optionQuestion1(none))
    // 問題2実行パターン1:引数=Someの場合
    println(optionQuestion2(some))
    // 問題2実行パターン2:引数=Noneの場合
    println(optionQuestion2(none))
    // 問題3実行
    optionQuestion3()
    val some2 :Option[Option[Int]] = Some(Some(2))
    val none2 :Option[Option[Int]] = None
    // 問題4実行パターン1:引数=Someの場合
    println(optionQuestion4(some2))
    // 問題4実行パターン2:引数=Noneの場合
    println(optionQuestion4(none2))
  } 
  // 問題１
  // Option[Int]型である、numが引数として渡されるメソッドoptionQuestion1があります。
  // Someの場合はその値を、Noneの場合は０を返却するメソッドを、getOrElseメソッドを使って作成してください。
  def optionQuestion1(num: Option[Int]):Int = {
    // 2022/11/8修正:returnを書かないように修正
    num.getOrElse(0) 
  }
  // 問題2
  // Option[Int]型である、numが引数として渡されるoptionQuestion2メソッドがあります。
  // Someの場合はその値に3を足したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを、mapメソッドを使って作成してください。
  def optionQuestion2(num: Option[Int]):Option[Int] = {
    // 2022/11/8修正:returnを書かないように修正
    num.map(i => i + 3)
  }
  // 問題3
  // val strOpt: Option[String] = Some("") を定義し、それに対してisEmpty, isDefined を実行した場合にどのような挙動をするか確かめてください。
  def optionQuestion3() = {
    // 2022/11/9修正:if文を利用しないように修正
    val strOpt: Option[String] = Some("")
    println(s"isEmptyは${strOpt.isEmpty}です")
    println(s"isEmptyは${strOpt.isDefined}です")
    strOpt.isEmpty && strOpt.isDefined
  }
  // 問題4
  // Option[Option[Int]]型である、numが引数として渡されるoptionQuestion4メソッドがあります。
  // Someの場合はその値を2倍したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを作成してください。
  def optionQuestion4(num: Option[Option[Int]]):Option[Int] = {
    // 2022/11/9修正:if文を利用しないように修正
    num.flatten.map(n => n * 2)
  }
  // 問題4-2 ※追加課題
  // 問題4をflatMapを使って実装してください。
  def optionQuestion42(num: Option[Option[Int]]):Option[Int] = {
    // 2022/11/9修正:if文を利用しないように修正
    num.flatMap(n => n.map(nn => nn *2))
  }
  // 問題4-3 ※追加課題
  // 問題4をfor~yieldを使って実装してください。
  def optionQuestion43(num: Option[Option[Int]]):Option[Int] = {
    // 2022/11/9修正:引数型が間違っていた箇所を修正、if文を利用しないように修正
    for {
      numOption <- num
      n <- numOption
    } yield n * 2
  }
}