package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val list: List[Int] = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  println(list.map(_+1))
  println(list.map(_ + " is a number"))

  println(list.filter(_%2 == 0))

  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair(_)))

  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)


  val reverseCombinations = chars.flatMap(c => numbers.map(n => "" + c + n))
  println(reverseCombinations)

  val ys = Map("a" -> List(1 -> 444,1 -> 111), "b" -> List(2 -> 555,2 -> 222)).flatMap(_._2)
  println(ys)

  list.foreach(println)

  // for - comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
  } yield "" + c + n

  println(forCombinations)

  val forReverseCombination = for {
    c <- chars
    n <- numbers if n % 2 == 0
  } yield "" + c + n

  println(forReverseCombination)

  case class User(name: String, age: Int)
  val userBase = List(
    User("Travis", 28),
    User("Kelly", 33),
    User("Jennifer", 44),
    User("Dennis", 23))

  val evenAgedUsers = for {
    user <- userBase if user.age >= 20 && user.age < 30 && user.age % 2 == 0
  } yield user

  println(evenAgedUsers)
}
