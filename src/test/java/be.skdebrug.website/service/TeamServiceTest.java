package be.skdebrug.website.service;

import be.skdebrug.website.core.News;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.NewsRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Developer: Ben Oeyen
 * Date: 07/08/15
 */
public class TeamServiceTest {

    private TeamService teamService;

    private Team team;

    private List<Team> teams = new ArrayList<>();

    @Before
    public void before(){
        Injector injector = Guice.createInjector();
        teamService = new TeamService();
        injector.injectMembers(teamService);
        team = mock(Team.class);
        teams.add(team);
        teams.add(team);

        TeamRepository teamRepositoryMock = mock(TeamRepository.class);
        when(teamRepositoryMock.get(anyInt())).thenReturn(team);
        when(teamRepositoryMock.getAll()).thenReturn(teams);
        teamService.teamRepository = teamRepositoryMock;
    }

    @Test
    public void getTeamById(){
        assertThat(teamService.get(1)).isEqualTo(team);
    }

    @Test
    public void getAllTeams(){
        assertThat(teamService.getAll()).isEqualTo(teams);
        assertThat(teamService.getAll().size()).isEqualTo(2);
        assertThat(teamService.getAll().get(0)).isEqualTo(team);
        assertThat(teamService.getAll().get(1)).isEqualTo(team);
    }

    @Test
    public void deleteAllTeams(){
        teamService.deleteAll();
        verify(teamService.teamRepository, times(1)).deleteAll();
    }

    @Test
    public void deleteTeamById(){
        teamService.delete(1);
        verify(teamService.teamRepository, times(1)).delete(1);
    }

    @Test
    public void updateTeam(){
        teamService.update(team);
        verify(teamService.teamRepository, times(1)).update(team);
    }

    @Test
    public void createTeam(){
        teamService.create(team);
        verify(teamService.teamRepository, times(1)).create(team);
    }
}
