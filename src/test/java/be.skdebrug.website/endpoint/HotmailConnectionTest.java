package be.skdebrug.website.endpoint;

import be.skdebrug.website.core.Registration;
import be.skdebrug.website.core.Reservation;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Developer: Ben Oeyen
 * Date: 22/10/2016
 */
public class HotmailConnectionTest {

    @Test @Ignore
    public void testPastaEmail(){
        HotmailConnection connection = new HotmailConnection();
        Reservation reservation = new Reservation();
        reservation.setLookbrood(4);
        reservation.setPasta(3);
        reservation.setVeggie(1);
        reservation.setChild(2);
        reservation.setDessert(6);
        reservation.setTime("18u - 19u");
        reservation.setRecipient("ben.oeyen@gmail.com");
        reservation.setName("LOL ACCEPTATIE TEST");
        assertThat(connection.send(reservation)).isTrue();
    }

    @Test @Ignore
    public void testQuizEmail(){
        HotmailConnection connection = new HotmailConnection();
        Registration registration = new Registration();
        registration.setRecipient("ben.oeyen@gmail.com");
        registration.setName("TEST MAIL");
        registration.setTeam("De Lustige Quizzers");
        assertThat(connection.send(registration)).isTrue();
    }

}
