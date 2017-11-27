package net.vokhot.bst

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

import net.vokhot.bst.model._

trait JsonSupport extends SprayJsonSupport {
  import DefaultJsonProtocol._

  implicit val rescueContactJsonFormat = jsonFormat1(RescueContact)
  implicit val serverInfoJsonFormat = jsonFormat3(ServerInfo)

}
