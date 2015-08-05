package be.skdebrug.website.endpoint;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Developer: Ben Oeyen
 * Date: 24/05/2015
 */
public abstract class SQLiteConnection<RESULT> {

    private final static Logger LOG = Logger.getLogger(SQLiteConnection.class);
    public static String databaseLocation = "skdebrug.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage());
        }
    }

    public RESULT runOperation() {
        // create a database connection
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation)) {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(1);  // set timeout to 1 sec.
            RESULT result = defineOperation(statement);
            return result;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    public abstract RESULT defineOperation(Statement statement) throws SQLException;

    public String log(String query) {
        LOG.debug("Executing Query - " + query);
        return query;
    }

}
