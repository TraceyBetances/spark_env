package spark_env

object AbstractClass extends App {

  abstract class Animal {

    val tipoCriatura: String
    def eat: Unit

  }

  class Dog extends Animal {

    val tipoCriatura: String = "Canino"

    def eat: Unit = println("crunch crunch")

  }

  trait Carnivoro {

    def eat(animal: Animal): Unit

  }

}
