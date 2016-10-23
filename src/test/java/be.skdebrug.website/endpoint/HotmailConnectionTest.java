package be.skdebrug.website.endpoint;

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
    public void testEmail(){
        HotmailConnection connection = new HotmailConnection();
        Reservation reservation = new Reservation();
        reservation.setLookbrood(4);
        reservation.setPasta(3);
        reservation.setVeggie(1);
        reservation.setChild(2);
        reservation.setDessert(6);
        reservation.setTime("18u - 19u");
        reservation.setRecipient("ben.oeyen@gmail.com");
        reservation.setName("Ben Oeyen");
        assertThat(connection.send(reservation)).isTrue();
    }

}
