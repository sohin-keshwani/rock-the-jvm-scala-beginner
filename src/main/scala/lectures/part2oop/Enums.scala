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


  enum ReactionEventType(reaction: String) {
    case FAVOURITE(var value: String, var t: String) extends ReactionEventType("favourite")
    case UNFAVOURITE(var value: String, var t: String) extends ReactionEventType("unfavourite")

    var variableOne: String = ""
    var variableTwo: String = ""

    def handleReaction() : Unit = {
      if (this == FAVOURITE) {
        variableOne = "1"
        variableTwo = "2"
      } else if (this == UNFAVOURITE) {
        variableOne = "3"
        variableTwo = "4"

      } else {
        throw new RuntimeException
      }
    }

  }

  object ReactionEventType {
    def getReactionFromType(reaction: String) : ReactionEventType = {
      reaction match  {
        case "favourite" => ReactionEventType.FAVOURITE("1", "2")
        case "unfavourite" => ReactionEventType.UNFAVOURITE("1", "2")
        case _ => throw new RuntimeException("Reaction type not supported")
      }
    }
  }

  val reactionType: ReactionEventType = ReactionEventType.getReactionFromType("favourite")


  trait ReactionEventTypeTrait {
    def performSomeActionBasedOnReaction: Unit
  }

  class FavouriteEventType extends ReactionEventTypeTrait {
    override def performSomeActionBasedOnReaction: Unit = {
      println("I am favourite")
    }
  }

  class UnFavouriteEventType extends ReactionEventTypeTrait {
    override def performSomeActionBasedOnReaction: Unit = {
      println("I am UnFavourite")
    }
  }

  object ReactionEventTypeFactoy {
    def apply(eventCode : Int) : ReactionEventTypeTrait = {
      eventCode match {
        case 6 => new FavouriteEventType
        case 7 => new UnFavouriteEventType
        case _ => throw new RuntimeException
      }
    }
  }

  ReactionEventTypeFactoy(6).performSomeActionBasedOnReaction
}
