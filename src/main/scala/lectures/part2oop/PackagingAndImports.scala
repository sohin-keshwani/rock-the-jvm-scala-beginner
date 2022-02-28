package lectures.part2oop

import java.util.Date
import java.sql.{Date => SqlDate}
object PackagingAndImports extends App {
  // package object should rarely be used
  //sayHello

  // when we have ambigious class names in import, either we use fully qualified names when using those classes (like we did in java)
  // or we alias the import using {ClashedName => SomeAlias}
  val d = new Date()
  val sd = new SqlDate(2022,05,04)
}
