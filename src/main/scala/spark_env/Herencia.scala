package spark_env

object Herencia extends App {

  class Animal{

    protected def eat = println("nom nom")

  }


  class Cat extends Animal {

    def crunch = {eat}

  }

  val cat = new Cat
  cat.crunch

  class Dog extends Animal {

    override def eat = println("ñam ñam")

  }

  val newdog = new Dog
  newdog.eat

}
