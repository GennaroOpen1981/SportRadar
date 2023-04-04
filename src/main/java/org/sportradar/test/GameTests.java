package org.sportradar.test;

import org.junit.Test;
import org.sportradar.pojo.Game;

import java.text.ParseException;


public class GameTests {
    @Test
    public void testCompareGame() throws ParseException, InterruptedException {
        System.out.println("testCompareGame - check the most recently started game");
        Game game1 = new Game("Mexico", "Canada");
        Thread.sleep(2 * 1000);
        Game game2 = new Game("Brasil", "Spain");
        System.out.println("testCompareGame Output, most recently started game is game n: " + game1.compareTo(game2) + "\n");

    }
}
