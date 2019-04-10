package akkahttp

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{get, path, _}
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Flow

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object Server extends App {
  Flow

  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  def route: Route = path("hello") {
    get {
      complete("Hello, World!")
    }
  }

  val bindingFuture =  Http().bindAndHandle(route, host, port)
  bindingFuture.onComplete {
    case Success(serverBinding) => println("Listening to " + serverBinding.localAddress)
    case Failure(error) => println("Error" + error)
  }

  // test : http://localhost:9000/hello

}
