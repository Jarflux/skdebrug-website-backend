package be.skdebrug.website.service;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.News;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.repository.GameRepository;
import be.skdebrug.website.repository.NewsRepository;
import be.skdebrug.website.repository.TeamRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Developer: Ben Oeyen
 * Date: 07/08/15
 */
public class NewsServiceTest {

    private NewsService newsService;

    private News news;
    private List<News> newsList = new ArrayList<>();

    @Before
    public void before(){
        Injector injector = Guice.createInjector();
        newsService = new NewsService();
        injector.injectMembers(newsService);
        news = mock(News.class);
        newsList.add(news);
        newsList.add(news);

        NewsRepository newsRepositoryMock = mock(NewsRepository.class);
        when(newsRepositoryMock.get(anyInt())).thenReturn(news);
        when(newsRepositoryMock.getAll()).thenReturn(newsList);
        newsService.newsRepository = newsRepositoryMock;
    }

    @Test
    public void getNewsById(){
        assertThat(newsService.get(1)).isEqualTo(news);
    }

    @Test
    public void getAllNews(){
        assertThat(newsService.getAll()).isEqualTo(newsList);
        assertThat(newsService.getAll().size()).isEqualTo(2);
        assertThat(newsService.getAll().get(0)).isEqualTo(news);
        assertThat(newsService.getAll().get(1)).isEqualTo(news);
    }

    @Test
    public void deleteAllNews(){
        newsService.deleteAll();
        verify(newsService.newsRepository, times(1)).deleteAll();
    }

    @Test
    public void deleteNewsById(){
        newsService.delete(1);
        verify(newsService.newsRepository, times(1)).delete(1);
    }

    @Test
    public void updateNews(){
        newsService.update(news);
        verify(newsService.newsRepository, times(1)).update(news);
    }

    @Test
    public void createNews(){
        newsService.create(news);
        verify(newsService.newsRepository, times(1)).create(news);
    }
}
