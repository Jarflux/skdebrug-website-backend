package be.skdebrug.website.repository;

import be.skdebrug.website.core.News;
import be.skdebrug.website.endpoint.SQLiteConnection;
import org.joda.time.DateTime;
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
        newsBefore.setDate(new DateTime());
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getDate()).isEqualTo(newsBefore.getDate());
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
    }

    @Test
    public void testGetSpecificandDelete(){
        News newsBefore = new News();
        newsBefore.setTitle("Lovely Title");
        newsBefore.setContent("I love this content");
        newsBefore.setDate(new DateTime());
        newsRepository.create(newsBefore);
        newsBefore = newsRepository.getAll().get(0);
        int newsId = newsBefore.getId();
        News newsAfter = newsRepository.get(newsId);
        assertThat(newsAfter.getId()).isEqualTo(newsBefore.getId());
        assertThat(newsAfter.getDate()).isEqualTo(newsBefore.getDate());
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
        newsRepository.delete(newsId);
        assertThat(newsRepository.getAll().size()).isEqualTo(0);
    }

    @Test
    public void testInsertWithSingleQuote(){
        News newsBefore = new News();
        newsBefore.setDate(new DateTime());
        newsBefore.setTitle("De Bruyne en Casteels ' helden in Duitse Supercup");
        newsBefore.setContent("Wolfsburg z'on 30 miljoen euro");
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getDate()).isEqualTo(newsBefore.getDate());
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
    }

    @Test
    public void testGetSpecificandUpdate(){
        News newsBefore = new News();
        newsBefore.setDate(new DateTime());
        newsBefore.setTitle("I love this title");
        newsBefore.setContent("I love this content");
        newsRepository.create(newsBefore);
        News newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isNotNull();
        assertThat(newsAfter.getDate()).isEqualTo(newsBefore.getDate());
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());

        newsBefore = newsRepository.getAll().get(0);
        newsBefore.setDate(new DateTime());
        newsBefore.setTitle("new title");
        newsBefore.setContent("new content");
        newsRepository.update(newsBefore);
        assertThat(newsRepository.getAll().size()).isEqualTo(1);
        newsAfter = newsRepository.getAll().get(0);
        assertThat(newsAfter.getId()).isEqualTo(newsBefore.getId());
        assertThat(newsAfter.getDate()).isEqualTo(newsBefore.getDate());
        assertThat(newsAfter.getTitle()).isEqualTo(newsBefore.getTitle());
        assertThat(newsAfter.getContent()).isEqualTo(newsBefore.getContent());
    }

    @Test
    public void testCreatetMultipleCheckCronologicalOrder(){
        News newsBefore1 = new News();
        newsBefore1.setDate(new DateTime());
        newsBefore1.setTitle("First");
        newsBefore1.setContent("First content");
        newsRepository.create(newsBefore1);

        News newsBefore2 = new News();
        newsBefore2.setDate((new DateTime()).plusDays(1));
        newsBefore2.setTitle("Second");
        newsBefore2.setContent("Second content");
        newsRepository.create(newsBefore2);
        assertThat(newsRepository.getAll().size()).isEqualTo(2);

        News newsAfter1 = newsRepository.getAll().get(0);
        assertThat(newsAfter1.getDate()).isEqualTo(newsBefore2.getDate());
        assertThat(newsAfter1.getTitle()).isEqualTo(newsBefore2.getTitle());
        assertThat(newsAfter1.getContent()).isEqualTo(newsBefore2.getContent());

        News newsAfter2 = newsRepository.getAll().get(1);
        assertThat(newsAfter2.getDate()).isEqualTo(newsBefore1.getDate());
        assertThat(newsAfter2.getTitle()).isEqualTo(newsBefore1.getTitle());
        assertThat(newsAfter2.getContent()).isEqualTo(newsBefore1.getContent());
    }

    @Test
    public void testCreatetMultipleAndDeleteAll(){
        News newsBefore = new News();
        newsBefore.setDate(new DateTime());
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

