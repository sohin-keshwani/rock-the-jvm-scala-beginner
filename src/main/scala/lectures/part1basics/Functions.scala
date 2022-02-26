package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b
  println(aFunction("asshole number", 1))

  def aParanthesislessFunction: Int = 42

  println(aParanthesislessFunction)

  def aRepeatedFunction(aString: String, n : Int) : String = {
    if (n == 1) aString
    else aString + "\n" + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("a repeated asshole", 3))

  //RECURSIONS OVER LOOPS FOR FUNCTIONAL LANGUAGES

  def factorial(n : Int) : Int = {
    if ( n <= 0) 1
    else n * factorial(n -1)
  }

  println(factorial(5))

  def fibonacci(n: Int) : Int = {
    if (n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n -2)
  }

  println(fibonacci(8))

  def isPrimeNumber(n : Int) : Boolean = {
    def isPrimeUntil(t : Int) : Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n  / 2)
  }

  println(isPrimeNumber(11))
  println(isPrimeNumber(9))
}
