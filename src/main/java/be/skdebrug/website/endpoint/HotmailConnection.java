package be.skdebrug.website.endpoint;


//import sun.plugin2.message.transport.Transport;

import be.skdebrug.website.core.Reservation;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Developer: Ben Oeyen
 * Date: 26/09/16
 */
public class HotmailConnection {

    private static final String protocol = "smtp";
    private static final String mailhost = "smtp.live.com";
    private static final int port = 25;

    public boolean send(Reservation reservation) {
        Properties props = new Properties();

        String user = "skdebrug@hotmail.com";
        String password = "1257voetbal";

        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        try {
            session.setDebug(true);
            Transport transport = session.getTransport(protocol);
            transport.connect(mailhost, port, user, password);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("skdebrug@hotmail.com", "Sk De Brug"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("ben.oeyen@gmail.com", "Ben Oeyen"));
            msg.setSubject("Pasta hoofding");

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();

            String htmlBody = reservation.getBody();

            bodyPart.setContent(htmlBody, "text/html; charset=utf-8" );
            multipart.addBodyPart(bodyPart);
            msg.setContent(multipart);

//            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch ( MessagingException | UnsupportedEncodingException e ) {
            // ...
            return false;
        }

        return true;
    }
}


