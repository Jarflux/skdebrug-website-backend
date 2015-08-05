package be.skdebrug.website.core;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Ben on 23/07/15.
 */
public class StandingTest {

    @Test
    public void testGamesCalculation(){
        Standing standing = new Standing();
        standing.setWins(5);
        standing.setTies(2);
        standing.setLosses(1);
        assertThat(standing.getGames()).isEqualTo(8);
    }

    @Test
    public void testPointsCalucaltion(){
        Standing standing = new Standing();
        standing.setWins(5);
        standing.setTies(2);
        standing.setLosses(1);
        assertThat(standing.getPoints()).isEqualTo(17);
    }

    @Test
    public void testGoalDifferenceCalculation(){
        Standing standing = new Standing();
        standing.setGoalsFor(5);
        standing.setGoalsAgainst(2);
        assertThat(standing.getGoalDifference()).isEqualTo(3);
    }


    @Test
    public void testStandingCompareEqual(){
        Standing top = new Standing();
        top.setWins(1);
        top.setTies(1);
        top.setLosses(1);
        top.setGoalsFor(1);
        top.setGoalsAgainst(1);
        Standing bottom = new Standing();
        bottom.setWins(1);
        bottom.setTies(1);
        bottom.setLosses(1);
        bottom.setGoalsFor(1);
        bottom.setGoalsAgainst(1);
        assertThat(top.compareTo(bottom)).isEqualTo(0);
    }

    @Test
     public void testStandingCompareWins(){
        Standing top = new Standing();
        top.setWins(2);
        top.setTies(0);
        top.setLosses(0);
        top.setGoalsFor(0);
        top.setGoalsAgainst(0);
        Standing bottom = new Standing();
        bottom.setWins(1);
        bottom.setTies(3);
        bottom.setLosses(0);
        bottom.setGoalsFor(0);
        bottom.setGoalsAgainst(0);
        assertThat(top.compareTo(bottom)).isEqualTo(-1);
    }

    @Test
    public void testStandingCompareWinsInverse(){
        Standing top = new Standing();
        top.setWins(1);
        top.setTies(3);
        top.setLosses(0);
        top.setGoalsFor(0);
        top.setGoalsAgainst(0);
        Standing bottom = new Standing();
        bottom.setWins(2);
        bottom.setTies(0);
        bottom.setLosses(0);
        bottom.setGoalsFor(0);
        bottom.setGoalsAgainst(0);
        assertThat(top.compareTo(bottom)).isEqualTo(1);
    }

    @Test
    public void testStandingCompareGoalsDifference(){
        Standing top = new Standing();
        top.setWins(1);
        top.setTies(1);
        top.setLosses(1);
        top.setGoalsFor(2);
        top.setGoalsAgainst(1);
        Standing bottom = new Standing();
        bottom.setWins(1);
        bottom.setTies(1);
        bottom.setLosses(1);
        bottom.setGoalsFor(1);
        bottom.setGoalsAgainst(1);
        assertThat(top.compareTo(bottom)).isEqualTo(-1);
    }

    @Test
    public void testStandingCompareGoalsDifferenceInverse(){
        Standing top = new Standing();
        top.setWins(1);
        top.setTies(1);
        top.setLosses(1);
        top.setGoalsFor(1);
        top.setGoalsAgainst(1);
        Standing bottom = new Standing();
        bottom.setWins(1);
        bottom.setTies(1);
        bottom.setLosses(1);
        bottom.setGoalsFor(2);
        bottom.setGoalsAgainst(1);
        assertThat(top.compareTo(bottom)).isEqualTo(1);
    }

    @Test
    public void testStandingCompareGoalsFor(){
        Standing top = new Standing();
        top.setWins(1);
        top.setTies(1);
        top.setLosses(1);
        top.setGoalsFor(2);
        top.setGoalsAgainst(1);
        Standing bottom = new Standing();
        bottom.setWins(1);
        bottom.setTies(1);
        bottom.setLosses(1);
        bottom.setGoalsFor(1);
        bottom.setGoalsAgainst(0);
        assertThat(top.compareTo(bottom)).isEqualTo(-1);
    }

    @Test
    public void testStandingCompareGoalsForInverse(){
        Standing top = new Standing();
        top.setWins(1);
        top.setTies(1);
        top.setLosses(1);
        top.setGoalsFor(2);
        top.setGoalsAgainst(0);
        Standing bottom = new Standing();
        bottom.setWins(1);
        bottom.setTies(1);
        bottom.setLosses(1);
        bottom.setGoalsFor(3);
        bottom.setGoalsAgainst(1);
        assertThat(top.compareTo(bottom)).isEqualTo(1);
    }

    @Test
    public void testAddHomeTeamWin(){
        Team home = new Team();
        home.setId(1);
        home.setName("Sk De Brug");
        Team away = new Team();
        away.setId(2);
        away.setName("FC Barcelona");

        Game game = new Game();
        game.setHomeTeam(home);
        game.setAwayTeam(away);
        game.setHomeScore(2);
        game.setAwayScore(1);

        Standing standing = new Standing();
        standing.setTeam(home);
        standing.addStatisticsFromGame(game);

        assertThat(standing.getTeam().getName()).isEqualTo(home.getName());
        assertThat(standing.getTeam().getId()).isEqualTo(home.getId());
        assertThat(standing.getGames()).isEqualTo(1);
        assertThat(standing.getWins()).isEqualTo(1);
        assertThat(standing.getTies()).isEqualTo(0);
        assertThat(standing.getLosses()).isEqualTo(0);
        assertThat(standing.getGoalsFor()).isEqualTo(2);
        assertThat(standing.getGoalsAgainst()).isEqualTo(1);
        assertThat(standing.getGoalDifference()).isEqualTo(1);
    }

    @Test
    public void testAddHomeTeamLoss(){
        Team home = new Team();
        home.setId(1);
        home.setName("Sk De Brug");
        Team away = new Team();
        away.setId(2);
        away.setName("FC Barcelona");

        Game game = new Game();
        game.setHomeTeam(home);
        game.setAwayTeam(away);
        game.setHomeScore(1);
        game.setAwayScore(2);

        Standing standing = new Standing();
        standing.setTeam(home);
        standing.addStatisticsFromGame(game);

        assertThat(standing.getTeam().getName()).isEqualTo(home.getName());
        assertThat(standing.getTeam().getId()).isEqualTo(home.getId());
        assertThat(standing.getGames()).isEqualTo(1);
        assertThat(standing.getWins()).isEqualTo(0);
        assertThat(standing.getTies()).isEqualTo(0);
        assertThat(standing.getLosses()).isEqualTo(1);
        assertThat(standing.getGoalsFor()).isEqualTo(1);
        assertThat(standing.getGoalsAgainst()).isEqualTo(2);
        assertThat(standing.getGoalDifference()).isEqualTo(-1);
    }

    @Test
    public void testAddHomeTeamTie(){
        Team home = new Team();
        home.setId(1);
        home.setName("Sk De Brug");
        Team away = new Team();
        away.setId(2);
        away.setName("FC Barcelona");

        Game game = new Game();
        game.setHomeTeam(home);
        game.setAwayTeam(away);
        game.setHomeScore(2);
        game.setAwayScore(2);

        Standing standing = new Standing();
        standing.setTeam(home);
        standing.addStatisticsFromGame(game);

        assertThat(standing.getTeam().getName()).isEqualTo(home.getName());
        assertThat(standing.getTeam().getId()).isEqualTo(home.getId());
        assertThat(standing.getGames()).isEqualTo(1);
        assertThat(standing.getWins()).isEqualTo(0);
        assertThat(standing.getTies()).isEqualTo(1);
        assertThat(standing.getLosses()).isEqualTo(0);
        assertThat(standing.getGoalsFor()).isEqualTo(2);
        assertThat(standing.getGoalsAgainst()).isEqualTo(2);
        assertThat(standing.getGoalDifference()).isEqualTo(0);
    }

    @Test
    public void testAddAwayTeamWin(){
        Team home = new Team();
        home.setId(1);
        home.setName("Sk De Brug");
        Team away = new Team();
        away.setId(2);
        away.setName("FC Barcelona");

        Game game = new Game();
        game.setHomeTeam(home);
        game.setAwayTeam(away);
        game.setHomeScore(1);
        game.setAwayScore(2);

        Standing standing = new Standing();
        standing.setTeam(away);
        standing.addStatisticsFromGame(game);

        assertThat(standing.getTeam().getName()).isEqualTo(away.getName());
        assertThat(standing.getTeam().getId()).isEqualTo(away.getId());
        assertThat(standing.getGames()).isEqualTo(1);
        assertThat(standing.getWins()).isEqualTo(1);
        assertThat(standing.getTies()).isEqualTo(0);
        assertThat(standing.getLosses()).isEqualTo(0);
        assertThat(standing.getGoalsFor()).isEqualTo(2);
        assertThat(standing.getGoalsAgainst()).isEqualTo(1);
        assertThat(standing.getGoalDifference()).isEqualTo(1);
    }

    @Test
    public void testAddAwayTeamLoss(){
        Team home = new Team();
        home.setId(1);
        home.setName("Sk De Brug");
        Team away = new Team();
        away.setId(2);
        away.setName("FC Barcelona");

        Game game = new Game();
        game.setHomeTeam(home);
        game.setAwayTeam(away);
        game.setHomeScore(2);
        game.setAwayScore(1);

        Standing standing = new Standing();
        standing.setTeam(away);
        standing.addStatisticsFromGame(game);

        assertThat(standing.getTeam().getName()).isEqualTo(away.getName());
        assertThat(standing.getTeam().getId()).isEqualTo(away.getId());
        assertThat(standing.getGames()).isEqualTo(1);
        assertThat(standing.getWins()).isEqualTo(0);
        assertThat(standing.getTies()).isEqualTo(0);
        assertThat(standing.getLosses()).isEqualTo(1);
        assertThat(standing.getGoalsFor()).isEqualTo(1);
        assertThat(standing.getGoalsAgainst()).isEqualTo(2);
        assertThat(standing.getGoalDifference()).isEqualTo(-1);
    }

    @Test
    public void testAddAwayTeamTie(){
        Team home = new Team();
        home.setId(1);
        home.setName("Sk De Brug");
        Team away = new Team();
        away.setId(2);
        away.setName("FC Barcelona");

        Game game = new Game();
        game.setHomeTeam(home);
        game.setAwayTeam(away);
        game.setHomeScore(2);
        game.setAwayScore(2);

        Standing standing = new Standing();
        standing.setTeam(away);
        standing.addStatisticsFromGame(game);

        assertThat(standing.getTeam().getName()).isEqualTo(away.getName());
        assertThat(standing.getTeam().getId()).isEqualTo(away.getId());
        assertThat(standing.getGames()).isEqualTo(1);
        assertThat(standing.getWins()).isEqualTo(0);
        assertThat(standing.getTies()).isEqualTo(1);
        assertThat(standing.getLosses()).isEqualTo(0);
        assertThat(standing.getGoalsFor()).isEqualTo(2);
        assertThat(standing.getGoalsAgainst()).isEqualTo(2);
        assertThat(standing.getGoalDifference()).isEqualTo(0);
    }
}
