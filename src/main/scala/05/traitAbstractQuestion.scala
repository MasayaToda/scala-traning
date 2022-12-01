object traitAbstractQuestion {
  def main(args: Array[String]): Unit = {
    // 問題
    
    println(Cuboid(2,3,4).calculate)
    println(Pyramid(2,3,4).calculate)
  }
  // 高さ のパラメータとcalculate(): Intという抽象メソッドをもった、abstract classを定義してください。
  // そのabstract classを継承した、直方体 と 四角錐(四角錐の底面は、長方形である) というクラスを定義してください。
  // 直方体と四角錐に高さ以外のパラメータが必要な場合は、コンストラクタとして受け取るようにすること。
  abstract class Solid(z:Int){
    def calculate():Int
  }
  // 直方体
  case class Cuboid(x:Int,y:Int,z:Int) extends Solid(z = z){
    override def calculate(): Int = {
      x * y * z
    }
  }
  // 四角錐
  case class Pyramid(x:Int,y:Int,z:Int) extends Solid(z = z){
    override def calculate(): Int = {
      (x * y * z) / 3
    }
  }
}