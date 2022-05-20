package lectures.part3fp

import scala.util.Random

object Optional extends App {
  def unsafeMethod : String = null
  val result = Option(unsafeMethod)

  def safeBackupMethod : String = "some"

  println(Option(unsafeMethod).orElse(Option(safeBackupMethod)))

  def betterUnsafeMethod : Option[String] = None
  def betterBackupMethod : Option[String] = Some("some better method")

  println(betterUnsafeMethod orElse betterBackupMethod)

  val config : Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "8080"
  )

  class Connection {
    def connect : String = "connected"
  }

  object Connection {

    val r = new Random(System.nanoTime())

    def apply (host: String, port : String) : Option[Connection] = {
      if (r.nextBoolean()) Some(new Connection)
      else None
    }
  }

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap( p => Connection(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)
}
