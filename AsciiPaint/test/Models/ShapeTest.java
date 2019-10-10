package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ShapeTest {
    
    /**
     *
     */
    public ShapeTest() {
    }

    /**
     * Test of move method, of class Shape.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 0.0;
        double dy = 0.0;
        Shape instance = new ShapeImpl();
        instance.move(dx, dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInside method, of class Shape.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Point p = null;
        Shape instance = new ShapeImpl();
        boolean expResult = false;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Shape.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Shape instance = new ShapeImpl();
        char expResult = ' ';
        char result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *
     */
    public class ShapeImpl implements Shape {

        /**
         *
         * @param dx
         * @param dy
         */
        public void move(double dx, double dy) {
        }

        /**
         *
         * @param p
         * @return
         */
        public boolean isInside(Point p) {
            return false;
        }

        /**
         *
         * @return
         */
        public char getColor() {
            return ' ';
        }
    }
    
}
