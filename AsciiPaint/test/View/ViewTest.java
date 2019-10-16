/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ViewTest {
    
    public ViewTest() {
    }

    /**
     * Test of doNext method, of class View.
     */
    @Test
    public void testDoNext() {
        System.out.println("doNext");
        View instance = new View();
        String expResult = "";
        String result = instance.doNext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beginning method, of class View.
     */
    @Test
    public void testBeginning() {
        System.out.println("beginning");
        View instance = new View();
        instance.beginning();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of error method, of class View.
     */
    @Test
    public void testError() {
        System.out.println("error");
        View instance = new View();
        instance.error();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of errorSquare method, of class View.
     */
    @Test
    public void testErrorSquare() {
        System.out.println("errorSquare");
        View instance = new View();
        instance.errorSquare();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of errorRectangle method, of class View.
     */
    @Test
    public void testErrorRectangle() {
        System.out.println("errorRectangle");
        View instance = new View();
        instance.errorRectangle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of errorCircle method, of class View.
     */
    @Test
    public void testErrorCircle() {
        System.out.println("errorCircle");
        View instance = new View();
        instance.errorCircle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
