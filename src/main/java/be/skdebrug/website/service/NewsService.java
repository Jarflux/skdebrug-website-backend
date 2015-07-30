package be.skdebrug.website.service;

import be.skdebrug.website.core.News;
import be.skdebrug.website.repository.NewsRepository;
import com.google.inject.Inject;

import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 24/05/2015
 */
public class NewsService {

    @Inject
    NewsRepository newsRepository;

    public boolean create(final News news) {
        return newsRepository.create(news);
    }

    public News get(final int newsId) {
        return newsRepository.get(newsId);
    }

    public List<News> getAll() {
        return newsRepository.getAll();
    }

    public boolean update(final News news) {
        return newsRepository.update(news);
    }

    public boolean delete(final int newsId) {
        return newsRepository.delete(newsId);
    }

    public boolean deleteAll() {
        return newsRepository.deleteAll();
    }
}
