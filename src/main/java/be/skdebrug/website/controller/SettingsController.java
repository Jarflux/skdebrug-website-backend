package be.skdebrug.website.controller;

import be.skdebrug.website.core.Settings;
import be.skdebrug.website.service.SettingsService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class SettingsController {

    private final static Logger LOG = Logger.getLogger(SettingsController.class);

    @Inject
    protected SettingsService settingsService;

    @GET
    @Timed
    @Path("settings")
    public Settings get() {
        LOG.debug("@GET /settings" );
        return settingsService.get();
    }

    @PUT
    @Timed
    @Path("private/game")
    public void update(Settings settings) {
        LOG.debug("@PUT /settings update settings");
        settingsService.update(settings);
    }

}