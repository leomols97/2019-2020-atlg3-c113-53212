package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class PieceTest {
    
    public PieceTest() {
    }

    /**
     * Test of getColor method, of class Piece.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Piece instance = null;
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invert method, of class Piece.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        Piece instance = null;
        instance.invert();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Piece.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = null;
        Piece instance = null;
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMyOwn method, of class Piece.
     */
    @Test
    public void testIsMyOwn() {
        System.out.println("isMyOwn");
        Color color = null;
        Piece instance = null;
        boolean expResult = false;
        boolean result = instance.isMyOwn(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
