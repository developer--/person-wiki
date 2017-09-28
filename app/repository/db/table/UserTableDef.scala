package repository.db.table

import model.User
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.MySQLProfile.api._


class UserTableDef(tag: Tag) extends Table[User](tag, "user") {

  def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def mobile = column[Long]("mobile")
  def email = column[String]("email")

  override def * : ProvenShape[User] =
    (id, firstName, lastName, mobile, email) <>(User.tupled, User.unapply)
}