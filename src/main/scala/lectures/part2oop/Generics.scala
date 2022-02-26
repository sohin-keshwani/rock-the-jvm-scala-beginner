package lectures.part2oop

object Generics extends App {
  class MyList[+A] {
    def add[B >: A](e: B) : MyList[B] = ???
  }

  // in the example of cats and dogs and animal
  // irrespective my list is of cats, i can add dogs due to COVARIANCE
  // but that will make my list as list of animals where B: Animal and A: concrete implementation i.e., Cat or Dog

  class MyMap[K, V] {  }

  object MyList {
    def empty[A] : MyList[A] = ???
  }

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

  val emptyListOfInts = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val cat: Animal = new Cat
  val catList: CovariantList[Animal] = new CovariantList[Cat]
  // catList.add(new Dog) ? this is valid because Dog is of the type animal, but we just wanted catList of the type animal

  //2. NO = INVARIANCE

  class InvariantList[A]
  // val inCatList: InvariantList[Animal] = new InvariantList[Cat] // in invariant generic type this becomes invalid as the type on both sides needs to match
  val inCatList: InvariantList[Animal] = new InvariantList[Animal] // although we want list of cats, but invariance forces us to use Animal

  //3. Hell, no! CONTRAVARIANCE!
  class Trainer[-A]
  val catTrainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: Animal)
  val cage = new Cage(new Cat)

  class Car
  //val cagedCard = new Cage(new Car) // compile error as Cage needs bounded class of the type Animal
}
