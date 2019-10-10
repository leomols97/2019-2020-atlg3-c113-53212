package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class DrawingTest {
    
    /**
     *
     */
    public DrawingTest() {
    }

    /**
     * Test of addShape method, of class Drawing.
     */
    @Test
    public void testAddShape() {
        System.out.println("addShape");
        Shape shape = null;
        Drawing instance = new Drawing();
        instance.addShape(shape);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeAt() {
        System.out.println("getShapeAt");
        Point p = null;
        Drawing instance = new Drawing();
        Shape expResult = null;
        Shape result = instance.getShapeAt(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Drawing.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Drawing instance = new Drawing();
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Drawing.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Drawing instance = new Drawing();
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
