package org.sportradar.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sportradar.pojo.Game;

import java.text.ParseException;


public class GameTests {
    private static final Logger log = LoggerFactory.getLogger(GameTests.class);

    @Test
    public void testEqualsCompareGame() throws ParseException, InterruptedException {
        log.info("testEqualsCompareGame - check the most recently started game - the second started game is most recent");
        Game game1 = new Game("Mexico", "Canada");
        Thread.sleep(2 * 1000);
        Game game2 = new Game("Brasil", "Spain");
        log.info("testCompareGame Output, most recently started game is game n: " + game1.compareDateTo(game2) + "\n");
        Assert.assertEquals(2, game1.compareDateTo(game2));
    }

    @Test
    public void testNotEqualsCompareGame() throws ParseException, InterruptedException {
        log.info("testNotEqualsCompareGame - check the most recently started game - the second started game is most recent");
        Game game1 = new Game("Mexico", "Canada");
        Thread.sleep(2 * 1000);
        Game game2 = new Game("Brasil", "Spain");
        log.info("testCompareGame Output, most recently started game is game n: " + game1.compareDateTo(game2) + "\n");
        Assert.assertNotEquals(1, game1.compareDateTo(game2));
    }

    @Test
    public void testNotEqualsCalculateTotScore() throws ParseException, InterruptedException {
        log.info("testNotEqualsCalculateTotScore");
        Game game1 = new Game("Mexico", "Canada");
        game1.setaScore(1);
        game1.sethScore(4);
        game1.calculateTotScore();
        Assert.assertNotEquals(1, game1.getTotScore());
    }

    @Test
    public void testEqualsCalculateTotScore() throws ParseException, InterruptedException {
        log.info("testEqualsCalculateTotScore");
        Game game1 = new Game("Mexico", "Canada");
        game1.setaScore(1);
        game1.sethScore(4);
        game1.calculateTotScore();
        Assert.assertEquals(5, game1.getTotScore());
    }
}
