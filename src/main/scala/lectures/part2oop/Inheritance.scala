package lectures.part2oop

object Inheritance extends App {

  // single class inhertance
  class Animal {
    protected def eat() = println("chomp")
  }

  class Cat extends Animal {
    def crunch = {
      eat()
      println("yuck")
    }
  }

  val cat = new Cat
  cat.crunch
}
