package be.skdebrug.website.repository;

import be.skdebrug.website.core.Team;
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
public class TeamRepository extends AbstractRepository {
    private static final String TBL_TEAM = "tbl_team";
    private static final String COL_TEAM_ID = "id";
    private static final String COL_TEAM_NAME = "name";

    private Team parseTeamFromResult(ResultSet queryResult) throws SQLException{
        Team team = new Team();
        team.setId(queryResult.getInt(COL_TEAM_ID));
        team.setName(queryResult.getString(COL_TEAM_NAME));
        return team;
    }

    public TeamRepository() {
        if (dropDatabaseOnInjection) {
            (new SQLiteConnection<Boolean>() {
                @Override
                public Boolean defineOperation(Statement statement) throws SQLException {
                    statement.execute(log("DROP TABLE IF EXISTS " + TBL_TEAM));
                    return true;
                }
            }).runOperation();
        }
        (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("CREATE TABLE IF NOT EXISTS " + TBL_TEAM + " (" + COL_TEAM_ID + " INTEGER PRIMARY KEY ASC," + COL_TEAM_NAME + "," +
                        "CONSTRAINT unique_" + TBL_TEAM + " UNIQUE(" + COL_TEAM_ID + ") ON CONFLICT IGNORE );"));
                return true;
            }
        }).runOperation();
    }

    public boolean create(final Team team) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_TEAM + " ("
                        + COL_TEAM_NAME
                        + ") VALUES ('"
                        + escapeSingleQuotes(team.getName())
                        + "');"));
                return true;
            }
        }).runOperation();
    }

    public Team get(final int teamId) {
        return (new SQLiteConnection<Team>() {
            @Override
            public Team defineOperation(Statement statement) throws SQLException {
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_TEAM + " WHERE " + COL_TEAM_ID + " = '" + teamId + "'"));
                if (queryResult.next()) {
                    return parseTeamFromResult(queryResult);
                }
                return null;
            }
        }).runOperation();
    }

    public List<Team> getAll() {
        return (new SQLiteConnection<List<Team>>() {
            @Override
            public List<Team> defineOperation(Statement statement) throws SQLException {
                List<Team> teamList = new ArrayList<>();
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_TEAM));
                while (queryResult.next()) {
                    teamList.add(parseTeamFromResult(queryResult));
                }
                return teamList;
            }
        }).runOperation();
    }

    public boolean update(final Team team) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("UPDATE " + TBL_TEAM
                        + " SET "
                        + COL_TEAM_NAME + " = '" + escapeSingleQuotes(team.getName()) + "' "
                        + "WHERE " + COL_TEAM_ID + " = '" + team.getId() + "' "));
                return true;
            }
        }).runOperation();
    }

    public boolean delete(final int teamId) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("DELETE FROM " + TBL_TEAM + " WHERE " + COL_TEAM_ID + " = '" + teamId + "'"));
                return true;
            }
        }).runOperation();
    }

    public boolean deleteAll() {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("DELETE FROM " + TBL_TEAM ));
                return true;
            }
        }).runOperation();
    }

}
