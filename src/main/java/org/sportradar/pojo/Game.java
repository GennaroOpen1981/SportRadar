package org.sportradar.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Game {
    private SimpleDateFormat dFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private String homeTeam;
    private int hScore;
    private String awayTeam;
    private int aScore;
    private String startingDate;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.startingDate = dtf.format(now);
    }

    public int compareTo(Game g) throws ParseException {

        Date date1 = dFormatter.parse(this.getStartingDate());
        Date date2 = dFormatter.parse(g.getStartingDate());

        if (date1.after(date2)) {
            return 1;
        }
        return 2;
    }

    public String printGameResult() {
        return this.homeTeam + ":" + this.hScore + "-" + this.awayTeam + ":" + this.aScore;

    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int gethScore() {
        return hScore;
    }

    public void sethScore(int hScore) {
        this.hScore = hScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getaScore() {
        return aScore;
    }

    public void setaScore(int aScore) {
        this.aScore = aScore;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }


}
