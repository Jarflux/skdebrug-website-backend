package be.skdebrug.website.core;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/2015
 */
public class Standing implements Comparable<Standing>{

    private Season season;
    private Team team;
    private int wins;
    private int losses;
    private int ties;
    private int goalsFor;
    private int goalsAgainst;

    public int getPoints() {
        return wins*3 + ties;
    }

    public int getGames() {
        return wins + losses + ties;
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    //TODO Test Method
    @Override
    public int compareTo(Standing o) {
        if(this.getPoints() > o.getPoints()){
            return 1;
        }else if(this.getPoints() < o.getPoints()){
            return -1;
        }
        return 0;
    }

}
