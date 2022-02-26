package lectures.part1basics

import scala.annotation.tailrec

// PRACTICE TAIL REC

object Recursion extends App {
  def factorial(n: Int) : Int = {
    if (n <= 1) 1
    else {
      println(s"Computing factorial for $n we need " + (n-1))
      val result = n * factorial(n -1)
      println(s"Computed factorial for $n")
      result
    }
  }

  //println(factorial(10))

  @tailrec
  def aTailRecurssiveFunction(n : Int, accumulator: BigInt) : BigInt = {
    if (n <= 1) accumulator
    else {
      aTailRecurssiveFunction(n - 1, n * accumulator)
    }
  }

  //println(aTailRecurssiveFunction(300, 1))

  def fibonacci(n : Int) : Int = {

    def fibTailRec(i: Int, last: Int, nextToLast: Int) : Int = {
      if (i >= n) last
      else fibTailRec(i + 1, last + nextToLast, last)
    }

    // 2, 1, 1
    // 3, 2, 1
    // 4, 3, 2
    // 5, 5, 3
    // 6, 8, 5
    // 7, 13, 8
    // 8, 21, 13

    if (n <= 2) 1
    else fibTailRec(2, 1, 1)
  }



  println(fibonacci(8))
  //println(factorial(5000))
}
