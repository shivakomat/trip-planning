package controllers

import javax.inject._
import play.api.mvc._
import javax.inject.Inject
import play.api.libs.json.JsValue

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
    Ok(views.html.index("Your new application is ready."))
  }

  def profile = Action {
    Ok(views.html.profile("Your new application is ready."))
  }

  def myBucketItems = Action {
    Ok(views.html.myBucketItems("Your new application is ready."))
  }

  def createBucketItem = Action {
    Ok(views.html.createNewBucketItem("Your new application is ready."))
  }

  def createTrip = Action {
    Ok(views.html.createNewTrip(1))
  }

  def travellerProfilePage = Action {
    Ok(views.html.travellerProfile("Your new application is ready."))
  }

}
