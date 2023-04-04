package org.sportradar.services;

import org.sportradar.pojo.Game;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Scoreboard {

    Set<Game> scoreBoard = new TreeSet<>(new Comparator<Game>() {
        @Override
        public int compare(Game g1, Game g2) {
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

    public void startNewGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        game.sethScore(0);
        game.setaScore(0);
        scoreBoard.add(game);
    }

    void updateScore() {
    }

    void finishGame() {
    }

    void getSummaryOfGames() {
    }
}
