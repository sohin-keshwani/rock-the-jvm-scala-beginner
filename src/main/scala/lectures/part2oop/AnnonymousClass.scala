package lectures.part2oop

object AnnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal = new Animal {
    override def eat: Unit = println("hahahahhahha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name, how can I help you?")
  }

  val jim = new Person("jim") {
    override def sayHi: Unit = println(s"Hi my name is Jim, how can I be of service to you?")
  }

  jim.sayHi

  val jimAgain = new Person("Jim")

  jimAgain.sayHi
}
