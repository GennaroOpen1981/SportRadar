package org.sportradar.test;

import org.junit.Assert;
import org.junit.Test;
import org.sportradar.pojo.Game;
import org.sportradar.services.Scoreboard;

import java.util.Set;

public class ScoreBoardTests {
    @Test
    public void testStartNewGame() {
        System.out.println("ScoreBoardTests test Assert 5 games");
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startNewGame("Mexico", "Canada");
        scoreboard.startNewGame("Brasil", "Spain");
        scoreboard.startNewGame("Germany", "France");
        scoreboard.startNewGame("Uruguay", "Italy");
        scoreboard.startNewGame("Argentina", "Australia");
        Set<Game> set = scoreboard.getScoreBoard();
        Assert.assertEquals(5, set.size());
    }


}
