package be.skdebrug.website.endpoint;

import be.skdebrug.website.core.Reservation;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Developer: Ben Oeyen
 * Date: 26/09/16
 */
public class HotmailConnection {

    private final static Logger LOG = Logger.getLogger(HotmailConnection.class);

    private static final String PROTOCOL = "smtp";
    private static final String MAILHOST = "smtp.live.com";
    private static final String USER = "skdebrug@hotmail.com";
    private static final String PASSWORD = "1257voetbal";
    private static final int PORT = 587;

    public boolean send(Reservation reservation) {
        Properties props = new Properties();

        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        try {
            session.setDebug(true);
            Transport transport = session.getTransport(PROTOCOL);
            transport.connect(MAILHOST, PORT, USER, PASSWORD);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("skdebrug@hotmail.com", "Sk De Brug"));
            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress("skdebrug@hotmail.com", "SK De Brug"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(reservation.getRecipient(), reservation.getName()));
            msg.setSubject("Pasta Catenaccio reservatie op naam van " + reservation.getName());

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();

            bodyPart.setContent(reservation.getBody(), "text/html; charset=utf-8" );
            multipart.addBodyPart(bodyPart);
            msg.setContent(multipart);

            transport.sendMessage(msg, msg.getAllRecipients());
        } catch ( MessagingException | UnsupportedEncodingException e ) {
            // ...
            return false;
        }

        return true;
    }
}


