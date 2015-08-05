package be.skdebrug.website.repository;

import be.skdebrug.website.core.Player;
import be.skdebrug.website.core.Player;
import be.skdebrug.website.core.PlayerType;
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
public class PlayerRepository extends AbstractRepository {

    private static final String TBL_PLAYER = "tbl_player";
    private static final String COL_PLAYER_ID = "payerID";
    private static final String COL_PLAYER_FIRST_NAME = "firstName";
    private static final String COL_PLAYER_LAST_NAME = "lastName";
    private static final String COL_PLAYER_DATE_OF_BIRTH = "dateOfBirth";
    private static final String COL_PLAYER_NUMBER = "number";
    private static final String COL_PLAYER_TYPE = "type";

    private Player parsePlayerFromResult(ResultSet queryResult) throws SQLException {
        Player player = new Player();
        player.setId(queryResult.getInt(COL_PLAYER_ID));
        player.setFirstName(queryResult.getString(COL_PLAYER_FIRST_NAME));
        player.setLastName(queryResult.getString(COL_PLAYER_LAST_NAME));
        player.setDateOfBirth(new DateTime(queryResult.getLong(COL_PLAYER_DATE_OF_BIRTH)));
        player.setNumber(queryResult.getInt(COL_PLAYER_NUMBER));
        player.setPlayerType(PlayerType.valueOf(queryResult.getString(COL_PLAYER_TYPE)));
        return player;
    }

    public PlayerRepository() {
        if (dropDatabaseOnInjection) {
            (new SQLiteConnection<Boolean>() {
                @Override
                public Boolean defineOperation(Statement statement) throws SQLException {
                    statement.execute(log("DROP TABLE IF EXISTS " + TBL_PLAYER));
                    return true;
                }
            }).runOperation();
        }
        (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("CREATE TABLE IF NOT EXISTS " + TBL_PLAYER + " (" + COL_PLAYER_ID + " INTEGER PRIMARY KEY ASC,"
                        + COL_PLAYER_FIRST_NAME + ","
                        + COL_PLAYER_LAST_NAME + ","
                        + COL_PLAYER_DATE_OF_BIRTH + ","
                        + COL_PLAYER_NUMBER + ","
                        + COL_PLAYER_TYPE + ","
                        + "CONSTRAINT unique_" + TBL_PLAYER + " UNIQUE(" + COL_PLAYER_ID + ") ON CONFLICT IGNORE );"));
                return true;
            }
        }).runOperation();
    }

    public boolean create(final Player player) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_PLAYER + " ("
                        + COL_PLAYER_FIRST_NAME + ","
                        + COL_PLAYER_LAST_NAME + ","
                        + COL_PLAYER_DATE_OF_BIRTH + ","
                        + COL_PLAYER_NUMBER + ","
                        + COL_PLAYER_TYPE
                        + ") VALUES ('"
                        + escapeSingleQuotes(player.getFirstName()) + "','"
                        + escapeSingleQuotes(player.getLastName()) + "','"
                        + player.getDateOfBirth().getMillis() + "','"
                        + player.getNumber() + "','"
                        + player.getPlayerType() + "');"));
                return true;
            }
        }).runOperation();
    }

    public Player get(final int gameId) {
        return (new SQLiteConnection<Player>() {
            @Override
            public Player defineOperation(Statement statement) throws SQLException {
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_PLAYER + " WHERE " + COL_PLAYER_ID + " = '" + gameId + "'"));
                if (queryResult.next()) {
                    return parsePlayerFromResult(queryResult);
                }
                return null;
            }
        }).runOperation();
    }

    public List<Player> getAll() {
        return (new SQLiteConnection<List<Player>>() {
            @Override
            public List<Player> defineOperation(Statement statement) throws SQLException {
                List<Player> playerList = new ArrayList<>();
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_PLAYER));
                while (queryResult.next()) {
                    playerList.add(parsePlayerFromResult(queryResult));
                }
                return playerList;
            }
        }).runOperation();
    }

    public boolean update(final Player player) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("UPDATE " + TBL_PLAYER
                        + " SET "
                        + COL_PLAYER_FIRST_NAME + " = '" + player.getFirstName() + "', "
                        + COL_PLAYER_LAST_NAME + " = '" + player.getLastName() + "', "
                        + COL_PLAYER_DATE_OF_BIRTH + " = '" + player.getDateOfBirth().getMillis() + "', "
                        + COL_PLAYER_NUMBER + " = '" + player.getNumber() + "', "
                        + COL_PLAYER_TYPE + " = '" + player.getPlayerType() + "' "
                        + "WHERE " + COL_PLAYER_ID + " = '" + player.getId() + "' "));
                return true;
            }
        }).runOperation();
    }

    public boolean delete(final int playerId) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("DELETE FROM " + TBL_PLAYER + " WHERE " + COL_PLAYER_ID + " = '" + playerId + "'"));
                return true;
            }
        }).runOperation();
    }

    public boolean deleteAll() {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("DELETE FROM " + TBL_PLAYER));
                return true;
            }
        }).runOperation();
    }
}
