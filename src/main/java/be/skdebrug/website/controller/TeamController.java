package be.skdebrug.website.controller;

import be.skdebrug.website.core.Team;
import be.skdebrug.website.service.TeamService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamController {

    private final static Logger LOG = Logger.getLogger(TeamController.class);

    @Inject
    private TeamService teamService;

    @GET
    @Timed
    @Path("/{teamId}")
    public Team get(@PathParam("teamId") int teamId) {
        LOG.debug("@GET /news/" + teamId + " get news with id " + teamId);
        return teamService.get(teamId);
    }

    @GET
    @Timed
    public List<Team> getAll() {
        LOG.debug("@GET /team get all teams");
        return teamService.getAll();
    }

    @PUT
    @Timed
    public void update(Team team) {
        LOG.debug("@PUT /team create team");
        teamService.create(team);
    }

    @POST
    @Timed
    public void create(Team team) {
        LOG.debug("@POST /team update team");
        teamService.create(team);
    }

    @DELETE
    @Timed
    @Path("/{teamId}")
    public void delete(@PathParam("teamId") int teamId) {
        LOG.debug("@DELETE /team/" + teamId + " get team with id " + teamId);
        teamService.delete(teamId);
    }

    @DELETE
    @Timed
    public void deleteAll() {
        LOG.debug("@DELETE /team/ delete all teams");
        teamService.deleteAll();
    }
}
