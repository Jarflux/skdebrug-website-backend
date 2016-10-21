package be.skdebrug.website.controller;

import be.skdebrug.website.core.Reservation;
import be.skdebrug.website.service.ReservationService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Developer: Ben Oeyen
 * Date: 21/10/16
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ReservationController {
    private final static Logger LOG = Logger.getLogger(ReservationController.class);

    @Inject
    protected ReservationService reservationService;

    @POST
    @Timed
    @Path("reservation")
    public boolean light(Reservation reservation) {
        //LOG.debug("@POST /mail update player");
        return reservationService.send(reservation);
    }

    @POST
    @Timed
    @Path("reservation/light")
    public boolean sendLight(Reservation reservation) {
        //LOG.debug("@POST /mail update player");
        return reservationService.sendLight(reservation);
    }

}
