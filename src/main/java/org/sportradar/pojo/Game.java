package org.sportradar.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private SimpleDateFormat dFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private String homeTeam;
    private int hScore;
    private String awayTeam;
    private int aScore;
    private String startingDate;

    public Game(String homeTeam, String awayTeam) {
        log.debug("Game");
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.startingDate = dtf.format(now);
    }

    public int compareDateTo(Game g) throws ParseException {
        log.debug("compareTo");
        Date date1 = dFormatter.parse(this.getStartingDate());
        Date date2 = dFormatter.parse(g.getStartingDate());

        if (date1.after(date2)) {
            return 1;
        }
        return 2;
    }

    public String printGameResult() {
        log.debug("printGameResult");
        return this.homeTeam + ":" + this.hScore + "-" + this.awayTeam + ":" + this.aScore;

    }

    public String getHomeTeam() {
        log.debug("getHomeTeam");
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        log.debug("setHomeTeam");
        this.homeTeam = homeTeam;
    }

    public int gethScore() {
        log.debug("gethScore");
        return hScore;
    }

    public void sethScore(int hScore) {
        log.debug("sethScore");
        this.hScore = hScore;
    }

    public String getAwayTeam() {
        log.debug("getAwayTeam");
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        log.debug("setAwayTeam");
        this.awayTeam = awayTeam;
    }

    public int getaScore() {
        log.debug("getaScore");
        return aScore;
    }

    public void setaScore(int aScore) {
        log.debug("setaScore");
        this.aScore = aScore;
    }

    public String getStartingDate() {
        log.debug("getStartingDate");
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        log.debug("setStartingDate");
        this.startingDate = startingDate;
    }


}
