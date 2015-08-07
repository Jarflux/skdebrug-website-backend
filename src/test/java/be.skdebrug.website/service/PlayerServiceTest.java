package be.skdebrug.website.service;

import be.skdebrug.website.core.Player;
import be.skdebrug.website.repository.PlayerRepository;
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
public class PlayerServiceTest {

    private PlayerService playerService;

    private Player player;
    private List<Player> players = new ArrayList<>();

    @Before
    public void before(){
        Injector injector = Guice.createInjector();
        playerService = new PlayerService();
        injector.injectMembers(playerService);
        player = mock(Player.class);
        players.add(player);
        players.add(player);

        PlayerRepository playerRepositoryMock = mock(PlayerRepository.class);
        when(playerRepositoryMock.get(anyInt())).thenReturn(player);
        when(playerRepositoryMock.getAll()).thenReturn(players);
        playerService.playerRepository = playerRepositoryMock;
    }

    @Test
    public void getPlayerById(){
        assertThat(playerService.get(1)).isEqualTo(player);
    }

    @Test
    public void getAllPlayers(){
        assertThat(playerService.getAll()).isEqualTo(players);
        assertThat(playerService.getAll().size()).isEqualTo(2);
        assertThat(playerService.getAll().get(0)).isEqualTo(player);
        assertThat(playerService.getAll().get(1)).isEqualTo(player);
    }

    @Test
    public void deleteAllPlayers(){
        playerService.deleteAll();
        verify(playerService.playerRepository, times(1)).deleteAll();
    }

    @Test
    public void deletePlayerById(){
        playerService.delete(1);
        verify(playerService.playerRepository, times(1)).delete(1);
    }

    @Test
    public void updatePlayer(){
        playerService.update(player);
        verify(playerService.playerRepository, times(1)).update(player);
    }

    @Test
    public void createPlayer(){
        playerService.create(player);
        verify(playerService.playerRepository, times(1)).create(player);
    }
}
