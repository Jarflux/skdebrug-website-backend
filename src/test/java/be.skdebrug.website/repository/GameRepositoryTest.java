package be.skdebrug.website.repository;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
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
        gameBefore.setDate(new DateTime());
        gameBefore.setGameType(GameType.CUP);
        gameBefore.setHomeTeam(home);
        gameBefore.setAwayTeam(away);
        gameBefore.setHomeScore(2);
        gameBefore.setAwayScore(5);
        gameRepository.create(gameBefore);
        Game gameAfter = gameRepository.getAll().get(0);
        assertThat(gameAfter.getId()).isNotNull();
        assertThat(gameAfter.getGameType()).isEqualTo(gameBefore.getGameType());
        assertThat(gameAfter.getDate()).isEqualTo(gameBefore.getDate());
        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
    }

    @Test
    public void testGetSpecificAndDelete(){
        Team home = new Team();
        home.setId(54321);
        home.setName("FC Barcelona");
        Team away = new Team();
        away.setId(12345);
        away.setName("Club Brugge");
        Game gameBefore = new Game();
        gameBefore.setDate(new DateTime());
        gameBefore.setGameType(GameType.CUP);
        gameBefore.setHomeTeam(home);
        gameBefore.setAwayTeam(away);
        gameBefore.setHomeScore(2);
        gameBefore.setAwayScore(5);
        gameRepository.create(gameBefore);
        int gameId = gameRepository.getAll().get(0).getId();
        Game gameAfter = gameRepository.get(gameId);
        assertThat(gameAfter.getId()).isNotNull();
        assertThat(gameAfter.getGameType()).isEqualTo(gameBefore.getGameType());
        assertThat(gameAfter.getDate()).isEqualTo(gameBefore.getDate());
        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
        gameRepository.delete(gameId);
        assertThat(gameRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testCreateAndUpdate(){
        Team home = new Team();
        home.setId(54321);
        home.setName("FC Barcelona");
        Team away = new Team();
        away.setId(12345);
        away.setName("Club Brugge");
        Game gameBefore = new Game();
        gameBefore.setDate(new DateTime());
        gameBefore.setGameType(GameType.LEAGUE);
        gameBefore.setHomeTeam(home);
        gameBefore.setAwayTeam(away);
        gameBefore.setHomeScore(2);
        gameBefore.setAwayScore(5);
        gameRepository.create(gameBefore);
        Game gameAfter = gameRepository.getAll().get(0);
        assertThat(gameAfter.getId()).isNotNull();
        assertThat(gameAfter.getGameType()).isEqualTo(gameBefore.getGameType());
        assertThat(gameAfter.getDate()).isEqualTo(gameBefore.getDate());
        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());

        gameBefore = gameRepository.getAll().get(0);
        gameBefore.setDate(new DateTime());
        gameBefore.setGameType(GameType.CUP);
        gameBefore.setHomeTeam(away);
        gameBefore.setAwayTeam(home);
        gameBefore.setHomeScore(123);
        gameBefore.setAwayScore(456);
        gameRepository.update(gameBefore);
        assertThat(gameRepository.getAll().size()).isEqualTo(1);
        gameAfter = gameRepository.getAll().get(0);
        assertThat(gameAfter.getId()).isNotNull();
        assertThat(gameAfter.getGameType()).isEqualTo(gameBefore.getGameType());
        assertThat(gameAfter.getDate()).isEqualTo(gameBefore.getDate());
        assertThat(gameAfter.getHomeTeam().getId()).isEqualTo(gameBefore.getHomeTeam().getId());
        assertThat(gameAfter.getAwayTeam().getId()).isEqualTo(gameBefore.getAwayTeam().getId());
        assertThat(gameAfter.getHomeScore()).isEqualTo(gameBefore.getHomeScore());
        assertThat(gameAfter.getAwayScore()).isEqualTo(gameBefore.getAwayScore());
    }

    @Test
    public void testCreateMultipleAndDeleteAll(){
        Team home = new Team();
        home.setId(54321);
        home.setName("FC Barcelona");
        Team away = new Team();
        away.setId(12345);
        away.setName("Club Brugge");
        Game gameBefore = new Game();
        gameBefore.setDate(new DateTime());
        gameBefore.setGameType(GameType.CUP);
        gameBefore.setHomeTeam(home);
        gameBefore.setAwayTeam(away);
        gameBefore.setHomeScore(2);
        gameBefore.setAwayScore(5);
        gameRepository.create(gameBefore);
        gameRepository.create(gameBefore);
        assertThat(gameRepository.getAll().size()).isEqualTo(2);
        gameRepository.deleteAll();
        assertThat(gameRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testGetGameWithUnexistingId(){
        assertThat(gameRepository.get(10000)).isEqualTo(null);
    }

    @Test
    public void testGetAllByTeamId(){
        Team home = new Team();
        home.setId(54321);
        home.setName("FC Barcelona");
        Team away = new Team();
        away.setId(12345);
        away.setName("Club Brugge");
        Game gameBefore = new Game();
        gameBefore.setDate(new DateTime());
        gameBefore.setGameType(GameType.CUP);
        gameBefore.setHomeTeam(home);
        gameBefore.setAwayTeam(away);
        gameBefore.setHomeScore(2);
        gameBefore.setAwayScore(5);
        gameRepository.create(gameBefore);

        Team home2 = new Team();
        home2.setId(12345);
        home2.setName("FC Barcelona");
        Team away2 = new Team();
        away2.setId(54321);
        away2.setName("Club Brugge");
        Game gameBefore2 = new Game();
        gameBefore2.setDate(new DateTime());
        gameBefore2.setGameType(GameType.CUP);
        gameBefore2.setHomeTeam(home2);
        gameBefore2.setAwayTeam(away2);
        gameBefore2.setHomeScore(2);
        gameBefore2.setAwayScore(5);
        gameRepository.create(gameBefore2);

        Team home3 = new Team();
        home3.setId(222222);
        home3.setName("FC Barcelona");
        Team away3 = new Team();
        away3.setId(111111);
        away3.setName("Club Brugge");
        Game gameBefore3 = new Game();
        gameBefore3.setDate(new DateTime());
        gameBefore3.setGameType(GameType.CUP);
        gameBefore3.setHomeTeam(home3);
        gameBefore3.setAwayTeam(away3);
        gameBefore3.setHomeScore(2);
        gameBefore3.setAwayScore(5);
        gameRepository.create(gameBefore3);

        assertThat(gameRepository.getAll(111111).size()).isEqualTo(1);
        assertThat(gameRepository.getAll(222222).size()).isEqualTo(1);
        assertThat(gameRepository.getAll(12345).size()).isEqualTo(2);
        assertThat(gameRepository.getAll(54321).size()).isEqualTo(2);
    }

}
