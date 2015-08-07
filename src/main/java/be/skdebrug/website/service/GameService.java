package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.News;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.NewsRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Inject;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class GameService {

    @Inject
    protected GameRepository gameRepository;

    @Inject
    protected TeamRepository teamRepository;

    public boolean create(final Game game) {
        return gameRepository.create(game);
    }

    public Game get(final int gameId) {
        return addTeamInformation(gameRepository.get(gameId));
    }

    public List<Game> getAll() {
        return addTeamInformation(gameRepository.getAll());
    }

    public boolean update(final Game game) {
        return gameRepository.update(game);
    }

    public boolean delete(final int gameId) {
        return gameRepository.delete(gameId);
    }

    public boolean deleteAll() {
        return gameRepository.deleteAll();
    }

    //TODO Test Method
    public List<Game> getAllLeagueBetweenDates(DateTime start, DateTime end) {
        List<Game> allGames = getAll();
        Iterator<Game> gameIterator = allGames.iterator();
        while(gameIterator.hasNext()){
            Game game = gameIterator.next();
            if (!game.getDateStart().isAfter(start)
                    || !game.getDateStart().isBefore(end)) {
                        gameIterator.remove();
            }
        }
        return addTeamInformation(allGames);
    }

    private Game addTeamInformation(Game game){
        game.setHomeTeam(teamRepository.get(game.getHomeTeam().getId()));
        game.setAwayTeam(teamRepository.get(game.getAwayTeam().getId()));
        return game;
    }

    private List<Game> addTeamInformation(List<Game> games){
        for(Game game: games){
            addTeamInformation(game);
        }
        return games;
    }

}
