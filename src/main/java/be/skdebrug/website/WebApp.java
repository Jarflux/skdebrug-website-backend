package be.skdebrug.website;

import be.skdebrug.website.controller.NewsController;
import be.skdebrug.website.health.DatabaseHealthCheck;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Created by Ben Oeyen on 6/13/2015.
 */
public class WebApp extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new WebApp().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        //Register HealthChecks
        environment.healthChecks().register("database", new DatabaseHealthCheck());

        //Dependency Injection
        Injector injector = Guice.createInjector();
        final NewsController newsController = injector.getInstance(NewsController.class);

        //Register REST Controllers
        environment.jersey().register(newsController);
    }
}
