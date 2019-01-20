package be.skdebrug.website.repository;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
import be.skdebrug.website.core.Settings;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Developer: Ben Oeyen
 * Date: 16/01/2019
 */
public class SettingsRepositoryTest {

    private SettingsRepository settingsRepository;


    @Before
    public void before() {
        SQLiteConnection.databaseLocation = "test.db";
        SettingsRepository.dropDatabaseOnInjection = true;
        settingsRepository = new SettingsRepository();
    }

    @Test
    public void testCreateEmptyObjectonStartup() {
        Settings settings = settingsRepository.get();
        assertThat(settings.getQuizDate().getMillis()).isEqualTo(0);
        assertThat(settings.getQuizEdition()).isEqualTo(0);
    }

    @Test
    public void testUpdate() {
        Settings OldSettings = new Settings();
        OldSettings.setDate(new DateTime(123456789));
        OldSettings.setQuizEdition(25);
        settingsRepository.update(OldSettings);

        Settings newSettings = settingsRepository.get();
        assertThat(newSettings.getQuizDate().getMillis()).isEqualTo(123456789);
        assertThat(newSettings.getQuizEdition()).isEqualTo(25);
    }
}