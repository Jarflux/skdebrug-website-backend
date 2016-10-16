package be.skdebrug.website.endpoint;


//import sun.plugin2.message.transport.Transport;

import java.security.Security;
import java.util.Properties;

/**
 * Developer: Ben Oeyen
 * Date: 26/09/16
 */
public class HotmailConnection {

    private String mailhost = "smtp.live.com";

    public void hotmailSenderActivity(String user, String password) {
//        Properties props = new Properties();
//        Session session = Session.getDefaultInstance(props, null);
//
//        try {
//            Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
//            msg.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress("user@example.com", "Mr. User"));
//            msg.setSubject("Your Example.com account has been activated");
//            Transport.send(msg);
//        } catch (AddressException e) {
//            // ...
//        } catch (MessagingException e) {
//            // ...
//        } catch (UnsupportedEncodingException e) {
//            // ...
//        }
    }
}


