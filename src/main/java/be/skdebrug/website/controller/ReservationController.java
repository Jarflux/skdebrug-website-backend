package be.skdebrug.website.controller;

import be.skdebrug.website.core.Reservation;
import be.skdebrug.website.service.ReservationService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
    public Response send(Reservation reservation) {
        //LOG.debug("@POST /mail update player");
        List<String> errors = reservation.validate();
        if(errors.isEmpty()){
             if ( reservationService.send(reservation)){
                 return Response.status(Response.Status.OK).build();
             }else{
                 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
             }
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }

}
