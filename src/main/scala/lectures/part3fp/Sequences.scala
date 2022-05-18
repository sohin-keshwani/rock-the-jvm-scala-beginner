package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  // sequence
  val seq = Seq(1,2,3,4)
  println(seq)
  println(seq(3))

  val aRange: Seq[Int] = 0 to 10
  //println(0 to 10)
  //println(aRange)
  // (0 until 10).foreach(x => println("hello " + x))

  // list
  val aList = List(1,2,3)
  println(42::aList)
  println(42 +: aList :+ 89)

  val apples5 = List.fill(5)("apples")
  println(apples5)

  val maxCapacity = 1000000
  val maxRuns = 1000

  def getWriteTime(c: Seq[Int]) : Double = {
    val r = new Random

    val times = for {
      it <- 1 to maxRuns
    } yield {
      val startedAt = System.nanoTime()
      c.updated(r.nextInt(maxCapacity), r.nextInt())
      val endedAt = System.nanoTime()
      endedAt - startedAt
    }

    times.sum * 1.0 / maxRuns
  }

  val numberList = (0 to maxCapacity).toList
  val numberVector = (0 to maxCapacity).toVector

  println(getWriteTime(numberList))
  println(getWriteTime(numberVector))
}
