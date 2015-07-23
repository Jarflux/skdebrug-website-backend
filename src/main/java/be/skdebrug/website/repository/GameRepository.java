package be.skdebrug.website.repository;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.endpoint.SQLiteConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class GameRepository {

    private static final String TBL_GAME = "tbl_game";
    private static final String COL_GAME_ID = "gameID";
    private static final String COL_GAME_HOME_SCORE = "homeScore";

    public static boolean dropDatabaseOnInjection = false;

    public static void setDatabaseLocation(String path) {
        SQLiteConnection.databaseLocation = path;
    }

    private Game parseNewsFromResult(ResultSet queryResult) throws SQLException {
        Game game = new Game();
        game.setId(queryResult.getInt(COL_GAME_ID));
        game.setHomeScore(queryResult.getInt(COL_GAME_HOME_SCORE));
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
                statement.execute(log("CREATE TABLE IF NOT EXISTS " + TBL_GAME + " (" + COL_GAME_ID + " INTEGER PRIMARY KEY ASC," + COL_GAME_HOME_SCORE + "," +
                        "CONSTRAINT unique_" + TBL_GAME + " UNIQUE(" + COL_GAME_ID + ") ON CONFLICT IGNORE );"));
                return true;
            }
        }).runOperation();
    }

    public boolean create(final Game game) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_GAME + " (" + COL_GAME_HOME_SCORE + ") "
                        + "VALUES ('" + game.getHomeScore() + "');"));
                return true;
            }
        }).runOperation();
    }

    public Game read(final String gameId) {
        return (new SQLiteConnection<Game>() {
            @Override
            public Game defineOperation(Statement statement) throws SQLException {
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_GAME + " WHERE " + COL_GAME_ID + " = '" + gameId + "'"));
                if (queryResult.next()) {
                    return parseNewsFromResult(queryResult);
                }
                return null;
            }
        }).runOperation();
    }

    public List<Game> readAll() {
        return (new SQLiteConnection<List<Game>>() {
            @Override
            public List<Game> defineOperation(Statement statement) throws SQLException {
                List<Game> gameList = new ArrayList<>();
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_GAME));
                while (queryResult.next()) {
                    gameList.add(parseNewsFromResult(queryResult));
                }
                return gameList;
            }
        }).runOperation();
    }

    public boolean update(final Game game) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_GAME + " (" + COL_GAME_ID + "," + COL_GAME_HOME_SCORE + ") "
                        + "VALUES ('" + game.getId() + "','" + game.getHomeScore() + "');"));
                return true;
            }
        }).runOperation();
    }

    public boolean delete(final String gameId) {
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
