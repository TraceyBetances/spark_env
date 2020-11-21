package spark_env

object ClasesObjetos extends App {

  object Person{

    val ojos = 2

    def puedoVolar: Boolean = false
    def from(mother: Person, father: Person): Person = new Person("Yoruichi")

  }

  class Person(val name: String){

  }

  val molleta = new Person("Molleta")
  val molleto = new Person("Molleto")

  val bobbie = Person.from(molleta, molleto)

  //def main(args: Array[String]): Unit = {
  //
  //}

}
