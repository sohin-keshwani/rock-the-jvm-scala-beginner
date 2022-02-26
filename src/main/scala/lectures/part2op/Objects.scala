package lectures.part2op

object Objects extends App {

  // below object and class pair is called companion class/object

  // this is signleton
  object Person {
    def apply(mother: Person, father: Person, who: String) : Person = new Person(who)
  }

  class Person(val name: String)

  println(Person(new Person("Faj"), new Person("Shohin"), "Zeeshu").name)
}
