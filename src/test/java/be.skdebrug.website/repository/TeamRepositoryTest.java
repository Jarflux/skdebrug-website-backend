package be.skdebrug.website.repository;

import be.skdebrug.website.core.News;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

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

    @Test
    public void testCreateAndGet(){
        Team teamBefore = new Team();
        teamBefore.setName("Anderlecht");
        teamRepository.create(teamBefore);
        Team teamAfter = teamRepository.getAll().get(0);
        assertThat(teamAfter.getId()).isNotNull();
        assertThat(teamAfter.getName()).isEqualTo(teamBefore.getName());
    }

    @Test
    public void testGetSpecificAndDelete(){
        Team teamBefore = new Team();
        teamBefore.setName("Anderlecht");
        teamRepository.create(teamBefore);
        teamBefore =  teamRepository.getAll().get(0);
        int teamId = teamBefore.getId();
        Team teamAfter = teamRepository.get(teamId);
        assertThat(teamAfter.getId()).isEqualTo(teamBefore.getId());
        assertThat(teamAfter.getName()).isEqualTo(teamBefore.getName());
        teamRepository.delete(teamId);
        assertThat(teamRepository.getAll().size()).isEqualTo(0);
    }


}
