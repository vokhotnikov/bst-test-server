package net.vokhot.bst.model

case class RescueContact(phone: String)

case class ServerInfo(title: String, rescueContact: RescueContact, tileUrlTemplate: String)

object Model {
  lazy val serverInfo = ServerInfo("Test BST Server", RescueContact("+79788118420"), "https://c.tile.openstreetmap.org/{z}/{x}/{y}.png")
}
