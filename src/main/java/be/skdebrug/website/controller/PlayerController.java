package be.skdebrug.website.controller;

import be.skdebrug.website.core.Player;
import be.skdebrug.website.core.PlayerType;
import be.skdebrug.website.service.PlayerService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 07/08/15
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerController {
    private final static Logger LOG = Logger.getLogger(PlayerController.class);

    @Inject
    protected PlayerService playerService;

    @GET
    @Timed
    @Path("player/{playerId}")
    public Player get(@PathParam("playerId") int playerId) {
        LOG.debug("@GET /player/" + playerId + " get player with id " + playerId);
        return playerService.get(playerId);
    }

    @GET
    @Timed
    @Path("player")
    public List<Player> getAll() {
        LOG.debug("@GET /player get all players");
        return playerService.getAll();
    }

    @GET
    @Timed
    @Path("player/type")
    public PlayerType[] getAllTypes() {
        LOG.debug("@GET /player/type get all playertypes");
        return PlayerType.values();
    }

    @PUT
    @Timed
    @Path("private/player")
    public void update(Player player) {
        LOG.debug("@PUT /player create player");
        playerService.update(player);
    }

    @POST
    @Timed
    @Path("private/player")
    public void create(Player player) {
        LOG.debug("@POST /player update player");
        playerService.create(player);
    }

    @DELETE
    @Timed
    @Path("private/player/{playerId}")
    public void delete(@PathParam("playerId") int playerId) {
        LOG.debug("@DELETE /player/" + playerId + " get player with id " + playerId);
        playerService.delete(playerId);
    }

    @DELETE
    @Timed
    @Path("private/player")
    public void deleteAll() {
        LOG.debug("@DELETE /player/ delete all player");
        playerService.deleteAll();
    }

}
