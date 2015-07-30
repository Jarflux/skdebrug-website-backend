package be.skdebrug.website.controller;

import be.skdebrug.website.core.News;
import be.skdebrug.website.service.NewsService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 24/05/2015
 */
@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
public class NewsController {
    private final static Logger LOG = Logger.getLogger(NewsController.class);

    @Inject
    private NewsService newsService;

    @GET
    @Timed
    @Path("/{newsId}")
    public News get(@PathParam("newsId") int newsId) {
        LOG.debug("@GET /news/" + newsId + " get news with id " + newsId);
        return newsService.get(newsId);
    }

    @GET
    @Timed
    public List<News> getAll() {
        LOG.debug("@GET /news get all news");
        return newsService.getAll();
    }

    @PUT
    @Timed
    public void update(News news) {
        LOG.debug("@PUT /news create news");
        newsService.create(news);
    }

    @POST
    @Timed
    public void create(News news) {
        LOG.debug("@POST /news update news");
        newsService.create(news);
    }

    @DELETE
    @Timed
    @Path("/{newsId}")
    public void delete(@PathParam("newsId") int newsId) {
        LOG.debug("@DELETE /news/" + newsId + " get news with id " + newsId);
        newsService.delete(newsId);
    }

    @DELETE
    @Timed
    public void deleteAll() {
        LOG.debug("@DELETE /news/ delete all news");
        newsService.deleteAll();
    }

}
