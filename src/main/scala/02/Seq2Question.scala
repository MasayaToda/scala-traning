import java.time.LocalDate
import scala.math._
import java.util.Comparator
object Seq2Question {
    // 学生のテストの結果
    case class Score(
        name:    String,    // 学生の名前
        english: Int,       // 英語の点数
        math:    Int,       // 数学の点数
        science: Int,       // 理科の点数
        date:    LocalDate  // 受験日
    )
    // 問題
    // 説明で例として使った Score について、 
    // 英語・数学・理科の3教科の合計点が高い順から学生名を並べたリストを作る以下の関数を実装してください
    // (ソートの説明で使ったいずれかの方法を使ってください。)
    def getTotalRanking(scoreSeq: Seq[Score]): Seq[String] = {
        scoreSeq.sortWith((scoreA, scoreB) => 
            scoreA.english + scoreA.math + scoreA.science >= scoreB.english + scoreB.math + scoreB.science
        ).map(score=>score.name)
    }
    // 問題2
    // Ordering[Option[String]] の値を作ってください。
    // その際、標準とは違って None が Some よりも後ろに並ぶようにしてください。
    // Option[String] 同士は String の通常のソート順にしてください。
    val nullsLastOptionStringOrdering: Ordering[Option[String]] = new NullsLastOptionStringOrdering
    class NullsLastOptionStringOrdering extends Ordering[Option[String]] {
        override def compare(x: Option[String], y: Option[String]): Int = {
            (x,y) match {
                case (None,None) => 0
                case (_,None)=> -1
                case (None,_)=> 1
                case (_,_)=> x.getOrElse("").compareTo(y.getOrElse(""))
            }
        }
    }
    /*
    keys に含まれる整数が
    1 なら名前順 (Ordering.String)
    2 なら英語の得点が高い順 (Ordering.Int.reverse)
    3 なら数学の得点が高い順 (Ordering.Int.reverse)
    4 なら理科の得点が高い順 (Ordering.Int.reverse)
    5 なら受験日順 (古いものから新しいもの)
    でソートする。それ(1〜5)以外の数字は無視する。
    keys が複数指定されていた場合は Seq の先頭から順番に比較する。
    kesy が空の場合はそのままソートせずに返す。
    またそれぞれマイナスがついていた場合は逆順でソートする。
    keys に同じ数字が複数回指定されていた場合、2つ目以降の指定は無視する。
    例えば Seq(-10, 5, 4, 0, -1, 2, 5, 1) は Seq(5, 4, -1, 2) として扱う。

    例) keys が Seq(-5, 1, 2, 3, 4) の場合：
    日付の新しい順で比較し、同じなら名前、それも同じなら英語、数学、理科の得点が高い順でソートする。
    */
    def sortScore(scoreSeq: Seq[Score], keys: Seq[Int]): Seq[Score] = {
        // 無駄なループを削減する
        // 2022/11/10修正：Filter条件を修正
        val filterdKeys = keys.distinct.filter(key => key != 0 && abs(key) >= 1 && abs(key) <= 5)
        // 無駄な数値のないKeyでループ
        // keyをOrderingの配列に変換
        // Orderingを結合
        val customOrdering = filterdKeys.map{
            case 1  => Ordering.by[Score,String](score => score.name)
            case -1 => Ordering.by[Score,String](score => score.name).reverse
            case 2  => Ordering.by[Score,Int](score => score.english).reverse
            case -2 => Ordering.by[Score,Int](score => score.english)
            case 3  => Ordering.by[Score,Int](score => score.math).reverse
            case -3 => Ordering.by[Score,Int](score => score.math)
            case 4  => Ordering.by[Score,Int](score => score.science).reverse
            case -4 => Ordering.by[Score,Int](score => score.science)
            case 5  => Ordering.fromLessThan[Score]((scoreA, scoreB) => scoreA.date.isAfter(scoreB.date))
            case -5 => Ordering.fromLessThan[Score]((scoreA, scoreB) => scoreA.date.isBefore(scoreB.date))
        }.reduce((a, o) => Ordering.comparatorToOrdering(a.thenComparing(o)))
        // 結合したOrderingでソートし、Seq[Score]を返す
        scoreSeq.sorted(customOrdering)
    }
    // 問題4
    // 同じく Seq[Score] を引数にとり、受験日からその日における学生名と3教科の合計点のマップへのマップを作る関数を実装してください。 
    // 2行目のように日付を入れ、学生名をいれるとその日の3教科の合計点が得られる Map の Map になっていれば OK です(Map なので存在しないキーを指定するとエラーになりますが、それは無視してください)。 
    // なお同じ日かつ同じ学生の Score が複数存在する場合は、合計点が1番大きいものが返るようにしてください。
    def getDateNameScoreMap(scoreSeq: Seq[Score])= {
        // Scoreの英語数学理科を合計したScoreDateクラス
        case class ScoreDate(
            name:    String,    // 学生の名前
            total: Int,       // 英語数学理科の合計点
            date:    LocalDate,  // 受験日
        )
        // 先にSeq[Score]をSeq[ScoreDate]に変換
        scoreSeq.map(score => ScoreDate(date = score.date,name = score.name,total = score.english + score.math + score.science))
        // それをMap[LocalDate,Seq[ScoreDate]]に変換
        .groupBy(scoreDate => scoreDate.date)
        // tuple(LocalDate,Seq[ScoreDate])から、Seq[ScoreDate]を降順ソート
        .transform((date,scoreDateSeq) => scoreDateSeq.sorted(Ordering.by[ScoreDate,Int](scoreDate => scoreDate.total).reverse)
        // ソート後、Map[String,Seq[ScoreDate]]に変換
            .groupBy(scoreDate => scoreDate.name)
            // Map[String,Seq[ScoreDate]]のSeq[ScoreDate]
            .transform((name,scoreDateSeq) => scoreDateSeq.map(scoreDate => scoreDate.total)
                // 先頭要素を取得しIntにする
                .headOption.getOrElse(0)
             )
        )
    }
}