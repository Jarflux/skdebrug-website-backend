package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.News;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.NewsRepository;
import com.google.inject.Inject;

import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class GameService {

    @Inject
    GameRepository gameRepository;

    public boolean create(final Game game) {
        return gameRepository.create(game);
    }

    public Game read(final String gameId) {
        return gameRepository.read(gameId);
    }

    public List<Game> readAll() {
        return gameRepository.readAll();
    }

    public boolean update(final Game game) {
        return gameRepository.update(game);
    }

    public boolean delete(final String gameId) {
        return gameRepository.delete(gameId);
    }

    public boolean deleteAll() {
        return gameRepository.deleteAll();
    }
}
