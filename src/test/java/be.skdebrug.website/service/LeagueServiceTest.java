package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.League;
import be.skdebrug.website.core.Standing;
import be.skdebrug.website.core.Team;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class LeagueServiceTest {

    private GameService gameService;

    @Inject
    private LeagueService leagueService;

    private Team teamA = new Team();
    private Team teamB = new Team();
    private Team teamC = new Team();
    private Team teamD = new Team();

    @Before
    public void before(){
        Injector injector = Guice.createInjector();
        leagueService = new LeagueService();
        injector.injectMembers(leagueService);
        gameService = mock(GameService.class);
        leagueService.gameService = gameService;
        teamA.setName("A");
        teamB.setName("B");
        teamC.setName("C");
        teamD.setName("D");
    }

    @Test
    public void testLeagueCalculation() throws JsonProcessingException{
        List<Game> games = new ArrayList<>();
        games.add(createGame(teamA, teamB, 1, 0));
        games.add(createGame(teamC, teamD, 2, 0));
        games.add(createGame(teamA, teamC, 3, 0));
        games.add(createGame(teamC, teamB, 4, 0));
        when(gameService.getAllLeagueBetweenDates(any(DateTime.class), any(DateTime.class))).thenReturn(games);
        League league = leagueService.get(2012);
        List<Standing> standings = league.getStandings();
        // Team A 2 0 0 4 0 4 6
        // Team C 2 0 1 6 3 3 6
        // Team D 0 0 1 0 2 -2 0
        // Team B 0 0 2 0 5 -5 0
        assertThat(standings.get(0).getTeam().getName()).isEqualTo(teamA.getName());
        assertThat(standings.get(0).getGames()).isEqualTo(2);
        assertThat(standings.get(0).getWins()).isEqualTo(2);
        assertThat(standings.get(0).getLosses()).isEqualTo(0);
        assertThat(standings.get(0).getTies()).isEqualTo(0);
        assertThat(standings.get(0).getGoalsFor()).isEqualTo(4);
        assertThat(standings.get(0).getGoalsAgainst()).isEqualTo(0);
        assertThat(standings.get(0).getGoalDifference()).isEqualTo(4);
        assertThat(standings.get(0).getPoints()).isEqualTo(6);

        assertThat(standings.get(1).getTeam().getName()).isEqualTo(teamC.getName());
        assertThat(standings.get(1).getGames()).isEqualTo(3);
        assertThat(standings.get(1).getWins()).isEqualTo(2);
        assertThat(standings.get(1).getLosses()).isEqualTo(1);
        assertThat(standings.get(1).getTies()).isEqualTo(0);
        assertThat(standings.get(1).getGoalsFor()).isEqualTo(6);
        assertThat(standings.get(1).getGoalsAgainst()).isEqualTo(3);
        assertThat(standings.get(1).getGoalDifference()).isEqualTo(3);
        assertThat(standings.get(1).getPoints()).isEqualTo(6);

        assertThat(standings.get(2).getTeam().getName()).isEqualTo(teamD.getName());
        assertThat(standings.get(2).getGames()).isEqualTo(1);
        assertThat(standings.get(2).getWins()).isEqualTo(0);
        assertThat(standings.get(2).getLosses()).isEqualTo(1);
        assertThat(standings.get(2).getTies()).isEqualTo(0);
        assertThat(standings.get(2).getGoalsFor()).isEqualTo(0);
        assertThat(standings.get(2).getGoalsAgainst()).isEqualTo(2);
        assertThat(standings.get(2).getGoalDifference()).isEqualTo(-2);
        assertThat(standings.get(2).getPoints()).isEqualTo(0);

        assertThat(standings.get(3).getTeam().getName()).isEqualTo(teamB.getName());
        assertThat(standings.get(3).getGames()).isEqualTo(2);
        assertThat(standings.get(3).getWins()).isEqualTo(0);
        assertThat(standings.get(3).getLosses()).isEqualTo(2);
        assertThat(standings.get(3).getTies()).isEqualTo(0);
        assertThat(standings.get(3).getGoalsFor()).isEqualTo(0);
        assertThat(standings.get(3).getGoalsAgainst()).isEqualTo(5);
        assertThat(standings.get(3).getGoalDifference()).isEqualTo(-5);
        assertThat(standings.get(3).getPoints()).isEqualTo(0);
    }

    public Game createGame(Team homeTeam, Team awayTeam, int homeScore, int awayScore){
        Game game = new Game();
        game.setHomeTeam(homeTeam);
        game.setAwayTeam(awayTeam);
        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
        return game;
    }
}
