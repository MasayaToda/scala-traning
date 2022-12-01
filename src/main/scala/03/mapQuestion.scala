object  mapQuestion {
  def main(args: Array[String]): Unit = {
    // 果物の価格を表したMap
    val fruits = Map("りんご" -> 100, "みかん" -> 80, "ぶどう" -> 300)
    println(mapQuestion1(fruits))
    println(mapQuestion2(fruits))
    println(mapQuestion3(fruits,"ぶどう"))
    println(mapQuestion3(fruits,"いちご"))
    println(mapQuestion32(fruits,Seq("ぶどう","いちご")))
    println(mapQuestion32(fruits,Nil))
    println(mapQuestion33(fruits,Seq("ぶどう","いちご")))
    println(mapQuestion33(fruits,Nil))
    println(mapQuestion34(fruits,Seq("ぶどう","いちご")))
    println(mapQuestion4(fruits))
    println(mapQuestion5())
  }
  // 問題1
  // みかんの価格を取得してみましょう。
  def mapQuestion1(map: Map[String,Int]):Int = {
    map.get("みかん").get
  }
  // 問題2
  // Mapに存在しない「"いちご"」を指定してgetメソッドで価格を取得しようとしたとき、どうなるかやってみてください。
  // このように、存在しなかった場合は「0」というデフォルト値を返すようにするにはどうすればいいでしょうか？
  def mapQuestion2(map: Map[String,Int]):Int = {
    map.getOrElse("いちご",0)
  }
  // 問題3
  // fruitsの中に、特定のキーが存在するかを調べるにはどんな方法がありますか？また、それを使って「ぶどう」と「いちご」の存在判定をしてみてください。
  def mapQuestion3(map: Map[String,Int],keyword:String):Boolean = {
    map.contains(keyword)
  }
  // 問題3-2
  // fruitsと、「ぶどう」「いちご」のような値をもつcheckSeq:Seq[String]を引数として受け取り、checkSeqの「ぶどう」「いちご」の両方がfruitsのキーに存在する場合に、trueを返すメソッドを定義してください。 
  // checkSeqの値がNilの場合は、不正入力値として true を返してください。
  def mapQuestion32(map: Map[String,Int],checkSeq:Seq[String]):Boolean = {
    // 2022/11/8修正:if文を使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量がより少ない記述に修正
    checkSeq.forall(key=>map.contains(key))
  }
  // 問題3-3
  // fruitsと、「ぶどう」「いちご」のような値をもつcheckSeq:Seq[String]を引数として受け取り、checkSeqの「ぶどう」「いちご」の両方がfruitsのキーに存在する場合に、trueを返すメソッドを定義してください。
  // checkSeqの値がNilの場合は、不正入力値として false を返してください。
  def mapQuestion33(map: Map[String,Int],checkSeq:Seq[String]):Boolean = {
    // 2022/11/8修正:if文を使用せずに、パターンマッチするように修正
    // 2022/11/8修正:コード量がより少ない記述に修正
    checkSeq match{
      case Nil => false
      case _ => {
        checkSeq.forall{
          case key => map.contains(key)
        }
      }
    }
  }
  // 問題3-4
  // fruitsと、「ぶどう」「いちご」のような値をもつcheckSeq:Seq[String]を引数として受け取り、checkSeqの「ぶどう」「いちご」の1つでもfruitsのキーに存在する場合に、trueを返すメソッドを定義してください。
  def mapQuestion34(map: Map[String,Int],checkSeq:Seq[String]):Boolean = {
    // 2022/11/8修正:if文を使用せずに、パターンマッチするように修正
    // 2022/11/8修正:mapをSeqに変換しないように修正
    checkSeq.exists(key=>map.contains(key))
  }
  // 問題4
  // Mapの各値に「円」をつけたMapに変換してみてください。
  def mapQuestion4(map: Map[String,Int]):Map[String,String] = {
    map.mapValues(_ + "円")
  }
  // 問題5
  def mapQuestion5() = {
    val numbers = Seq(1,2,3,4,5)
    numbers.groupBy(_%2==0)
  }
}