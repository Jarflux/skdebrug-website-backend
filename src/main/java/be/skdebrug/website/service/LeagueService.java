package be.skdebrug.website.service;

import be.skdebrug.website.core.League;
import be.skdebrug.website.core.Standing;
import com.google.inject.Inject;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class LeagueService {

    @Inject
    private StandingService standingService;

    public League getCurrent() {
        return get(DateTime.now().getYear());
    }

    //TODO Test Method
    public League get(int year){
        League league = new League();
        league.setYear(year);

        for(Standing standing: standingService.getAll(year)) {
            league.add(standing);
        }

        league.sort();
        return league;
    }
}
