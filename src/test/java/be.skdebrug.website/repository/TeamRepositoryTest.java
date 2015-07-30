package be.skdebrug.website.repository;

import be.skdebrug.website.endpoint.SQLiteConnection;
import org.junit.Before;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class TeamRepositoryTest {

    private TeamRepository teamRepository;

    @Before
    public void before() {
        SQLiteConnection.databaseLocation = "test.db";
        TeamRepository.dropDatabaseOnInjection = true;
        teamRepository = new TeamRepository();
    }

}
