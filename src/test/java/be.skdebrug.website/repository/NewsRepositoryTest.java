package be.skdebrug.website.repository;

import be.skdebrug.website.endpoint.SQLiteConnection;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/2015
 */

public class NewsRepositoryTest {

    NewsRepository newsRepository;

    @Before
    public void before() {
        SQLiteConnection.databaseLocation = "test.db";
        NewsRepository.dropDatabaseOnInjection = true;
        newsRepository = new NewsRepository();
    }


}

