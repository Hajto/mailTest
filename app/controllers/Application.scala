package controllers

import javax.inject.Inject

import play.api.libs.mailer.MailerClient
import play.api.libs.ws.WSClient
import play.api.mvc.{Action, Controller}
import service.Mail

class Application extends Controller {
  @Inject var ws: WSClient = null
  var test = new Mail

  def index = Action {
    Ok(views.html.mailform())
  }

  def send = Action {
    Ok((test.mailer == null) + " " + (ws == null))
  }
}