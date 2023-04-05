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


}
