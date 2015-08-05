package be.skdebrug.website.repository;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class GameRepository extends AbstractRepository {

    private static final String TBL_GAME = "tbl_game";
    private static final String COL_GAME_ID = "gameID";
    private static final String COL_GAME_TYPE = "gametype";
    private static final String COL_GAME_START = "start";
    private static final String COL_GAME_HOME_TEAM = "homeTeam";
    private static final String COL_GAME_AWAY_TEAM = "awayTeam";
    private static final String COL_GAME_HOME_SCORE = "homeScore";
    private static final String COL_GAME_AWAY_SCORE = "awayScore";

    private Game parseGameFromResult(ResultSet queryResult) throws SQLException {
        Game game = new Game();
        game.setGameType(GameType.valueOf(queryResult.getString(COL_GAME_TYPE)));
        game.setId(queryResult.getInt(COL_GAME_ID));
        game.setDateStart(new DateTime(queryResult.getLong(COL_GAME_START)));
        Team home = new Team();
        home.setId(queryResult.getInt(COL_GAME_HOME_TEAM));
        game.setHomeTeam(home);
        Team away = new Team();
        away.setId(queryResult.getInt(COL_GAME_AWAY_TEAM));
        game.setAwayTeam(away);
        game.setHomeScore(queryResult.getInt(COL_GAME_HOME_SCORE));
        game.setAwayScore(queryResult.getInt(COL_GAME_AWAY_SCORE));
        return game;
    }

    public GameRepository() {
        if (dropDatabaseOnInjection) {
            (new SQLiteConnection<Boolean>() {
                @Override
                public Boolean defineOperation(Statement statement) throws SQLException {
                    statement.execute(log("DROP TABLE IF EXISTS " + TBL_GAME));
                    return true;
                }
            }).runOperation();
        }
        (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("CREATE TABLE IF NOT EXISTS " + TBL_GAME + " (" + COL_GAME_ID + " INTEGER PRIMARY KEY ASC,"
                        + COL_GAME_TYPE + ","
                        + COL_GAME_START + ","
                        + COL_GAME_HOME_TEAM + ","
                        + COL_GAME_AWAY_TEAM + ","
                        + COL_GAME_HOME_SCORE + ","
                        + COL_GAME_AWAY_SCORE + ","
                        + "CONSTRAINT unique_" + TBL_GAME + " UNIQUE(" + COL_GAME_ID + ") ON CONFLICT IGNORE );"));
                return true;
            }
        }).runOperation();
    }

    public boolean create(final Game game) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_GAME + " ("
                        + COL_GAME_TYPE + ","
                        + COL_GAME_START + ","
                        + COL_GAME_HOME_TEAM + ","
                        + COL_GAME_AWAY_TEAM + ","
                        + COL_GAME_HOME_SCORE + ","
                        + COL_GAME_AWAY_SCORE + ") "
                        + "VALUES ('"
                        + game.getGameType() + "','"
                        + game.getDateStart().getMillis() + "','"
                        + game.getHomeTeam().getId() + "','"
                        + game.getAwayTeam().getId() + "','"
                        + game.getHomeScore() + "','"
                        + game.getAwayScore() + "');"));
                return true;
            }
        }).runOperation();
    }

    public Game get(final int gameId) {
        return (new SQLiteConnection<Game>() {
            @Override
            public Game defineOperation(Statement statement) throws SQLException {
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_GAME + " WHERE " + COL_GAME_ID + " = '" + gameId + "'"));
                if (queryResult.next()) {
                    return parseGameFromResult(queryResult);
                }
                return null;
            }
        }).runOperation();
    }

    public List<Game> getAll() {
        return (new SQLiteConnection<List<Game>>() {
            @Override
            public List<Game> defineOperation(Statement statement) throws SQLException {
                List<Game> gameList = new ArrayList<>();
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_GAME));
                while (queryResult.next()) {
                    gameList.add(parseGameFromResult(queryResult));
                }
                return gameList;
            }
        }).runOperation();
    }

    public boolean update(final Game game) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_GAME + " ("
                        + COL_GAME_ID + ","
                        + COL_GAME_TYPE + ","
                        + COL_GAME_START + ","
                        + COL_GAME_HOME_TEAM + ","
                        + COL_GAME_AWAY_TEAM + ","
                        + COL_GAME_HOME_SCORE + ","
                        + COL_GAME_AWAY_SCORE + ") "
                        + "VALUES ('"
                        + game.getId() + "','"
                        + game.getGameType() + "','"
                        + game.getDateStart().getMillis() + "','"
                        + game.getHomeTeam().getId() + "','"
                        + game.getAwayTeam().getId() + "','"
                        + game.getHomeScore() + "','"
                        + game.getAwayScore() + "');"));
                return true;
            }
        }).runOperation();
    }

    public boolean delete(final int gameId) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("DELETE FROM " + TBL_GAME + " WHERE " + COL_GAME_ID + " = '" + gameId + "'"));
                return true;
            }
        }).runOperation();
    }

    public boolean deleteAll() {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("DELETE FROM " + TBL_GAME));
                return true;
            }
        }).runOperation();
    }
}
