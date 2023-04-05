package org.sportradar.test;

import org.junit.Assert;
import org.junit.Test;
import org.sportradar.pojo.Game;
import org.sportradar.services.Scoreboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class ScoreBoardTests {
    private static final Logger log = LoggerFactory.getLogger(ScoreBoardTests.class);

    @Test
    public void testEqualsStartNewGame() {
        log.info("testEqualsStartNewGame test Assert 5 games");
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startNewGame("Mexico", "Canada");
        scoreboard.startNewGame("Brasil", "Spain");
        scoreboard.startNewGame("Germany", "France");
        scoreboard.startNewGame("Uruguay", "Italy");
        scoreboard.startNewGame("Argentina", "Australia");
        Set<Game> set = scoreboard.getScoreBoard();
        Assert.assertEquals(5, set.size());
    }

    @Test
    public void testNotEqualsStartNewGame() {
        log.info("testNotEqualsStartNewGame test Assert 5 games not equals");
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startNewGame("Mexico", "Canada");
        scoreboard.startNewGame("Brasil", "Spain");
        scoreboard.startNewGame("Germany", "France");
        scoreboard.startNewGame("Uruguay", "Italy");
        scoreboard.startNewGame("Argentina", "Australia");
        Set<Game> set = scoreboard.getScoreBoard();
        Assert.assertNotEquals(6, set.size());
    }

    @Test
    public void testAreGamesEquals() {
        log.info("testAreGamesEquals");
        Scoreboard scoreboard = new Scoreboard();
        Game g1 = scoreboard.startNewGame("Mexico", "Canada");
        int res = scoreboard.areGamesEqual(g1, g1);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testUpdateScoreGame() {
        log.info("testUpdateScoreGame");
        Scoreboard scoreboard = new Scoreboard();
        Game g1 = scoreboard.startNewGame("Mexico", "Canada");
        scoreboard.updateScore(1, 2, g1);
        Set<Game> sg = scoreboard.getScoreBoard();

        for (Game game : sg) {
            System.out.println(game.getHomeTeam());
            System.out.println(game.gethScore());
            Assert.assertEquals(1, game.gethScore());
            System.out.println(game.getAwayTeam());
            Assert.assertEquals(2, game.getaScore());
            System.out.println(game.getaScore());
        }
    }

    @Test
    public void testFinishGame() {
        log.info("testFinishGame");
        Scoreboard scoreboard = new Scoreboard();
        Game g1 = scoreboard.startNewGame("Mexico", "Canada");
        Game g2 = scoreboard.startNewGame("Ireland", "Malta");
        scoreboard.finishGame(g1);
        Assert.assertEquals(1, scoreboard.getScoreBoard().size());
    }

    @Test
    public void testGetSummaryOfGames() {
        log.info("testGetSummaryOfGames");
        Scoreboard scoreboard = new Scoreboard();
        Game g0 = scoreboard.startNewGame("Spain", "France");
        g0.sethScore(13);
        g0.setaScore(13);
        g0.calculateTotScore();
        Game g1 = scoreboard.startNewGame("Mexico", "Canada");
        g1.sethScore(1);
        g1.setaScore(1);
        g1.calculateTotScore();
        Game g2 = scoreboard.startNewGame("Ireland", "Malta");
        g2.sethScore(3);
        g2.setaScore(4);
        g2.calculateTotScore();
        scoreboard.getSummaryOfGames();

    }

}
