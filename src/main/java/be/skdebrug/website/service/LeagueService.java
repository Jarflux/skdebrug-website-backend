package be.skdebrug.website.service;

import be.skdebrug.website.core.League;
import com.google.inject.Inject;
import org.joda.time.DateTime;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class LeagueService {

    @Inject
    protected GameService gameService;

    public League getCurrent() {
        return get(DateTime.now().getMonthOfYear() > 7?DateTime.now().getYear():DateTime.now().getYear()-1);
    }

    public League get(int year){
        League league = new League();
        league.setYear(year);
        league.calculateStandings(gameService.getAllBetweenDates(league.getStartDate(), league.getEndDate()));
        return league;
    }
}
