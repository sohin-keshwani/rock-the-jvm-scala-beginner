package lectures.part3fp

object WhatsAFunction extends App {
  val doubler = new MyFunction[Int, Int] {
    override def apply(e: Int): Int = e * e
  }

  println(doubler(2))

  val stringToInt = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToInt("3") + 4)

  val addToNumbers: ((Int, Int) => Int)  = new Function2[Int, Int, Int] {
    override def apply(e1: Int, e2: Int): Int = e1 + e2
  }

  println(addToNumbers(stringToInt("3"), 4))

  val specialFunction: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  println(specialFunction(4)(4)) // curried function
}

trait MyFunction[A, B] {
  def apply(e: A) : B
}
