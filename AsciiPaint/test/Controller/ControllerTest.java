package Controller;

import Models.AsciiPaint;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ControllerTest {
    
    /**
     *
     */
    public ControllerTest() {
    }

    /**
     * Test of beginning method, of class Controller.
     */
    @Test
    public void testBeginning() {
        System.out.println("beginning");
        Controller instance = null;
        instance.beginning();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addShowExit method, of class Controller.
     */
    @Test
    public void testAddShowExit() {
        System.out.println("addShowExit");
        String[] t = null;
        AsciiPaint paint = null;
        Controller instance = null;
        boolean expResult = false;
        boolean result = instance.addShowExit(t, paint);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newShape method, of class Controller.
     */
    @Test
    public void testNewShape() {
        System.out.println("newShape");
        String[] t = null;
        AsciiPaint asciiPaint = null;
        Controller instance = null;
        instance.newShape(t, asciiPaint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawSquare method, of class Controller.
     */
    @Test
    public void testDrawSquare() {
        System.out.println("drawSquare");
        String[] t = null;
        AsciiPaint paint = null;
        Controller instance = null;
        instance.drawSquare(t, paint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawRectangle method, of class Controller.
     */
    @Test
    public void testDrawRectangle() {
        System.out.println("drawRectangle");
        String[] t = null;
        AsciiPaint paint = null;
        Controller instance = null;
        instance.drawRectangle(t, paint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawCircle method, of class Controller.
     */
    @Test
    public void testDrawCircle() {
        System.out.println("drawCircle");
        String[] t = null;
        AsciiPaint paint = null;
        Controller instance = null;
        instance.drawCircle(t, paint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
