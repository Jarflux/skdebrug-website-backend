package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
import be.skdebrug.website.core.Settings;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.SettingsRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Inject;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class SettingsService {

    @Inject
    protected SettingsRepository settingsRepository;

    public Settings get() {
        return settingsRepository.get();
    }

    public boolean update(final Settings settings) {
        return settingsRepository.update(settings);
    }

}
