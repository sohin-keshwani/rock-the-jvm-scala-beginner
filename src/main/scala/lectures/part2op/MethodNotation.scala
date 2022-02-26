package lectures.part2op

object MethodNotation extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int) {
    def likes(movie: String) = favouriteMovie == movie
    def +(person: Person) = s"$name is hanging out with ${person.name}"
    def +(nick: String) = new Person(s"$name ($nick)", favouriteMovie, age)
    def unary_! : String = s"$name wtf!"
    def unary_+ : Person = {
      new Person(name, favouriteMovie, age + 1)
    }

    def learns(thing: String) = s"$name learns $thing"
    def learnsSomething = this learns "to cook"

    def apply()  = s"Hi, my name is $name, I am $age years old and I like $favouriteMovie"
    def apply(n: Int) = s"$name has seen $favouriteMovie $n times"
    def apply(s: String) = s"$name Loves $s forever and ever"
  }

  val shohin = new Person("Shohin", "12 Angry Men", 37)
  println(shohin likes "12 angry men")

  val faj = new Person("Faj", "Shawshank Redemption", 48)

  println(faj + shohin)
  println((faj + "fiju").apply())
  println(!faj)

  println(faj())

  println((+faj).apply())

  println(faj.learnsSomething)
  println(faj(2))
  println(faj(shohin.name))
}
