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
    
    public BoardTest() {
    }

    /**
     * Test of getSquares method, of class Board.
     */
    @Test
    public void testGetSquares() {
        System.out.println("getSquares");
        Board instance = new Board();
        Square[][] expResult = null;
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
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

    /**
     * Test of getSquare method, of class Board.
     */
    @Test
    public void testGetSquare() {
        System.out.println("getSquare");
        Position pos = null;
        Board instance = new Board();
        Square expResult = null;
        Square result = instance.getSquare(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class Board.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Piece piece = null;
        Position pos = null;
        Board instance = new Board();
        instance.put(piece, pos);
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
     * Test of getNumberOwnPieces method, of class Board.
     */
    @Test
    public void testGetNumberOwnPieces() {
        System.out.println("getNumberOwnPieces");
        Player player = null;
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getNumberOwnPieces(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
