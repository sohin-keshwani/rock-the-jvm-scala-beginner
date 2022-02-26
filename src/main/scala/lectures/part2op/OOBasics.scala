package lectures.part2op

object OOBasics extends App {
  //val person = new Person("David", 12)
  //println(person)

  //val writer = new Writer("shohin", "keshwani", 1984)
  //println(writer.fullname())

  val counter = new Counter
  counter.inc.print()

  val nextCounter = counter.inc

  nextCounter.inc.dec.print()

}

class Person(name: String, age: Int)

class Writer(firstname: String, lastname: String, val year: Int) {
  def fullname() : String = s"$firstname $lastname"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge() : Int = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear:Int) : Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {

  def inc : Counter = {
    println("incrementing")
    new Counter(count + 1)
  }
  def dec : Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n + 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def print() = println(count)

}