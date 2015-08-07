package be.skdebrug.website.controller;

import be.skdebrug.website.core.League;
import be.skdebrug.website.service.LeagueService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
@Path("/league")
@Produces(MediaType.APPLICATION_JSON)
public class LeagueController {

    private final static Logger LOG = Logger.getLogger(LeagueController.class);

    @Inject
    protected LeagueService leagueService;

    @GET
    @Timed
    public League get() {
        LOG.debug("@GET /league/ get current league");
        return leagueService.getCurrent();
    }
}
