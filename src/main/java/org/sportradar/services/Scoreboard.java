package org.sportradar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sportradar.pojo.Game;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Scoreboard {
    private static final Logger log = LoggerFactory.getLogger(Scoreboard.class);

    Set<Game> scoreBoard = new TreeSet<>(new Comparator<Game>() {
        @Override
        public int compare(Game g1, Game g2) {
            log.debug("compare");
            return areGamesEqual(g1,g2);
        }
    });

    public Set<Game> getScoreBoard() {
        return scoreBoard;
    }

    public Game startNewGame(String homeTeam, String awayTeam) {
        log.debug("startNewGame");
        Game game = new Game(homeTeam, awayTeam);
        game.sethScore(0);
        game.setaScore(0);
        scoreBoard.add(game);
        return game;
    }

    public void updateScore(int hScore, int aScore, Game game) {
        log.debug("updateScore");
        game.sethScore(hScore);
        game.setaScore(aScore);
    }

    public int areGamesEqual(Game g1, Game g2) {
        int result = -1;
        if (g1.getHomeTeam().equals(g2.getHomeTeam()) && g1.getAwayTeam().equals(g2.getAwayTeam()) && g1.getStartingDate().equals(g2.getStartingDate())) {
            result = 1;
        }
        return result;
    }

    public void finishGame(Game game) {
        log.debug("finishGame");
        scoreBoard.remove(game);

    }

    void getSummaryOfGames() {
        log.debug("getSummaryOfGames");
    }
}
