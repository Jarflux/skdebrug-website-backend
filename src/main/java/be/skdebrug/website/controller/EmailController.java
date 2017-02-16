package be.skdebrug.website.controller;

import be.skdebrug.website.core.Registration;
import be.skdebrug.website.core.Reservation;
import be.skdebrug.website.service.EmailService;
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
public class EmailController {
    private final static Logger LOG = Logger.getLogger(EmailController.class);

    @Inject
    protected EmailService emailService;

    @POST
    @Timed
    @Path("reservation")
    public Response send(Reservation reservation) {
        List<String> errors = reservation.validate();
        if(errors.isEmpty()){
             if ( emailService.send(reservation)){
                 return Response.status(Response.Status.OK).build();
             }else{
                 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
             }
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }

    @POST
    @Timed
    @Path("registration")
    public Response send(Registration registration) {
        List<String> errors = registration.validate();
        if(errors.isEmpty()){
            if ( emailService.send(registration)){
                return Response.status(Response.Status.OK).build();
            }else{
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }

}
