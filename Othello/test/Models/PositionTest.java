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
public class PositionTest {
    
    public PositionTest() {
    }

    /**
     * Test of getRow method, of class Position.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Position instance = null;
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumn method, of class Position.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Position instance = null;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Position.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Position instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Position.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Position instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Position.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Position instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNext() {
        System.out.println("next");
        Models.Direction direction = null;
        Position instance = null;
        Position expResult = null;
        Position result = instance.next(direction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Position.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Direction dir = null;
        Position instance = null;
        Position expResult = null;
        Position result = instance.move(dir);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
