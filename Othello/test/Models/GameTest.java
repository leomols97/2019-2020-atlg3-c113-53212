/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        Game instance = new Game();
        Square[][] expResult = null;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class Game.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        int row = 0;
        int column = 0;
        Game instance = new Game();
        instance.select(row, column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelected method, of class Game.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        Game instance = new Game();
        Piece expResult = null;
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of put method, of class Game.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Position pos = null;
        Game instance = new Game();
        instance.put(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSquare method, of class Game.
     */
    @Test
    public void testGetSquare() {
        System.out.println("getSquare");
        Position pos = null;
        Game instance = new Game();
        Square expResult = null;
        Square result = instance.getSquare(pos);
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
     * Test of legalPlace method, of class Game.
     */
    @Test
    public void testLegalPlace() {
        System.out.println("legalPlace");
        Position pos = null;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.legalPlace(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canPlace method, of class Game.
     */
    @Test
    public void testCanPlace() {
        System.out.println("canPlace");
        Position pos = null;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.canPlace(pos);
        assertEquals(expResult, result);
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
     * Test of getScoreWhite method, of class Game.
     */
    @Test
    public void testGetScoreWhite() {
        System.out.println("getScoreWhite");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getScoreWhite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreBlack method, of class Game.
     */
    @Test
    public void testGetScoreBlack() {
        System.out.println("getScoreBlack");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getScoreBlack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of place method, of class Game.
     */
    @Test
    public void testPlace() {
        System.out.println("place");
        Position pos = null;
        Game instance = new Game();
        instance.place(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
