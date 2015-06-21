package service

import java.io.File
import javax.inject.Inject
import com.google.inject.Singleton
import org.apache.commons.mail.EmailAttachment
import play.api.libs.mailer.{AttachmentData, AttachmentFile, Email, MailerClient}

@Singleton
class Mail {
  @Inject var mailer: MailerClient = null

  def send(to: String, from: String)(mailer: MailerClient) = {
    val email = Email(
      "Simple email",
      "Mister FROM <from@email.com>",
      Seq("Miss TO <to@email.com>"),
      // adds attachment
      attachments = Seq(
        AttachmentFile("attachment.pdf", new File("/some/path/attachment.pdf")),
        // adds inline attachment from byte array
        AttachmentData("data.txt", "data".getBytes, "text/plain", Some("Simple data"), Some(EmailAttachment.INLINE))
      ),
      // sends text, HTML or both...
      bodyText = Some("A text message"),
      bodyHtml = Some("<html><body><p>An <b>html</b> message</p></body></html>")
    )
    mailer.send(email)

  }
}
