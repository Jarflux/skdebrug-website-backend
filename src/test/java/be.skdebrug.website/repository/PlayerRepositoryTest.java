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
        assertThat(playerAfter.getPlayerType()).isEqualTo(playerBefore.getPlayerType());
    }

    @Test
    public void testGetSpecificAndDelete(){
        Player playerBefore = new Player();
        playerBefore.setFirstName("Gunther");
        playerBefore.setLastName("Dillen");
        playerBefore.setDateOfBirth(DateTime.now());
        playerBefore.setNumber(1);
        playerBefore.setPlayerType(PlayerType.GOALKEEPER);
        playerRepository.create(playerBefore);
        int playerId = playerRepository.getAll().get(0).getId();
        Player playerAfter = playerRepository.get(playerId);
        assertThat(playerAfter.getId()).isNotNull();
        assertThat(playerAfter.getFirstName()).isEqualTo(playerBefore.getFirstName());
        assertThat(playerAfter.getLastName()).isEqualTo(playerBefore.getLastName());
        assertThat(playerAfter.getDateOfBirth().getMillis()).isEqualTo(playerBefore.getDateOfBirth().getMillis());
        assertThat(playerAfter.getNumber()).isEqualTo(1);
        assertThat(playerAfter.getPlayerType()).isEqualTo(playerBefore.getPlayerType());
        playerRepository.delete(playerId);
        assertThat(playerRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testCreateAndUpdate(){
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
        assertThat(playerAfter.getNumber()).isEqualTo(playerBefore.getNumber());
        assertThat(playerAfter.getPlayerType()).isEqualTo(playerBefore.getPlayerType());

        playerBefore = playerRepository.getAll().get(0);
        playerBefore.setFirstName("Gunther1");
        playerBefore.setLastName("Dillen1");
        playerBefore.setDateOfBirth(DateTime.now());
        playerBefore.setNumber(2);
        playerBefore.setPlayerType(PlayerType.STRIKER);
        playerRepository.update(playerBefore);
        assertThat(playerRepository.getAll().size()).isEqualTo(1);
        playerAfter = playerRepository.getAll().get(0);
        assertThat(playerAfter.getId()).isNotNull();
        assertThat(playerAfter.getFirstName()).isEqualTo(playerBefore.getFirstName());
        assertThat(playerAfter.getLastName()).isEqualTo(playerBefore.getLastName());
        assertThat(playerAfter.getDateOfBirth().getMillis()).isEqualTo(playerBefore.getDateOfBirth().getMillis());
        assertThat(playerAfter.getNumber()).isEqualTo(playerBefore.getNumber());
        assertThat(playerAfter.getPlayerType()).isEqualTo(playerBefore.getPlayerType());
    }

    @Test
    public void testCreateMultipleAndDeleteAll(){
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
