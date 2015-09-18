package be.skdebrug.website.core;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Developer: Ben Oeyen
 * Date: 17/09/15
 */
public class GameTest {

    @Test
    public void testComparator(){
        Game game = new Game();
        game.setDate(new DateTime());

        Game game2 = new Game();
        game2.setDate((new DateTime()).plusDays(7));

        Game.DateComperator comperator = new Game.DateComperator();
        assertThat(comperator.compare(game, game)).isEqualTo(0);
        assertThat(comperator.compare(game, game2)).isEqualTo(-1);
        assertThat(comperator.compare(game2, game)).isEqualTo(1);
    }
}
