package be.skdebrug.website.controller;

import be.skdebrug.website.core.Player;
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
    @Path("/player")
    @Produces(MediaType.APPLICATION_JSON)
    public class PlayerController {
        private final static Logger LOG = Logger.getLogger(PlayerController.class);

        @Inject
        protected PlayerService playerService;

        @GET
        @Timed
        @Path("/{playerId}")
        public Player get(@PathParam("playerId") int playerId) {
            LOG.debug("@GET /player/" + playerId + " get player with id " + playerId);
            return playerService.get(playerId);
        }

        @GET
        @Timed
        public List<Player> getAll() {
            LOG.debug("@GET /player get all players");
            return playerService.getAll();
        }

        @PUT
        @Timed
        public void update(Player player) {
            LOG.debug("@PUT /player create player");
            playerService.create(player);
        }

        @POST
        @Timed
        public void create(Player player) {
            LOG.debug("@POST /player update player");
            playerService.create(player);
        }

        @DELETE
        @Timed
        @Path("/{playerId}")
        public void delete(@PathParam("playerId") int playerId) {
            LOG.debug("@DELETE /player/" + playerId + " get player with id " + playerId);
            playerService.delete(playerId);
        }

        @DELETE
        @Timed
        public void deleteAll() {
            LOG.debug("@DELETE /player/ delete all player");
            playerService.deleteAll();
        }

    }
