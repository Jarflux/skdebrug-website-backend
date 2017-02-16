package be.skdebrug.website.endpoint;

import be.skdebrug.website.core.Registration;
import be.skdebrug.website.core.Reservation;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;

/**
 * Developer: Ben Oeyen
 * Date: 26/09/16
 */
public class HotmailConnection {

    private final static Logger LOG = Logger.getLogger(HotmailConnection.class);

    private static final String PROTOCOL = "smtp";
    private static final String MAILHOST = "smtp.live.com";
    private static final String PASTA_DOOR = StringUtils.reverse("eb.liamtoh@gurbed.atsap");
    private static final String QUIZ_DOOR = StringUtils.reverse("moc.liamtoh@gurbed.ziuq");
    private static final String PASTA_KEY = StringUtils.reverse("neoipmakgurbed#");
    private static final String QUIZ_KEY = StringUtils.reverse("neoipmakgurbed#");
    private static final int PORT = 587;

    public boolean send(Reservation reservation) {
        Properties props = new Properties();

        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        try {
            session.setDebug(true);
            Transport transport = session.getTransport(PROTOCOL);
            transport.connect(MAILHOST, PORT, PASTA_DOOR, PASTA_KEY);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(PASTA_DOOR, "Pasta Sk De Brug"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(reservation.getRecipient(), reservation.getName()));
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(PASTA_DOOR, "Pasta SK De Brug"));
            msg.setSubject("Pasta Catenaccio reservatie op naam van " + reservation.getName());

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();

            bodyPart.setContent(reservation.getBody(), "text/html; charset=utf-8" );
            multipart.addBodyPart(bodyPart);
            msg.setContent(multipart);

            transport.sendMessage(msg, msg.getAllRecipients());
        } catch ( MessagingException | UnsupportedEncodingException e ) {
            LOG.error(ExceptionUtils.getStackTrace(e));
            return false;
        }

        return true;
    }

    public boolean send(Registration registration) {
        Properties props = new Properties();

        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        try {
            session.setDebug(true);
            Transport transport = session.getTransport(PROTOCOL);
            transport.connect(MAILHOST, PORT, QUIZ_DOOR, QUIZ_KEY);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(QUIZ_DOOR, "Quiz Sk De Brug"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(registration.getRecipient(), registration.getName()));
            msg.addRecipient(Message.RecipientType.CC, new InternetAddress(QUIZ_DOOR, "Quiz SK De Brug"));
            msg.setSubject("Quiz inschrijving " + registration.getTeam());

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();

            bodyPart.setContent(registration.getBody(), "text/html; charset=utf-8" );
            multipart.addBodyPart(bodyPart);
            msg.setContent(multipart);

            transport.sendMessage(msg, msg.getAllRecipients());
        } catch ( MessagingException | UnsupportedEncodingException e ) {
            LOG.error(ExceptionUtils.getStackTrace(e));
            return false;
        }

        return true;
    }


}


