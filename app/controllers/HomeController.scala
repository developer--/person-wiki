package controllers

import java.util.Calendar
import javax.inject._

import model.User
import play.api.mvc._
import services.UserService
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    val users = UserService.addUser(User(0,"jemo","mgebrishvili",591123456,"jemo@gmail.com")).value
    Ok(views.html.index.render(users.toString))
  }

  def about = Action {
     Ok(views.html.about.render(Calendar.getInstance().get(Calendar.YEAR)))
  }
}
