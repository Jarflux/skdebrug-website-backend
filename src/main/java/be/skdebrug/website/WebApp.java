package be.skdebrug.website;

import be.skdebrug.website.controller.*;
import be.skdebrug.website.health.DatabaseHealthCheck;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Developer: Ben Oeyen
 * Date: 24/05/2015
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
        final ReservationController reservationController = injector.getInstance(ReservationController.class);
        final PlayerController playerController = injector.getInstance(PlayerController.class);
        final TeamController teamController = injector.getInstance(TeamController.class);
        final GameController gameController = injector.getInstance(GameController.class);
        final LeagueController leagueController = injector.getInstance(LeagueController.class);
        final DevController devController = injector.getInstance(DevController.class);

        //Register REST Controllers
        environment.jersey().register(newsController);
        environment.jersey().register(reservationController);
        environment.jersey().register(playerController);
        environment.jersey().register(teamController);
        environment.jersey().register(gameController);
        environment.jersey().register(leagueController);
        environment.jersey().register(devController);
    }
}
