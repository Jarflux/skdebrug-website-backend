package be.skdebrug.website.service;

import be.skdebrug.website.core.Registration;
import be.skdebrug.website.core.Reservation;
import be.skdebrug.website.endpoint.VersioConnection;
import com.google.inject.Inject;

/**
 * Developer: Ben Oeyen
 * Date: 26/09/16
 */
public class EmailService {

    @Inject
    protected VersioConnection connection;

    public boolean send(Reservation reservation) {
        return connection.send(reservation);
    }

    public boolean send(Registration registration) {
        return connection.send(registration);
    }
}
