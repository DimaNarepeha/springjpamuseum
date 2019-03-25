//package ua.home.service;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//public class GameServiceImplTest {
//
//    private static GameService game;
//
//    @BeforeClass
//    public static void init() {
//        game = new GameService();
//    }
//    @Test
//    public void whenGameIsCheatedResultIsReturned() {
//        String guess = "100";
//        game.isGameWon(guess);
//        String result = game.getResult();
//        assertTrue("Is it just me being hypercritical or something is wrong???".equals(result));
//    }
//    @Test
//    public void whenGameIsWonResultIsReturned1() {
//        String guess = "1";
//
//        game.isGameWon(guess);
//        String result = game.getResult();
//        assertTrue("Impeccable!You won!".equals(result) || "Too bad...You lost!".equals(result));
//    }
//
//
//    @Test
//    public void whenGameIsWonResultIsReturned() {
//        String guess = "1";
//        game.isGameWon(guess);
//        String result = game.getResult();
//        assertTrue("Impeccable!You won!".equals(result) || "Too bad...You lost!".equals(result));
//    }
//
//
//}
