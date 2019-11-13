package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class RectangleTest {
    
    /**
     *
     */
    public RectangleTest() {
    }

    /**
     * Test of move method, of class Rectangle.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 0.0;
        double dy = 0.0;
        Rectangle instance = null;
        instance.move(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInside method, of class Rectangle.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Point p = null;
        Rectangle instance = null;
        boolean expResult = false;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
