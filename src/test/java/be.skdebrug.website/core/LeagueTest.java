package be.skdebrug.website.core;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Ben on 23/07/15.
 */
public class LeagueTest {

    @Test
    public void testStartEndDateCalculation(){
        League season = new League();
        season.setYear(2050);
        assertThat(season.getStartDate().dayOfMonth().get()).isEqualTo(1);
        assertThat(season.getStartDate().monthOfYear().get()).isEqualTo(8);
        assertThat(season.getStartDate().year().get()).isEqualTo(2050);

        assertThat(season.getEndDate().dayOfMonth().get()).isEqualTo(1);
        assertThat(season.getEndDate().monthOfYear().get()).isEqualTo(7);
        assertThat(season.getEndDate().year().get()).isEqualTo(2051);
    }

}
