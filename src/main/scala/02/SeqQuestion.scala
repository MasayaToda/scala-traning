object  SeqQuestion {
  def main(args: Array[String]): Unit = {
    // 問題1
    val seq :Seq[Int] = Seq(1,2,3)
    println(seqQuestion1(seq))
    // 問題2
    println(seqQuestion2(seq))
    // 問題3
    val seqseq :Seq[Seq[Int]] = Seq(Seq(1,2),Seq(3,4),Seq(5,6))
    println(seqQuestion3(seqseq))
    // 問題4:パターン1
    val seqEven :Seq[Int] = Seq(1,2,3,4,5,6)
    println(seqQuestion4(seqEven))
    // 問題4:パターン2
    val seqOdd :Seq[Int] = Seq(1,3,5,7)
    println(seqQuestion4(seqOdd))
    // 問題5:パターン1
    val seqOpt1 :Seq[Option[Int]] = Seq(Some(12),Some(102))
    println(seqQuestion5(seqOpt1))
    // 問題5:パターン2
    val seqOpt2 :Seq[Option[Int]] = Seq(Some(12),Some(112))
    println(seqQuestion5(seqOpt2))
    // 問題6:パターン1
    val seqStr1 :Seq[String] = Seq("a","b","cc","ddd","ee")
    println(seqQuestion6(seqStr1))
    // 問題6:パターン2
    val seqStr2 :Seq[String] = Seq("a","b","c")
    println(seqQuestion6(seqStr2))
    // 問題7:パターン1
    val seqNum1 :Seq[Int] = Seq(1,10,100,500)
    println(seqQuestion7(seqNum1))
    // 問題7:パターン2
    val seqNum2 :Seq[Int] = Seq(1,10,20,99)
    println(seqQuestion7(seqNum2))
    // 問題8:パターン1
    val seq8Num1 :Seq[Int] = Seq(1,10,100,299)
    println(seqQuestion8(seq8Num1))
    // 問題8:パターン2
    val seq8Num2 :Seq[Int] = Seq()
    println(seqQuestion8(seq8Num2))
    // 問題9
    val seq9Num :Seq[Int] = Seq(1,10,100,299)
    println(seqQuestion9(seq9Num))
    // 問題10:パターン1
    val seq10Num1 :Seq[Int] = Seq(1,10,100)
    println(seqQuestion10(seq10Num1))
    val seq10Num2 :Seq[Int] = Seq(1,10)
    println(seqQuestion10(seq10Num2))
    val seq10Num3 :Seq[Int] = Seq()
    println(seqQuestion10(seq10Num3))
    // 問題11
    val seq11 :Seq[Int] = Seq(1,10,100,299)
    println(reverse(seq11))
    // 問題12：パターン1
    val seq12Num1 :Seq[Int] = Seq(1,10,100,299)
    println(sum(seq12Num1))
    // 問題12:パターン２
    val seq12Num2 :Seq[Int] = Seq()
    println(sum(seq12Num2))
    // 問題13
    println(sum13(seq12Num1))
    // println(sum13(seq12Num2))
    // 問題14
    println(seqQuestion14())
    // 問題15
    println(seqQuestion15())
  }
  // 問題1
  // Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。
  // numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。
  def seqQuestion1(numSeq: Seq[Int]):Seq[Int] = {
    // 2022/11/8修正:if文を使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量がかえって多くなったため、もとの実装に修正
    numSeq.map(num => if (num % 3 == 0) 0 else num)
  }
  // 問題2
  // Seq[Int]型である、numSeqが引数として渡されるseqQuestion2メソッドがあります。 
  // numSeqのうち3の倍数のみを返すメソッドをfilterを使って作成してください。
  def seqQuestion2(numSeq: Seq[Int]):Seq[Int] = {
    numSeq.filter(num => num%3 == 0)
  }
  // 問題3
  // Seq[Seq[Int]]型である、numSeqSeqが引数として渡されるseqQuestion3メソッドがあります。 
  // numSeqSeqのうち3の倍数を含むSeqのみを返すメソッドをfilterとexistsを使って作成してください。
  def seqQuestion3(numSeqSeq: Seq[Seq[Int]]):Seq[Seq[Int]] = {
    numSeqSeq.filter(numSeq => numSeq.exists(num => num%3 == 0))
  }
  // 問題4
  // Seq[Int]型である、numSeqが引数として渡されるseqQuestion4メソッドがあります。 
  // numSeqに偶数が含まれていればその最初の値を、含まれていない場合は-1を返すメソッドをfindを使って作成してください。
  def seqQuestion4(numSeq: Seq[Int]):Int = {
    // 2022/11/8修正:if文とOption#getを使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量が少なくなるように修正
    numSeq.find(num => num % 2 == 0).getOrElse(-1)
  }
  // 問題5
  // Seq[Option[Int]]型である、numOptSeqが引数として渡されるseqQuestion5メソッドがあります。 
  // numOptSeqのうち、数値0を含む最初のOption[Int]を返すメソッドをfindとcontainsを使って作成してください。 
  // 数値0がない場合はNoneを返す用に実装してください。例） numOptSeq = Seq(Some(12), Some(102))の場合は、Some(102)が戻されます。
  def seqQuestion5(numOptSeq: Seq[Option[Int]]):Option[Int]= {
    // 2022/11/8修正:if文とOption#getを使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量が少なくなるように修正
    numOptSeq.flatten.find(num => num.toString.map(_.asDigit).contains(0))
  }
  // 問題6
  // Seq[String]型である、strSeqが引数として渡されるseqQuestion6メソッドがあります。
  // strSeqのうち文字列の長さが2以上であるものの末尾に"x”を追加し、それらのみを含むSeqを返すメソッドを、collectを使って作成してください。
  def seqQuestion6(strSeq: Seq[String]):Seq[String]= {
     strSeq.collect{
      case str if str.length >= 2 => str+"x"
     }
  }
  // 問題7
  // Seq[Int]型であるnumSeqが引数として渡されるseqQuestion7メソッドがあります。 
  // numSeqのうち値が100以上である最初のIntを2倍した値を返すメソッドを作成してください。
  // 100以上の値がない場合は0を返してください。 メソッドはcollectFirstを使って作成してください。
  def seqQuestion7(numSeq: Seq[Int]):Int= {
    // 2022/11/8修正:if文とOption#getを使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量が少なくなるように修正
     numSeq.find(num => num >= 100 ).getOrElse(0)*2
  }
  // 問題8
  // Seq[Int]であるnumSeqが引数として渡されるseqQuestion8メソッドがあります。
  // このうち先頭の値と末尾の値を足し合わせた値(Int)を、 Seqが空である場合は0を返すメソッドをheadOptionとlastOptionを用いて作成してください。
  def seqQuestion8(numSeq: Seq[Int]):Int= {
    // 2022/11/8修正:if文とOption#getを使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量が少なくなるように修正
    numSeq.headOption.getOrElse(0) + numSeq.lastOption.getOrElse(0)
  }
  // 問題9
  // Seq[Int]である長さ3以上のnumSeqが引数として渡されるseqQuestion9メソッドがあります。 
  // このうち先頭の値と末尾の値を除いたSeq[Int]を取得するメソッドをinitとtailを用いて作成してください。
  def seqQuestion9(numSeq: Seq[Int]):Seq[Int]= {
     numSeq.init.tail
  }
  // 問題10
  // Seq[Int]型である、numSeqが引数として渡されるseqQuestion10メソッドがあります。 numSeqの要素数が3以上の場合、最初の値と最後の値を足した値を返すメソッドを作成してください。 
  // numSeqが要素が2以下、1以上の場合は0を、numSeqが空の場合は-1を返してください。 メソッドの作成にはmatch式と:+, +:などを用いてください。
  def seqQuestion10(numSeq: Seq[Int]):Int= {
    numSeq match{
      case head +: num +: _ :+ end => head + end
      case Seq(head,end) => 0
      case Seq(num)  => 0
      case Nil => -1
     }
  }
  // 問題11
  // foldLeftを用いて、Seqの要素を反転させる次のシグニチャを持ったメソッドreverseを実装してみましょう。
  def reverse[T](list: Seq[T]): Seq[T] = {
    list.foldLeft(List[T]())((x, y) => y :: x)
  }
  // 問題12
  // Seqの全ての要素を掛け合わせるメソッドsumをfoldRightを用いて実装してみましょう。
  // Seqが空のときは1を返してみましょう。
  def sum(list: Seq[Int]): Int = {
    list.foldRight(1)((x,y) => x * y)
  }
  // 問題13
  // 問題12でreduceを使ってSeqが空の場合、エラーを吐くようにしましょう。
  def sum13(list: Seq[Int]): Int = {
    list.reduce((x, y)=> x + y)
  }
  // 問題14
  // Seq(3×4, 4×2, 4×1)の最小値を出力しましょう。
  def seqQuestion14(): Int = {
    Seq(3*4,4*2,4*1).min
  }
  // 問題15
  // Seq(3×4, 4×2, 4×1)の最大値を出力しましょう。
  def seqQuestion15(): Int = {
    Seq(3*4,4*2,4*1).max
  }
}