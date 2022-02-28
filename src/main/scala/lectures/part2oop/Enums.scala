package lectures.part2oop

object Enums extends App {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE
  }

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) //100
    case WRITE extends PermissionsWithBits(2) //010
    case EXECUTE extends PermissionsWithBits(1) //001
    case NONE extends PermissionsWithBits(0) //000
  }

  // can be used to generate factories. 
  object PermissionsWithBits {
    def fromBits(bits: Int) : PermissionsWithBits = PermissionsWithBits.NONE
  }

  println(PermissionsWithBits.values)
  println(Permissions.valueOf("READ"))


}
