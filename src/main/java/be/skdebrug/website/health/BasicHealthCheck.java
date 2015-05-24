package be.skdebrug.website.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Ben Oeyen on 5/10/2015.
 */
public class BasicHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy("REST API is healthy, smooth sailing ahead.");
    }
}
