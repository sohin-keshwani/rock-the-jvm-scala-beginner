package lectures.part2oop

object Exceptions extends App {
  def getInt(withExceptions: Boolean) : Int = {
    if (withExceptions) {
      throw new RuntimeException("some runtime exception")
    } else 42
  }

  try {
    getInt(true)
  } catch {
    case e : RuntimeException => println("caugth a runtime exception " + e.getMessage)
    case _ => println("something stupid like i love u")
  } finally {
    println("I will execute no matter whats")
  }

  //OOM
  //val array = Array.ofDim[Int](Int.MaxValue)

  //StackOverflow
  def infinite : Int = 1 + infinite
  //println(infinite)

  class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculationException(e: String) extends Exception(e)

  object PocketCalculator {
    def add(x: Int, y: Int) : Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) : Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) : Int = {
      val result = x * y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) : Int = {
      if (y == 0) throw new MathCalculationException("Division by zero")
      x / y
    }
  }


  println(PocketCalculator.divide(2, 0))
}
