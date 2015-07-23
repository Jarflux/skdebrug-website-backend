package be.skdebrug.website.core;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
public class League {
    private int id;
    private int year;
    private DateTime startDate;
    private DateTime endDate;
    private List<Standing> standings = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setYear(int year) {
        if(year > 2015 && year < 2100 ) {
            this.year = year;
            startDate = new DateTime().withDate(year,8,1);
            endDate = new DateTime().withDate(year+1,7,1);
        }
    }

    public int getYear() {
        return year;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void clear (){
        standings = new ArrayList<>();
    }

    public void add(Standing standing){
        standings.add(standing);
    }

    //TODO Test Method
    public void sort(){
        Collections.sort(standings);
    }
}
