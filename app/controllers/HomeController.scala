package controllers

import java.util.Calendar
import javax.inject._

import model.{User, UserForm}
import play.api.mvc._
import services.UserService

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    UserService.init()
//    val users = UserService.addUser(User(null,"Kotlin","mgebrishvili",591123456,"jemo@gmail.com")).value
    Ok(views.html.index.render(UserForm.form))
  }

  def about = Action {
     Ok(views.html.about.render(Calendar.getInstance().get(Calendar.YEAR)))
  }
}
