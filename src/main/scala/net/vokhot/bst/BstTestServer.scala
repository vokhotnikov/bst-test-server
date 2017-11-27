package net.vokhot.bst

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn

object BstTestServer extends App with BstTestRoutes {
  override implicit def system: ActorSystem = ActorSystem("bstTestSystem")

  implicit val materializer = ActorMaterializer()

  implicit val executionContext = system.dispatcher

  lazy val routes = bstTestRoutes

  val serverBindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

  println("Server online at localhost:8080, press ANY key to stop...")

  StdIn.readLine()

  serverBindingFuture
    .flatMap(_.unbind)
    .onComplete { done =>
      done.failed.map(ex => log.error(ex, "Failed unbinding"))
      system.terminate()
    }
}
