package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // higher order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = false
  def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

/*trait MyPredicate[-T] {
  def test(ele: T) : Boolean
}

trait MyTransformer[-A, B] {
  def transform(ele: A) : B
}*/

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = new Cons(n, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else "" + h + " " + t.printElements
  }

  /*
  [1, 2, 3].filter(n % 2 == 0)
    = [2, 3].filter(n % 2 == 0)
    = new Cons(2, [2, 3].filter(n % 2 == 0))
    = new Cons(2, Empty)
  */
  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
  /*
  [1, 2, 3].map( n * n )
    = new Cons(1, [2, 3].map( n * n ))
    = new Cons(2, new Cons(4, [3].map( n * n )))
    = new Cons(2, new Cons(4, new Cons(9, Empty.map( n * n ))))
    = new Cons(2, new Cons(4, new Cons(9, Empty)))
  */
  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  /*
  [1, 2] ++ [3, 4, 5]
  = new Cons(1, [2] ++ [3,4,5])
  = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
  */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
  /*
  [1,2].flatMap(n = [n + 1])
  = [1,2] ++ [2].flatMap(n = [n + 1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n = [n + 1])
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
  */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
      transformer(h) ++ t.flatMap(transformer)
    }
}

object ListTest extends App {
  //val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  //println(list.tail.head)
  //println(list.add(4).head)
  //println(list.add(4).toString)
  val listOfInts = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfAnotherInts = new Cons(4, new Cons(5, Empty))
  val listOfStrings = new Cons("Shoni", new Cons("Loves", new Cons("Fiju", Empty)))

  println(listOfInts.toString)
  println(listOfStrings.toString)

  println(listOfInts.map((e) => e * e))

  println(listOfStrings.map((e: String) => {
    e + " " + e
  }).toString)

  println(listOfStrings.filter((e: String) => {
    e.equalsIgnoreCase("shoni") || e.equalsIgnoreCase("fiju")
  }).toString)

  println((listOfInts ++ listOfAnotherInts).filter((e) => e % 2 ==0))
  println((listOfInts ++ listOfAnotherInts).filter(_ % 2 ==0)) // we can shorthand this input with _

  println((listOfInts ++ listOfAnotherInts).toString)

  /*println((listOfInts++ listOfAnotherInts).flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(ele: Int): MyList[Int] = new Cons(ele, new Cons(ele + 1, Empty))
  }).toString)*/


  // cannot shorthand ele below with _ as everytime i will add underscore compiler will assume it is new input type
  // so effectively it will expect flatMap to accept three parameters instead of one which is used to carry it forward
  println((listOfInts++ listOfAnotherInts).flatMap((ele: Int) => {
    new Cons(ele, new Cons(ele + 1, Empty))
  }).toString)

}