package lectures.part3fp

object TuplesAndMaps extends App {
  val aTuple = Tuple2(2, "hello scala");
  println(aTuple)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

  val aMap : Map[String, Int] = Map()
  val phonebook = Map(("Shohin",123), "Faj" -> 786).withDefaultValue(-1)

  println(phonebook)
  println(phonebook.contains("Faj"))
  println(phonebook("fai")) // due to defaultvalue

  println(phonebook.map(pair => pair._1.toLowerCase))
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  println(phonebook.view.filterKeys(x => x.toLowerCase.startsWith("f")).toMap)
  val phonebookDouble: Map[String, Double] = phonebook.view.mapValues(n => (n /10).toDouble ).toMap
  println(phonebookDouble)

  println(phonebook.toList)
  println(List(("shohin", 123)).toMap)

  val names = List("fai", "iffi", "mosh", "shohin", "sufii")

  println(names.groupBy(name => name.charAt(0)))

}
