package pingpongActor

import akka.actor._

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage


class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incrementAndPrint() {
    count += 1
    println("ping")
  }


  def receive: PartialFunction[Any, Unit] = {
    case StartMessage =>
      incrementAndPrint()
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint()
      if (count > 99) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }
  }
}

class Pong extends Actor {
  def receive: PartialFunction[Any, Unit] = {
    case PingMessage =>
      println("  pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
  }
}

object PingPongTest extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  // start them going
  ping ! StartMessage
}