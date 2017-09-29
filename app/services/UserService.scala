package services

import model.{User, Users}

import scala.concurrent.Future

/**
  * Created by dev-00 on 9/28/17.
  */
object UserService {

  def addUser(user: User): Future[String] = {
    Users.add(user)
  }

  def deleteUser(id: Long): Future[Int] = {
    Users.delete(id)
  }

  def getUser(id: Long): Future[Option[User]] = {
    Users.get(id)
  }

  def init(): Unit ={
    Users.init()
  }

  def listUsers: Future[Seq[User]] = Users.userList
}
