/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.Piece;
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
     * Test of displayStart method, of class View.
     */
    @Test
    public void testDisplayStart() {
        System.out.println("displayStart");
        View instance = null;
        instance.displayStart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayQuit method, of class View.
     */
    @Test
    public void testDisplayQuit() {
        System.out.println("displayQuit");
        View instance = null;
        instance.displayQuit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayError method, of class View.
     */
    @Test
    public void testDisplayError() {
        System.out.println("displayError");
        String message = "";
        View instance = null;
        instance.displayError(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayHelp method, of class View.
     */
    @Test
    public void testDisplayHelp() {
        System.out.println("displayHelp");
        View instance = null;
        instance.displayHelp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of askCommand method, of class View.
     */
    @Test
    public void testAskCommand() {
        System.out.println("askCommand");
        View instance = null;
        String expResult = "";
        String result = instance.askCommand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayOver method, of class View.
     */
    @Test
    public void testDisplayOver() {
        System.out.println("displayOver");
        View instance = null;
        instance.displayOver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayBoard method, of class View.
     */
    @Test
    public void testDisplayBoard() {
        System.out.println("displayBoard");
        Piece[][] plateau = null;
        View instance = null;
        instance.displayBoard(plateau);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
