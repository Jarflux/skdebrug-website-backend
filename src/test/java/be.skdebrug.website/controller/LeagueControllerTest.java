package be.skdebrug.website.controller;

import be.skdebrug.website.core.Standing;
import be.skdebrug.website.endpoint.SQLiteConnection;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.NewsRepository;
import be.skdebrug.website.repository.PlayerRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Developer: Ben Oeyen
 * Date: 23/10/15
 */
public class LeagueControllerTest {

    private DevController devController;
    private LeagueController leagueController;

    @Test
    public void testRealLeague() {
        SQLiteConnection.databaseLocation = "test.db";
        GameRepository.dropDatabaseOnInjection = false;
        NewsRepository.dropDatabaseOnInjection = false;
        PlayerRepository.dropDatabaseOnInjection = false;
        TeamRepository.dropDatabaseOnInjection = false;
        Injector injector = Guice.createInjector();
        devController = new DevController();
        injector.injectMembers(devController);
        devController.fill();
        leagueController = new LeagueController();
        injector.injectMembers(leagueController);
        assertThat(leagueController.get().getStandings().size()).isEqualTo(12);
        for(Standing standing: leagueController.get().getStandings()){
            assertThat(standing.getPoints()).isEqualTo(0);
        }
    }
}
