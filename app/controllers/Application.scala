package controllers

import play.api.mvc.{Action, Controller}
import service.Mail

class Application extends Controller {

  def index = Action {
    println("Started processing")
    Ok(views.html.mailform())
  }

  def send = Action {
    //Mail.send("hajtosek@","")
    Ok((Mail.mailer == null).toString)
  }
}