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
 * Created by Ben on 24/05/15.
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
    public News read(@PathParam("newsId") String newsId) {
        LOG.debug("@GET /news/" + newsId + " read news with id " + newsId);
        return newsService.read(newsId);
    }

    @GET
    @Timed
    public List<News> readAll() {
        LOG.debug("@GET /news read all news");
        return newsService.readAll();
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
    @Path("/{wishlistId}")
    public void delete(@PathParam("newsId") String newsId) {
        LOG.debug("@DELETE /news/" + newsId + " read news with id " + newsId);
        newsService.delete(newsId);
    }

    @DELETE
    @Timed
    public void deleteAll() {
        LOG.debug("@DELETE /news/ delete all news");
        newsService.deleteAll();
    }

}
