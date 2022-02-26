package lectures.part1basics

object CBNvsCBV  extends App {
  def calledByValue(x: Long) : Unit = {
    println(x)
    println(x)
  }

  def calledByName(x: => Long) : Unit = {
    println(x)
    println(x)
  }

  // sends the evaluated value of the expression, and hence everytime the x is called in calledByValue it is exact same evaluated value
  calledByValue(System.nanoTime())

  // sends the expression as argument not the evaluated value. so everytime x in used in calledByName,
  // the expression  is evaluated giving rise to new value
  // very useful in lazy initialization. example below
  calledByName(System.nanoTime())

  def inifinite() : Int = 1 + inifinite()
  def printFirst(x: Int, y: => Int) = println(x)



  // if we call the above function printFirst with infinite as first parameter, we will have a stackoverflow
  // because the first param in printFirst is callByValue, i.e., it will evaluate the expression which will go into
  // infinite loop and the program will crash
  // e.g. printFirst(infinite(), 34)

  // but if we swap the parameters
  // e.g. printFirst(34, infinite()) this will not crash, because infinite is never called in printFirst and hence never evaluated


  def printAgain(x: Int, y: => Int) = println(y)
  printAgain(inifinite(), 34)

  // to emphasize on this, lets take another example
  // we create a function printAgain which takes infinite() as first argument which is called by value and
  // 34 as second argument, which is call by name
  // in the body we are printing 34 which is call by name and infinite() is never called, but since the argument is passed as callByValue
  // it gets evaluated even before the body of the function is executed which causes the infinite loop to crash the system
}
