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
            try {
                return g1.compareTo(g2);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
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

    void finishGame() {
        log.debug("finishGame");
    }

    void getSummaryOfGames() {
        log.debug("getSummaryOfGames");
    }
}
