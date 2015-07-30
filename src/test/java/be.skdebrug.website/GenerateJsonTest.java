package be.skdebrug.website;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
import be.skdebrug.website.core.Team;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 27/07/15
 */
public class GenerateJsonTest {

    private Team teamA = new Team();
    private Team teamB = new Team();

    @Test
    public void generateMatchList() throws JsonProcessingException{
        teamA.setName("Sk De Brug");
        teamA.setId(1);
        teamB.setName("Anderlecht");
        teamB.setId(2);
        List<Game> games = new ArrayList<>();
        Game a = createGame(teamA, teamB, 1, 0);
        Game b = createGame(teamB, teamA, 5, -2);
        games.add(a);
        games.add(b);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        String matchListJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(games);
        System.out.print(matchListJson);
    }

    public Game createGame(Team homeTeam, Team awayTeam, int homeScore, int awayScore){
        Game game = new Game();
        game.setDateStart(DateTime.now());
        game.setGameType(GameType.CUP);
        game.setHomeTeam(homeTeam);
        game.setAwayTeam(awayTeam);
        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
        return game;
    }
}
