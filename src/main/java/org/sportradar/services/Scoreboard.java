package org.sportradar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sportradar.pojo.Game;

import java.util.HashSet;
import java.util.Set;


public class Scoreboard {
    private static final Logger log = LoggerFactory.getLogger(Scoreboard.class);

    Set<Game> scoreBoard = new HashSet<>();

    public Set<Game> getScoreBoard() {
        return scoreBoard;
    }

    public Game startNewGame(String homeTeam, String awayTeam) {
        log.debug("startNewGame");
        Game game = new Game(homeTeam, awayTeam);
        game.sethScore(0);
        game.setaScore(0);
        game.calculateTotScore();
        scoreBoard.add(game);
        return game;
    }

    public void updateScore(int hScore, int aScore, Game game) {
        log.debug("updateScore");
        game.sethScore(hScore);
        game.setaScore(aScore);
        game.calculateTotScore();
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
