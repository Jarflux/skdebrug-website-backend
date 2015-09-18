package be.skdebrug.website.core;

import org.joda.time.DateTime;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/2015
 */
public class News {
    private int id;
    private DateTime date;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }
}
