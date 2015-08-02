package be.skdebrug.website.repository;

import be.skdebrug.website.core.News;
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

    private NewsRepository newsRepository;

    @Before
    public void before() {
        SQLiteConnection.databaseLocation = "test.db";
        NewsRepository.dropDatabaseOnInjection = true;
        newsRepository = new NewsRepository();
    }

    @Test
    public void testCreateAndGet(){
        News newsBefore = new News();
        newsBefore.setContent("I love this content");
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
    }

    @Test
    public void testGetSpecificandDelete(){
        News newsBefore = new News();
        newsBefore.setContent("I love this content");
        newsRepository.create(newsBefore);
        newsBefore = newsRepository.getAll().get(0);
        int newsId = newsBefore.getId();
        News newsAfter = newsRepository.get(newsId);
        assertThat(newsAfter.getId()).isEqualTo(newsBefore.getId());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
        newsRepository.delete(newsId);
        assertThat(newsRepository.getAll().size()).isEqualTo(0);
    }


}

