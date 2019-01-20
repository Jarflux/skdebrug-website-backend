package be.skdebrug.website.core;

import org.joda.time.DateTime;

import java.util.Comparator;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/2015
 */
public class Settings {

    private DateTime quizDate;
    private Integer quizEdition;

    public Settings() {
    }

    public DateTime getQuizDate() {
        return quizDate;
    }

    public void setDate(DateTime quizDate) {
        this.quizDate = quizDate;
    }

    public Integer getQuizEdition() {
        return quizEdition;
    }

    public void setQuizEdition(int quizEdition) {
        this.quizEdition = quizEdition;
    }


}
