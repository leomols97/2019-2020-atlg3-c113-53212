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
public class BoardTest {

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInsideTRUE11() {
        System.out.println("isInsideTRUE11");
        Position pos = new Position(1, 1);
        Board b = new Board();
        boolean result = b.isInside(pos);
        assertTrue(result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInsideTRUE88() {
        System.out.println("isInsideTRUE88");
        Position pos = new Position(7, 7);
        Board b = new Board();
        boolean result = b.isInside(pos);
        assertTrue(result);
    }
    
    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInsideFALSE00() {
        System.out.println("isInsideFALSE00");
        Position pos = new Position(0, 0);
        Board b = new Board();
        boolean result = b.isInside(pos);
        assertFalse(result);
    }
    
    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInsideFALSE99() {
        System.out.println("isInsideFALSE99");
        Position pos = new Position(9, 9);
        Board b = new Board();
        boolean result = b.isInside(pos);
        assertFalse(result);
    }

    /**
     * Test of isFree method, of class Board.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsFreeEXCEPTION() {
        System.out.println("isFreeEXCEPTION");
        Position pos = new Position(0, 0);
        Board instance = new Board();
        instance.isFree(pos);
    }

    /**
     * Test of getPiece method, of class Board.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Position pos = null;
        Board instance = new Board();
        Piece expResult = null;
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class Board.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Board instance = new Board();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class Board.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Board instance = new Board();
        Piece[][] expResult = null;
        Piece[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPiece method, of class Board.
     */
    @Test
    public void testAddPiece() {
        System.out.println("addPiece");
        Player player = null;
        Position pos = null;
        Board instance = new Board();
        instance.addPiece(player, pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFree method, of class Board.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Position pos = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Position pos = null;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
