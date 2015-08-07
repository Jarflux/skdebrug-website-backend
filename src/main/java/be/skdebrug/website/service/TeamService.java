package be.skdebrug.website.service;

import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Inject;

import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class TeamService {

    @Inject
    protected TeamRepository teamRepository;

    public boolean create(final Team team) {
        return teamRepository.create(team);
    }

    public Team get(final int teamId) {
        return teamRepository.get(teamId);
    }

    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    public boolean update(final Team team) {
        return teamRepository.update(team);
    }

    public boolean delete(final int teamId) {
        return teamRepository.delete(teamId);
    }

    public boolean deleteAll() {
        return teamRepository.deleteAll();
    }

}
