package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Guice;
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
        when(game.getDate()).thenReturn(new DateTime());
        games.add(game);
        games.add(game);
        games.add(game);
        games.add(game);
        games.add(game);
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
        assertThat(gameService.getAll().size()).isEqualTo(7);
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


    @Test
    public void getAllBefore(){
        List<Game> games = new ArrayList<>();
        games.add(createMockGame(1, new DateTime().plusDays(21)));
        games.add(createMockGame(4, new DateTime()));
        games.add(createMockGame(2, new DateTime().plusDays(14)));
        games.add(createMockGame(5, new DateTime().minusDays(7)));
        games.add(createMockGame(3, new DateTime().plusDays(7)));
        GameRepository gameRepositoryMock = mock(GameRepository.class);
        when(gameRepositoryMock.getAll()).thenReturn(games);
        gameService.gameRepository = gameRepositoryMock;
        assertThat(gameService.getAllAfterDate(new DateTime()).size()).isEqualTo(3);
    }

    @Test
    public void getAllAfter(){
        List<Game> games = new ArrayList<>();
        games.add(createMockGame(1, new DateTime().plusDays(21)));
        games.add(createMockGame(4, new DateTime()));
        games.add(createMockGame(2, new DateTime().plusDays(14)));
        games.add(createMockGame(5, new DateTime().minusDays(7)));
        games.add(createMockGame(3, new DateTime().plusDays(7)));
        GameRepository gameRepositoryMock = mock(GameRepository.class);
        when(gameRepositoryMock.getAll()).thenReturn(games);
        gameService.gameRepository = gameRepositoryMock;
        assertThat(gameService.getAllBeforeDate(new DateTime()).size()).isEqualTo(2);
    }

    @Test
    public void getAllLeagueBetweenDates(){
        List<Game> games = new ArrayList<>();
        games.add(createMockGame(5, new DateTime().minusDays(21)));
        games.add(createMockGame(5, new DateTime().minusDays(14)));
        games.add(createMockGame(5, new DateTime().minusDays(7)));
        games.add(createMockGame(4, new DateTime()));
        games.add(createMockGame(3, new DateTime().plusDays(7)));
        games.add(createMockGame(2, new DateTime().plusDays(14)));
        games.add(createMockGame(1, new DateTime().plusDays(21)));
        GameRepository gameRepositoryMock = mock(GameRepository.class);
        when(gameRepositoryMock.getAll()).thenReturn(games);
        gameService.gameRepository = gameRepositoryMock;
        assertThat(gameService.getAllLeagueBetweenDates(new DateTime().minusDays(8), new DateTime().plusDays(15)).size()).isEqualTo(4);
    }

    @Test
    public void getNext5Games(){
        List<Game> games = new ArrayList<>();
        games.add(createMockGame(1, new DateTime().plusDays(21)));
        games.add(createMockGame(2, new DateTime().plusDays(14)));
        games.add(createMockGame(3, new DateTime().plusDays(7)));
        GameRepository gameRepositoryMock = mock(GameRepository.class);
        when(gameRepositoryMock.getAll(any(Integer.class))).thenReturn(games);
        gameService.gameRepository = gameRepositoryMock;

        List<Game> nextGames = gameService.getNextCertainAmountOfGames(3, 1);
        assertThat(nextGames.size()).isEqualTo(3);
        assertThat(nextGames.get(0).getId()).isEqualTo(3);
        assertThat(nextGames.get(1).getId()).isEqualTo(2);
        assertThat(nextGames.get(2).getId()).isEqualTo(1);
    }

    @Test
    public void getPrev5Games(){
        List<Game> games = new ArrayList<>();
        games.add(createMockGame(1, new DateTime().minusDays(21)));
        games.add(createMockGame(2, new DateTime().minusDays(14)));
        games.add(createMockGame(3, new DateTime().minusDays(7)));
        GameRepository gameRepositoryMock = mock(GameRepository.class);
        when(gameRepositoryMock.getAll(any(Integer.class))).thenReturn(games);
        gameService.gameRepository = gameRepositoryMock;

        List<Game> prevGames = gameService.getPreviousCertainAmountOfGames(2, 1);
        assertThat(prevGames.size()).isEqualTo(2);
        assertThat(prevGames.get(0).getId()).isEqualTo(3);
        assertThat(prevGames.get(1).getId()).isEqualTo(2);
    }

    private Game createMockGame(int id, DateTime dateTime){
        Game game = mock(Game.class);
        when(game.getGameType()).thenReturn(GameType.LEAGUE);
        when(game.getId()).thenReturn(id);
        when(game.getDate()).thenReturn(dateTime);
        Team team = mock(Team.class);
        when(team.getId()).thenReturn(1);
        when(game.getHomeTeam()).thenReturn(team);
        when(game.getAwayTeam()).thenReturn(team);
        return game;
    }

}
