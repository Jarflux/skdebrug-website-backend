package be.skdebrug.website.repository;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.News;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class GameRepositoryTest {

    private GameRepository gameRepository;


    @Before
    public void before() {
        SQLiteConnection.databaseLocation = "test.db";
        GameRepository.dropDatabaseOnInjection = true;
        gameRepository = new GameRepository();
    }

    @Test
    public void testCreateAndGet(){
        Team home = new Team();
        home.setId(54321);
        home.setName("FC Barcelona");
        Team away = new Team();
        away.setId(12345);
        away.setName("Club Brugge");
        Game gameBefore = new Game();
        gameBefore.setDateStart(new DateTime());
        gameBefore.setHomeTeam(home);
        gameBefore.setAwayTeam(away);
        gameBefore.setHomeScore(2);
        gameBefore.setAwayScore(5);
        gameRepository.create(gameBefore);
        Game gameAfter = gameRepository.getAll().get(0);
        assertThat(gameAfter.getId()).isNotNull();
        assertThat(gameAfter.getDateStart()).isEqualTo(gameBefore.getDateStart());
        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
    }

}
