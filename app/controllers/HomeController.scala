package controllers

import java.util.Calendar
import javax.inject._

import model.User
import play.api.mvc._
import services.UserService

import scala.util.{Failure, Success}
import scala.concurrent._
import ExecutionContext.Implicits.global
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    UserService.init()
    val u1 = User(null, "vaxo", "gasit", 593646, "jkh")
//    val users = UserService.addUser(User(null,"Kotlin","mgebrishvili",591123456,"jemo@gmail.com")).value
    val usrs = Seq[User](u1,u1,u1,u1,u1,u1,u1,u1,u1,u1)
    UserService.listUsers.map(it => it) onComplete {
      case Success(result) => Ok(views.html.index.render(result,""))
      case Failure(t) =>
    }
    Ok(views.html.index.render(usrs,""))
  }

  def about = Action {
     Ok(views.html.about.render(Calendar.getInstance().get(Calendar.YEAR)))
  }
}
