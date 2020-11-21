package Practice

object Object extends App {

  object Person{

    val ojos = 2

    def puedoVolar: Boolean = false

  }

  println(Person.ojos)
  println(Person.puedoVolar)

  val croqueta = Person
  val yoruichi = Person

  println(croqueta == yoruichi)

  class Person{



  }

}
