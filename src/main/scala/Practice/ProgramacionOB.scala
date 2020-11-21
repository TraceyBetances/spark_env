package Practice

object ProgramacionOB extends App{

  val persona1 = new Person("Yoruichi ", 7)
  val persona2 = new Person("Hitsugaya ", 1)
  val persona3 = new Person("Croqueta ", 28)
  val persona4 = new Person("Nolletito ", 30)

  println(persona1.saludar())
  println(persona2.saludar())
  println(persona3.saludar())
  println(persona4.saludar())

}

  val a = 2


class Person(name: String, age: Int) {

  def saludar(name: String): String = {

    this.name + age
  }

  def saludar(): String = {

    name + age
  }


}