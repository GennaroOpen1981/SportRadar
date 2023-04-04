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
    public void testCompareGame() throws ParseException, InterruptedException {
        log.info("testCompareGame - check the most recently started game");
        Game game1 = new Game("Mexico", "Canada");
        Thread.sleep(2 * 1000);
        Game game2 = new Game("Brasil", "Spain");
        log.info("testCompareGame Output, most recently started game is game n: " + game1.compareTo(game2) + "\n");
        Assert.assertEquals(2, game1.compareTo(game2));
    }
}
