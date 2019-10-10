package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class AsciiPaintTest {
    
    /**
     *
     */
    public AsciiPaintTest() {
    }

    /**
     * Test of getColor method, of class AsciiPaint.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Point p = null;
        AsciiPaint instance = new AsciiPaint();
        char expResult = ' ';
        char result = instance.getColor(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newCircle method, of class AsciiPaint.
     */
    @Test
    public void testNewCircle() {
        System.out.println("newCircle");
        int x = 0;
        int y = 0;
        double radius = 0.0;
        char color = ' ';
        AsciiPaint instance = new AsciiPaint();
        instance.newCircle(x, y, radius, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newRectangle method, of class AsciiPaint.
     */
    @Test
    public void testNewRectangle() {
        System.out.println("newRectangle");
        int x = 0;
        int y = 0;
        double width = 0.0;
        double height = 0.0;
        char color = ' ';
        AsciiPaint instance = new AsciiPaint();
        instance.newRectangle(x, y, width, height, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newSquare method, of class AsciiPaint.
     */
    @Test
    public void testNewSquare() {
        System.out.println("newSquare");
        int x = 0;
        int y = 0;
        double side = 0.0;
        char color = ' ';
        AsciiPaint instance = new AsciiPaint();
        instance.newSquare(x, y, side, color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of asAscii method, of class AsciiPaint.
     */
    @Test
    public void testAsAscii() {
        System.out.println("asAscii");
        AsciiPaint instance = new AsciiPaint();
        String expResult = "";
        String result = instance.asAscii();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
