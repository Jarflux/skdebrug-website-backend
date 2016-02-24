package be.skdebrug.website.controller;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.service.GameService;
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
@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
public class GameController {

    private final static Logger LOG = Logger.getLogger(GameController.class);

    @Inject
    protected GameService gameService;

    @GET
    @Timed
    @Path("/{gameId}")
    public Game get(@PathParam("gameId") int gameId) {
        LOG.debug("@GET /game/" + gameId + " get game with id " + gameId);
        return gameService.get(gameId);
    }

    @GET
    @Timed
    public List<Game> getAll() {
        LOG.debug("@GET /game get all games");
        return gameService.getAll();
    }

    @GET
    @Timed
    @Path("/next/{amount}/team/{teamid}")
    public List<Game> getNext(@PathParam("amount") int amount, @PathParam("teamid") int teamid) {
        LOG.debug("@GET /game/next/" + amount + "/team/" + teamid + " get next " + amount + " games for team " + teamid);
        return gameService.getNextCertainAmountOfGames(amount, teamid);
    }

    @GET
    @Timed
    @Path("/prev/{amount}/team/{teamid}")
    public List<Game> getPrev(@PathParam("amount") int amount, @PathParam("teamid") int teamid) {
        LOG.debug("@GET /game/prev/"  + amount + "/team/" + teamid + " get prev " + amount + " games for team " + teamid);
        return gameService.getPreviousCertainAmountOfGames(amount, teamid);
    }

    @PUT
    @Timed
    public void update(Game game) {
        LOG.debug("@PUT /game/" + game.getId() + " update game");
        gameService.update(game);
    }

    @POST
    @Timed
    public void create(Game game) {
        LOG.debug("@POST /game create game");
        gameService.create(game);
    }

    @DELETE
    @Timed
    @Path("/{gameId}")
    public void delete(@PathParam("gameId") int gameId) {
        LOG.debug("@DELETE /game/" + gameId + " delete game with id " + gameId);
        gameService.delete(gameId);
    }

    @DELETE
    @Timed
    public void deleteAll() {
        LOG.debug("@DELETE /game/ delete all games");
        gameService.deleteAll();
    }

}