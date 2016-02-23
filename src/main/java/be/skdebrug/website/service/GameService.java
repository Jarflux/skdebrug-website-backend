package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Inject;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Game> getAll(int teamid) {
        return addTeamInformation(gameRepository.getAll(teamid));
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

    public List<Game> getAllBetweenDates(DateTime start, DateTime end) {
        List<Game> allGames = getAll();
        Iterator<Game> gameIterator = allGames.iterator();
        while (gameIterator.hasNext()) {
            Game game = gameIterator.next();
            if (!game.getDate().isAfter(start)
                    || !game.getDate().isBefore(end)) {
                gameIterator.remove();
            }
        }
        return addTeamInformation(allGames);
    }

    public List<Game> getAllBeforeDate(DateTime end) {
        List<Game> allGames = getAll();
        Iterator<Game> gameIterator = allGames.iterator();
        while (gameIterator.hasNext()) {
            Game game = gameIterator.next();
            if (!game.getDate().isBefore(end)) {
                gameIterator.remove();
            }
        }
        return addTeamInformation(allGames);
    }

    public List<Game> getAllAfterDate(DateTime start) {
        List<Game> allGames = getAll();
        Iterator<Game> gameIterator = allGames.iterator();
        while (gameIterator.hasNext()) {
            Game game = gameIterator.next();
            if (!game.getDate().isAfter(start)) {
                gameIterator.remove();
            }
        }
        return addTeamInformation(allGames);
    }

    public List<Game> getAllBeforeDate(DateTime end, int teamid) {
        List<Game> allGames = getAll(teamid);
        Iterator<Game> gameIterator = allGames.iterator();
        while (gameIterator.hasNext()) {
            Game game = gameIterator.next();
            if (!game.getDate().isBefore(end)) {
                gameIterator.remove();
            }
        }
        return addTeamInformation(allGames);
    }

    public List<Game> getAllAfterDate(DateTime start, int teamid) {
        List<Game> allGames = getAll(teamid);
        Iterator<Game> gameIterator = allGames.iterator();
        while (gameIterator.hasNext()) {
            Game game = gameIterator.next();
            if (!game.getDate().isAfter(start)) {
                gameIterator.remove();
            }
        }
        return addTeamInformation(allGames);
    }

    public List<Game> getNextCertainAmountOfGames(int amount, int teamid) {
        List<Game> games = getAllAfterDate(DateTime.now(), teamid);
        Collections.sort(games, new Game.DateComperator());
        return games.size() > 0 ?
                games.subList(0, amount > (games.size()) ? (games.size()) : amount)
                : new ArrayList<Game>();
    }

    public List<Game> getPreviousCertainAmountOfGames(int amount, int teamid) {
        List<Game> games = getAllBeforeDate(DateTime.now(), teamid);
        Collections.sort(games, new Game.DateComperator());
        Collections.reverse(games);
        return games.size() > 0 ?
                games.subList(0, amount > (games.size()) ? (games.size()) : amount)
                : new ArrayList<Game>();
    }

    protected Game addTeamInformation(Game game) {
        game.setHomeTeam(teamRepository.get(game.getHomeTeam().getId()));
        game.setAwayTeam(teamRepository.get(game.getAwayTeam().getId()));
        return game;
    }

    protected List<Game> addTeamInformation(List<Game> games) {
        if (games != null && !games.isEmpty()) {
            for (Game game : games) {
                addTeamInformation(game);
            }
        }
        return games;
    }

}
