object tupleCaseClassQuestion {
  def main(args: Array[String]): Unit = {
    val company:(String,String,String) = ("nextbeat","03-5423-6131","東京都渋谷区恵比寿4丁目9-10")
    println(company)
    println(company._2)
    case class Company(companyName:String,phoneNumber:String,address:String)
    val nextbeat = Company("nextbeat","03-5423-6131","東京都渋谷区恵比寿4丁目9-10")
    println(nextbeat)
    val nextbeatJP = nextbeat.copy(companyName = "ネクストビート")
    println(nextbeatJP)
  }
  // 問題
  // 会社」を表す値を、tuple, case classを使って表現しましょう。
  // 会社には、

  // 会社名
  // 電話番号
  // 住所(任意項目)
  // が含まれるように定義する。

  // 1. 会社を表す値を持ったtupleを定義してください。
  // 会社名は nextbeat
  // 電話番号は 03-5423-6131
  // 住所は 東京都渋谷区恵比寿4丁目9-10
  // とすること

  // 2. 1で定義したtupleから、電話番号の値が含まれる値を取得してください
  // 3. 会社を表すパラメータをもったCompanyというcase class を定義してください
  // 4. 3で定義したCompanyクラスから、インスタンスを生成してください。
  // 会社名は nextbeat
  // 電話番号は 03-5423-6131
  // 住所は 東京都渋谷区恵比寿4丁目9-10
  // とすること

  // 5. 4で生成したインスタンスのcopyメソッドを使って会社名を置き換えてください。
  // 会社名を ネクストビート
  // で置き換えること
  
  
}