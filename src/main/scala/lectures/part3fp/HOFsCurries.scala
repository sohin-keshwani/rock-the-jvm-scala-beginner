package lectures.part3fp

object HOFsCurries extends App {
  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // e.x.
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) =
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n - 1, f(x))
  def nTimes(fn: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(fn, n - 1, fn(x))
  }

  val plusOne : Int => Int = _ + 1

  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(fn: Int => Int, n: Int) : (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(fn, n -1)(fn(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  val superAdd : Int => (Int => Int) = (x: Int) => (y: Int)  => x + y

  val add3 = superAdd(3)
  println(add3(4))


  def curryFormatter(c: String)(d: Double) : String = c.format(d)

  val standardFormatter: (Double => String) = curryFormatter("%4.2f")
  val preciseFormatter : (Double => String) = curryFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(preciseFormatter(Math.PI))

  def toCurry(f: (Int, Int) => Int) : (Int => Int => Int) = {
    x => y => f(x, y)
  }

  def fromCurry(f: (Int => Int => Int)) : (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }
}
