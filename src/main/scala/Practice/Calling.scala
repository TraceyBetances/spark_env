package Practice

object Calling extends App {

  def CallValue(a: Long): Unit = {

    println("By value " + "699982979867400")
    println("By value " + "699982979867400")

  }

  def CallName(x: => Long): Unit = {

    println("By name " + System.nanoTime())
    println("By name " + System.nanoTime())

  }

  //CallValue(System.nanoTime())
  //CallName(System.nanoTime())

  def SumaA(a: Int, b: Int = 2): Int = {

    a + b
  }

  println(SumaA(3))

  val name = "Yorusaya"
  val age = 12
  val frase = s"Hola me llamo $name y tengo $age años croquetos"

  println(frase)

}