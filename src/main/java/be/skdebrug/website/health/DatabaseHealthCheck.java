package be.skdebrug.website.health;

import be.skdebrug.website.endpoint.SQLiteConnection;
import com.codahale.metrics.health.HealthCheck;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ben Oeyen on 5/10/2015.
 */
public class DatabaseHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        String resultString = (new SQLiteConnection<String>() {
            @Override
            public String defineOperation(Statement statement) throws SQLException {
                statement.executeQuery(log("SELECT *"));
                return "Connection successful";
            }
        }).runOperation();
        if (resultString != null) {
            return Result.healthy("Database available");
        } else {
            return Result.unhealthy("Database unavailable");
        }

    }
}
