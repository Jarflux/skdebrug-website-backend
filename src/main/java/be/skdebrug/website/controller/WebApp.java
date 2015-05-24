package be.skdebrug.website.controller;

import be.skdebrug.website.health.DatabaseHealthCheck;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.log4j.Logger;

/**
 * Created by Ben on 24/05/15.
 */
public class WebApp extends Application<Configuration> {
    private final static Logger LOG = Logger.getLogger(WebApp.class);

    public static void main(String[] args) throws Exception {
        new WebApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        Injector injector = Guice.createInjector();

        final NewsController newsController = injector.getInstance(NewsController.class);

        environment.healthChecks().register("Database Availability", new DatabaseHealthCheck());
        environment.jersey().register(newsController);
    }
}

