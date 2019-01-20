package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.Settings;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.SettingsRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Developer: Ben Oeyen
 * Date: 16/01/2019
 */
public class SettingsServiceTest {

    private SettingsService settingsService;

    private Settings settings;

    @Before
    public void before(){
        settingsService = new SettingsService();

        settings = new Settings();
        settings.setDate(new DateTime(123456789));
        settings.setQuizEdition(123);

        SettingsRepository settingsRepositoryMock = mock(SettingsRepository.class);
        when(settingsRepositoryMock.get()).thenReturn(settings);
        when(settingsRepositoryMock.update(settings)).thenReturn(true);

        settingsService.settingsRepository = settingsRepositoryMock;
    }

    @Test
    public void getSettings(){
        assertThat(settingsService.get()).isEqualTo(settings);
    }

    @Test
    public void updateSettings(){
        settingsService.update(settings);
        verify(settingsService.settingsRepository, times(1)).update(settings);
    }
}