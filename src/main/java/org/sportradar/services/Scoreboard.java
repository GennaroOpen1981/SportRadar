package org.sportradar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sportradar.pojo.Game;

import java.text.ParseException;
import java.util.*;


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

    public void finishGame(Game game) {
        log.debug("finishGame");
        scoreBoard.remove(game);

    }

    private static SortedSet<Game> sortByTotScore(
            final Map<Game, Integer> gameTotScoreMap) throws ParseException {
        TreeSet<Game> sortedGamess = new TreeSet<Game>(
                new Comparator<Game>() {
                    @Override
                    public int compare(Game game1, Game game2) {
                        try {
                            int compareByScore = gameTotScoreMap.get(game1).compareTo(
                                    gameTotScoreMap.get(game2));

                            if (compareByScore != 0) {
                                return compareByScore;
                            }
                            return game1.compareDateTo(game2);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });
        sortedGamess.addAll(gameTotScoreMap.keySet());
        return sortedGamess.descendingSet();
    }

    public SortedSet<Game> getSummaryOfGames() throws ParseException {
        log.debug("getSummaryOfGames");
        final Map<Game, Integer> m = new HashMap<Game, Integer>();
        Set<Game> sb = this.getScoreBoard();

        for (Game game : sb) {
            m.put(game, game.getTotScore());
        }
        return sortByTotScore(m);

    }
}
