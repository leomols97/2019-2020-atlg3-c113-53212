package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of initialize method, of class Game.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Game instance = new Game();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game g = new Game();
        Piece[][] expResult = new Piece[8][8];
        Piece[][] result = g.getBoard();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getCurrent method, of class Game.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        Game instance = new Game();
        Player expResult = null;
        Player result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePlayer method, of class Game.
     */
    @Test
    public void testChangePlayer() {
        System.out.println("changePlayer");
        Game instance = new Game();
        instance.changePlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canPlaceSmw method, of class Game.
     */
    @Test
    public void testCanPlaceSmw() {
        System.out.println("canPlaceSmw");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.canPlaceSmw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class Game.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Color color = null;
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getScore(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Position position = new Position(5, 7);
        Game game = new Game();
        game.initialize();
        game.play(position);
    }
    
}
