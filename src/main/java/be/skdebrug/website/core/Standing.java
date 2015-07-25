package be.skdebrug.website.core;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/2015
 */
public class Standing implements Comparable<Standing> {

    private Team team;
    private int wins;
    private int losses;
    private int ties;
    private int goalsFor;
    private int goalsAgainst;

    public int getPoints() {
        return wins * 3 + ties;
    }

    public int getGames() {
        return wins + losses + ties;
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
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

    public void addWin() {
        this.wins++;
    }

    public void addLoss() {
        this.losses++;
    }

    public void addTie() {
        this.ties++;
    }

    public void addGolasFor(int goalsFor) {
        this.goalsFor += goalsFor;
    }

    public void addGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst += goalsAgainst;
    }

    //TODO Test Method
    public void addStatisticsFromGame(Game game) {
        if (this.getTeam().equals(game.getHomeTeam())) {
            addNumbersBasedOnResult(game.getHomeScore(), game.getAwayScore());
        } else {
            addNumbersBasedOnResult(game.getAwayScore(), game.getHomeScore());
        }
    }

    //TODO Test Method
    private void addNumbersBasedOnResult(int goalsFor, int goalsAgainst) {
        addGolasFor(goalsFor);
        addGoalsAgainst(goalsAgainst);
        if (goalsFor > goalsAgainst) {
            addWin();
        } else if (goalsFor < goalsAgainst) {
            addLoss();
        } else {
            addTie();
        }
    }

    //TODO Test Method
    @Override
    public int compareTo(Standing o) {
        return comparePoints(o) != 0 ? comparePoints(o) :
                compareWins(o) != 0 ? compareWins(o) :
                        compareTies(o) != 0 ? compareTies(o) :
                                compareGoalDifference(o) != 0 ? compareGoalDifference(o) :
                                        compareGoalFor(o) != 0 ? compareGoalFor(o) : 0;
    }

    private int comparePoints(Standing o) {
        if (this.getPoints() > o.getPoints()) {
            return -1;
        } else if (this.getPoints() < o.getPoints()) {
            return 1;
        }
        return 0;
    }

    private int compareWins(Standing o) {
        if (this.getWins() > o.getWins()) {
            return -1;
        } else if (this.getWins() < o.getWins()) {
            return 1;
        }
        return 0;
    }


    private int compareTies(Standing o) {
        if (this.getTies() > o.getTies()) {
            return -1;
        } else if (this.getTies() < o.getTies()) {
            return 1;
        }
        return 0;
    }

    private int compareGoalDifference(Standing o) {
        if (this.getGoalDifference() > o.getGoalDifference()) {
            return -1;
        } else if (this.getGoalDifference() < o.getGoalDifference()) {
            return 1;
        }
        return 0;
    }

    private int compareGoalFor(Standing o) {
        if (this.getGoalsFor() > o.getGoalsFor()) {
            return -1;
        } else if (this.getGoalsFor() < o.getGoalsFor()) {
            return 1;
        }
        return 0;
    }

}
