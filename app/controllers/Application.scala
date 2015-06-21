package controllers

import javax.inject.Inject

import play.api.libs.mailer.MailerClient
import play.api.libs.ws.WSClient
import play.api.mvc.{Action, Controller}
import service.Mail

class Application @Inject() (mail: Mail, mailerClient: MailerClient) extends Controller {
  @Inject var ws: WSClient = null

  def index = Action {
    Ok(views.html.mailform())
  }

  def send = Action {
    Ok((mail.client == null) + " " + mailerClient + " " + (ws == null))
  }
}