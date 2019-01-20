package be.skdebrug.website.repository;

import be.skdebrug.website.core.Settings;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class SettingsRepository extends AbstractRepository {

    private static final String TBL_SETTINGS = "tbl_settings";
    private static final String COL_ID = "id";
    private static final String COL_QUIZ_DATE = "quizDate";
    private static final String COL_QUIZ_EDITION = "quizEdition";

    private static final int FIXED_ID = 1;

    private Settings parseSettingsFromResult(ResultSet queryResult) throws SQLException {
        Settings settings = new Settings();
        settings.setQuizEdition(queryResult.getInt(COL_QUIZ_EDITION));
        settings.setDate(new DateTime(queryResult.getLong(COL_QUIZ_DATE)));
        return settings;
    }

    public SettingsRepository() {
        if (dropDatabaseOnInjection) {
            (new SQLiteConnection<Boolean>() {
                @Override
                public Boolean defineOperation(Statement statement) throws SQLException {
                    statement.execute(log("DROP TABLE IF EXISTS " + TBL_SETTINGS));
                    return true;
                }
            }).runOperation();
        }
        (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.execute(log("CREATE TABLE IF NOT EXISTS " + TBL_SETTINGS + " (" + COL_ID + " INTEGER PRIMARY KEY ASC,"
                        + COL_QUIZ_DATE + ","
                        + COL_QUIZ_EDITION + ","
                        + "CONSTRAINT unique_" + TBL_SETTINGS + " UNIQUE(" + COL_ID + ") ON CONFLICT IGNORE );"));
                return true;
            }
        }).runOperation();
        if(get() == null){
            create();
        }
    }

    private boolean create() {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("INSERT INTO " + TBL_SETTINGS + " ("
                        + COL_QUIZ_DATE + ","
                        + COL_QUIZ_EDITION
                        + ") VALUES ("
                        + "null,"
                        + "null);"));
                return true;
            }
        }).runOperation();
    }

    public Settings get() {
        return (new SQLiteConnection<Settings>() {
            @Override
            public Settings defineOperation(Statement statement) throws SQLException {
                ResultSet queryResult = statement.executeQuery(log("SELECT * FROM " + TBL_SETTINGS + " WHERE " + COL_ID + " = '" + FIXED_ID + "'"));
                if (queryResult.next()) {
                    return parseSettingsFromResult(queryResult);
                }
                return null;
            }
        }).runOperation();
    }

    public boolean update(final Settings settings) {
        return (new SQLiteConnection<Boolean>() {
            @Override
            public Boolean defineOperation(Statement statement) throws SQLException {
                statement.executeUpdate(log("UPDATE " + TBL_SETTINGS
                        + " SET "
                        + COL_QUIZ_DATE + " = '" + settings.getQuizDate().getMillis() + "', "
                        + COL_QUIZ_EDITION + " = '" + settings.getQuizEdition() + "' "
                        + "WHERE " + COL_ID + " = '" + FIXED_ID + "' "));
                return true;
            }
        }).runOperation();
    }

}
