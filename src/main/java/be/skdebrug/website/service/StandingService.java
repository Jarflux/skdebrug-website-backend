package be.skdebrug.website.service;

import be.skdebrug.website.core.Standing;
import be.skdebrug.website.repository.GameRepository;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 24/07/15
 */
public class StandingService {

    @Inject
    GameRepository gameRepository;

    public List<Standing> getAll(int year){
        List<Standing> standings = new ArrayList<>();
        gameRepository.readAll();
        return standings;
    }
}
