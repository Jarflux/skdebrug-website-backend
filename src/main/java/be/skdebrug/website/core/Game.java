package be.skdebrug.website.core;

import org.joda.time.DateTime;

import java.util.Comparator;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/2015
 */
public class Game{

    private int id;
    private GameType gameType;
    private DateTime date;
    private Team homeTeam;
    private Team awayTeam;
    private Integer homeScore;
    private Integer awayScore;

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public static class DateComperator implements Comparator<Game> {
        @Override
        public int compare(Game o1, Game o2) {
            if(o1.getDate().isBefore(o2.getDate())){
                return -1;
            }else if(o1.getDate().isAfter(o2.getDate())){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
