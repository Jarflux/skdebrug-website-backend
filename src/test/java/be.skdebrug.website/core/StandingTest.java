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
}
