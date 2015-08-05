package be.skdebrug.website.repository;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.Player;
import be.skdebrug.website.core.PlayerType;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class PlayerRepositoryTest {

    private PlayerRepository playerRepository;


    @Before
    public void before() {
        SQLiteConnection.databaseLocation = "test.db";
        PlayerRepository.dropDatabaseOnInjection = true;
        playerRepository = new PlayerRepository();
    }

    @Test
    public void testCreateAndGet(){
        Player playerBefore = new Player();
        playerBefore.setFirstName("Gunther");
        playerBefore.setLastName("Dillen");
        playerBefore.setDateOfBirth(DateTime.now());
        playerBefore.setNumber(1);
        playerBefore.setPlayerType(PlayerType.GOALKEEPER);
        playerRepository.create(playerBefore);
        Player playerAfter = playerRepository.getAll().get(0);
        assertThat(playerAfter.getId()).isNotNull();
        assertThat(playerAfter.getFirstName()).isEqualTo(playerBefore.getFirstName());
        assertThat(playerAfter.getLastName()).isEqualTo(playerBefore.getLastName());
        assertThat(playerAfter.getDateOfBirth().getMillis()).isEqualTo(playerBefore.getDateOfBirth().getMillis());
        assertThat(playerAfter.getNumber()).isEqualTo(1);
        assertThat(playerAfter.getPlayerType()).isEqualTo(PlayerType.GOALKEEPER);
    }

//    @Test
//    public void testGetSpecificAndDelete(){
//        Team home = new Team();
//        home.setId(54321);
//        home.setName("FC Barcelona");
//        Team away = new Team();
//        away.setId(12345);
//        away.setName("Club Brugge");
//        Game gameBefore = new Game();
//        gameBefore.setDateStart(new DateTime());
//        gameBefore.setHomeTeam(home);
//        gameBefore.setAwayTeam(away);
//        gameBefore.setHomeScore(2);
//        gameBefore.setAwayScore(5);
//        gameRepository.create(gameBefore);
//        int gameId = gameRepository.getAll().get(0).getId();
//        Game gameAfter = gameRepository.get(gameId);
//        assertThat(gameAfter.getId()).isNotNull();
//        assertThat(gameAfter.getDateStart()).isEqualTo(gameBefore.getDateStart());
//        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
//        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
//        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
//        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
//        gameRepository.delete(gameId);
//        assertThat(gameRepository.getAll().size()).isEqualTo(0);
//    }
//
//    @Test
//    public void testCreateAndUpdate(){
//        Team home = new Team();
//        home.setId(54321);
//        home.setName("FC Barcelona");
//        Team away = new Team();
//        away.setId(12345);
//        away.setName("Club Brugge");
//        Game gameBefore = new Game();
//        gameBefore.setDateStart(new DateTime());
//        gameBefore.setHomeTeam(home);
//        gameBefore.setAwayTeam(away);
//        gameBefore.setHomeScore(2);
//        gameBefore.setAwayScore(5);
//        gameRepository.create(gameBefore);
//        Game gameAfter = gameRepository.getAll().get(0);
//        assertThat(gameAfter.getId()).isNotNull();
//        assertThat(gameAfter.getDateStart()).isEqualTo(gameBefore.getDateStart());
//        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
//        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
//        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
//        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
//
//        gameBefore.setDateStart(new DateTime());
//        gameBefore.setHomeTeam(away);
//        gameBefore.setAwayTeam(home);
//        gameBefore.setHomeScore(123);
//        gameBefore.setAwayScore(456);
//        gameRepository.update(gameBefore);
//        gameAfter = gameRepository.getAll().get(0);
//        assertThat(gameAfter.getId()).isNotNull();
//        assertThat(gameAfter.getDateStart()).isEqualTo(gameBefore.getDateStart());
//        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
//        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
//        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
//        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
//    }

    @Test
    public void testCreateMultipleAnd(){
        Player playerBefore = new Player();
        playerBefore.setFirstName("Gunther");
        playerBefore.setLastName("Dillen");
        playerBefore.setDateOfBirth(DateTime.now());
        playerBefore.setNumber(1);
        playerBefore.setPlayerType(PlayerType.GOALKEEPER);
        playerRepository.create(playerBefore);
        playerRepository.create(playerBefore);
        assertThat(playerRepository.getAll().size()).isEqualTo(2);
        playerRepository.deleteAll();
        assertThat(playerRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testGetPlayerWithUnexistingId(){
        assertThat(playerRepository.get(10000)).isEqualTo(null);
    }
}
