package lectures.part3fp

object AnonymousFunctions extends App {
  val doubler = new Function[Int, Int] {
    override def apply(e: Int): Int = e * 2
  }

  println(doubler(3))

  // more scalac way of writing ^^^ function is - LAMBDA (anonymous functions)
  val doublerA = (e: Int) => e * 2
  println(doublerA(2))

  val adder = (a: Int, b: Int) => a + b
  println(adder(6, 19))

  val justDoSomething = () => s"I have no parameters"
  println(justDoSomething()) //lambdas always have to be called with parenthesis
  val niceIncrementer: Int => Int = _ + 1
  val niceAddress: (Int, Int) => Int = _ + _ // use underscores very carefully as type representations can be lost and compiler will no know how to deal wth them

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(4)(4))

}
