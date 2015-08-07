package be.skdebrug.website.service;

import be.skdebrug.website.core.Player;
import be.skdebrug.website.repository.PlayerRepository;
import com.google.inject.Inject;

import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 06/08/15
 */
public class PlayerService {
    @Inject
    protected PlayerRepository playerRepository;

    public boolean create(final Player player) {
        return playerRepository.create(player);
    }

    public Player get(final int playerId) {
        return playerRepository.get(playerId);
    }

    public List<Player> getAll() {
        return playerRepository.getAll();
    }

    public boolean update(final Player player) {
        return playerRepository.update(player);
    }

    public boolean delete(final int playerId) {
        return playerRepository.delete(playerId);
    }

    public boolean deleteAll() {
        return playerRepository.deleteAll();
    }
}
