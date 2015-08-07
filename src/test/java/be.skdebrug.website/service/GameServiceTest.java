package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.League;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Developer: Ben Oeyen
 * Date: 07/08/15
 */
public class GameServiceTest {

    private GameService gameService;

    private Game game;
    private Team team;
    private List<Game> games = new ArrayList<>();

    @Before
    public void before(){
        Injector injector = Guice.createInjector();
        gameService = new GameService();
        injector.injectMembers(gameService);
        team = mock(Team.class);
        when(team.getId()).thenReturn(1);
        game = mock(Game.class);
        when(game.getHomeTeam()).thenReturn(team);
        when(game.getAwayTeam()).thenReturn(team);
        games.add(game);
        games.add(game);
        TeamRepository teamRepositoryMock = mock(TeamRepository.class);
        when(teamRepositoryMock.get(anyInt())).thenReturn(team);
        GameRepository gameRepositoryMock = mock(GameRepository.class);
        when(gameRepositoryMock.get(anyInt())).thenReturn(game);
        when(gameRepositoryMock.getAll()).thenReturn(games);
        gameService.gameRepository = gameRepositoryMock;
        gameService.teamRepository = teamRepositoryMock;
    }

    @Test
    public void getGameById(){
        assertThat(gameService.get(1)).isEqualTo(game);
    }

    @Test
    public void getAllGames(){
        assertThat(gameService.getAll()).isEqualTo(games);
        assertThat(gameService.getAll().size()).isEqualTo(2);
        assertThat(gameService.getAll().get(0)).isEqualTo(game);
        assertThat(gameService.getAll().get(1)).isEqualTo(game);
    }

    @Test
    public void deleteAllGames(){
        gameService.deleteAll();
        verify(gameService.gameRepository, times(1)).deleteAll();
    }

    @Test
    public void deleteGameById(){
        gameService.delete(1);
        verify(gameService.gameRepository, times(1)).delete(1);
    }

    @Test
    public void updateGame(){
        gameService.update(game);
        verify(gameService.gameRepository, times(1)).update(game);
    }

    @Test
    public void createGame(){
        gameService.create(game);
        verify(gameService.gameRepository, times(1)).create(game);
    }
}
