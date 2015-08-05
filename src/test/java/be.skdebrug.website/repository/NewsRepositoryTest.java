package be.skdebrug.website.repository;

import be.skdebrug.website.core.News;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.junit.Before;
import org.junit.Ignore;
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
        newsBefore.setTitle("Lovely Title");
        newsBefore.setContent("I love this content");
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
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
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
        newsRepository.delete(newsId);
        assertThat(newsRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testInsertWithSingleQuote(){
        News newsBefore = new News();
        newsBefore.setTitle("De Bruyne en Casteels ' helden in Duitse Supercup");
        newsBefore.setContent("Wolfsburg z'on 30 miljoen euro");
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
    }

    @Test
    public void testGetSpecificandUpdate(){
        News newsBefore = new News();
        newsBefore.setTitle("I love this title");
        newsBefore.setContent("I love this content");
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
        newsBefore.setTitle("new title");
        newsBefore.setContent("new content");
        newsRepository.update(newsBefore);
        newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isEqualTo(newsBefore.getId());
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
    }

    @Test
    public void testCreatetMultipleAndDeleteAll(){
        News newsBefore = new News();
        newsBefore.setTitle("I love this title");
        newsBefore.setContent("I love this content");
        newsRepository.create(newsBefore);
        newsRepository.create(newsBefore);
        assertThat(newsRepository.getAll().size()).isEqualTo(2);
        newsRepository.deleteAll();
        assertThat(newsRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testGetNewsWithUnexistingId(){
        assertThat(newsRepository.get(10000)).isEqualTo(null);
    }
}

