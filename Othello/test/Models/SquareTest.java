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
public class SquareTest {
    
    public SquareTest() {
    }

    /**
     * Test of getPiece method, of class Square.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Square instance = new Square();
        Piece expResult = null;
        Piece result = instance.getPiece();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class Square.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Piece piece = null;
        Square instance = new Square();
        instance.put(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFree method, of class Square.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Square instance = new Square();
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMyOwn method, of class Square.
     */
    @Test
    public void testIsMyOwn() {
        System.out.println("isMyOwn");
        Color color = null;
        Square instance = new Square();
        boolean expResult = false;
        boolean result = instance.isMyOwn(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Square.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Square instance = new Square();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Square.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Square instance = new Square();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Square.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Square instance = new Square();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
