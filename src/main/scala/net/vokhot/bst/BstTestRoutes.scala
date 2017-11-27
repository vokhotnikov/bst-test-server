package net.vokhot.bst

import akka.actor.ActorSystem
import akka.event.Logging
import akka.util.Timeout

import scala.concurrent.duration._
import akka.http.scaladsl.server.Directives._

import model._

trait BstTestRoutes extends JsonSupport {
  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[BstTestRoutes])

  implicit lazy val timeout = Timeout(5.seconds)

  lazy val bstTestRoutes =
    concat(
      path("") {
        get {
          complete("It's alive!")
        }
      },
      pathPrefix("api") {
        path("server-info") {
          get {
            complete(Model.serverInfo)
          }
        }

      }
    )
}
