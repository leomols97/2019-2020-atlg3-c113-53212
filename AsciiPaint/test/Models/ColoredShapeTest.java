package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ColoredShapeTest {
    
    /**
     *
     */
    public ColoredShapeTest() {
    }

    /**
     * Test of getColor method, of class ColoredShape.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        ColoredShape instance = null;
        char expResult = ' ';
        char result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class ColoredShape.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        char color = ' ';
        ColoredShape instance = null;
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *
     */
    public class ColoredShapeImpl extends ColoredShape {

        /**
         *
         */
        public ColoredShapeImpl() {
            super(' ');
        }

        /**
         *
         * @param dx
         * @param dy
         */
        @Override
        public void move(double dx, double dy) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        /**
         *
         * @param p
         * @return
         */
        @Override
        public boolean isInside(Point p) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
