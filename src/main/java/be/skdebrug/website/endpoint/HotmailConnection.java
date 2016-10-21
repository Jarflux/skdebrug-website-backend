package be.skdebrug.website.endpoint;

import be.skdebrug.website.core.Reservation;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;

/**
 * Developer: Ben Oeyen
 * Date: 26/09/16
 */
public class HotmailConnection {

    private final static Logger LOG = Logger.getLogger(HotmailConnection.class);

    private static final String protocol = "smtp";
    private static final String mailhost = "smtp.live.com";
    private static final int port = 25;

    public boolean send(Reservation reservation) {
        Properties props = new Properties();

        String user = "skdebrug@hotmail.com";
        String password = "1257voetbal";

        long millies = System.currentTimeMillis();
        String htmlBody = reservation.getBody();
        LOG.debug("Body build took (" + (System.currentTimeMillis() - millies) + "ms)");

        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        try {
            session.setDebug(true);
            Transport transport = session.getTransport(protocol);
            transport.connect(mailhost, port, user, password);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("skdebrug@hotmail.com", "Sk De Brug"));
            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress("skdebrug@hotmail.com", "SK De Brug"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(reservation.getRecipient(), reservation.getName()));
            msg.setSubject("Pasta Catenaccio reservatie op naam van " + reservation.getName());

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();

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


    public boolean sendLightWeight(Reservation reservation) {
        Properties props = new Properties();

        String user = "skdebrug@hotmail.com";
        String password = "1257voetbal";

        long millies = System.currentTimeMillis();
        String htmlBody = reservation.getBodyLightWeight();
        LOG.debug("Body build took (" + (System.currentTimeMillis() - millies) + "ms)");

        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(props);

        try {
            session.setDebug(true);
            Transport transport = session.getTransport(protocol);
            transport.connect(mailhost, port, user, password);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("skdebrug@hotmail.com", "Sk De Brug"));
            msg.addRecipient(Message.RecipientType.BCC, new InternetAddress("skdebrug@hotmail.com", "SK De Brug"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(reservation.getRecipient(), reservation.getName()));
            msg.setSubject("Pasta Catenaccio reservatie op naam van " + reservation.getName());

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();

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


