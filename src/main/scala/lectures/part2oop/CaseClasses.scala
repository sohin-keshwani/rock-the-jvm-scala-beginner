package lectures.part2oop
/*
more like BO
*/
object CaseClasses extends App {
  case class Person(name: String, age: Int)
  // we can skip new keyword while making the object because of companion object with apply method which is bundled in case classes
  val shohin = Person("Shohin", 34)
  println(shohin.name)
  println(shohin.toString)
  println(shohin == Person("shohin", 34))
  println(shohin == shohin)
  println(shohin == Person("Faj", 48))

  println(shohin.copy(age = 49))

  println(Person)

  //CS are serializable.

}
