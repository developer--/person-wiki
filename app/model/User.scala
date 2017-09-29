package model

import play.api.Play
import play.api.data.Form
import play.api.data.Forms._
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import repository.db.table.UserTableDef
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction

/**
  * Created by dev-00 on 9/28/17.
  */
case class User(id: Option[Long], firstName: String, lastName: String, mobile: Long, email: String )

case class UserFormData(firstName: String, email: String, password: String)

object UserForm {

  val form = Form(
    mapping(
      "firstName" -> nonEmptyText,
      "email" -> email,
      "password" -> nonEmptyText
    )(UserFormData.apply)(UserFormData.unapply)
  )
}

object Users {
  var users: TableQuery[UserTableDef] = TableQuery[UserTableDef]
  val dbConfig: DatabaseConfig[JdbcProfile] = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def add(user: User) : Future[String] = {
    dbConfig.db.run(users += user).map(res => "User successfully added " + res).recover{
      case ex: Exception => ex.getCause.getMessage
    }
  }

  def delete(id: Long): Future[Int] = {
    dbConfig.db.run(users.filter(_.id === id).delete)
  }

  def get(id: Long): Future[Option[User]] = {
    dbConfig.db.run(users.filter(_.id === id).result.headOption)
  }

  def userList: Future[Seq[User]] = {
    dbConfig.db.run(users.result)
  }

  def init() = {
    dbConfig.db.run(DBIOAction.seq(users.schema.create))
  }
}

