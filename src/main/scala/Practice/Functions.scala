package Practice

import org.apache.spark.sql.types._

object Functions extends App {

  def FunctionA(a: String, b: Int): String = {

    a + " putito numero " + b

  }

  println(FunctionA("Hola", 1))

}
