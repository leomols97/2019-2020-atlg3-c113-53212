/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.Player;
import Models.Square;
import java.util.List;
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
     * Test of initialize method, of class View.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        View instance = new View();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quit method, of class View.
     */
    @Test
    public void testQuit() {
        System.out.println("quit");
        View instance = new View();
        instance.quit();
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
        View instance = new View();
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
        View instance = new View();
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
        View instance = new View();
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
        List<Player> winners = null;
        List<Player> loosers = null;
        View instance = new View();
        instance.displayOver(winners, loosers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayCurrentPlayer method, of class View.
     */
    @Test
    public void testDisplayCurrentPlayer() {
        System.out.println("displayCurrentPlayer");
        Player player = null;
        View instance = new View();
        instance.displayCurrentPlayer(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayBoard method, of class View.
     */
    @Test
    public void testDisplayBoard() {
        System.out.println("displayBoard");
        Square[][] square = null;
        Player current = null;
        boolean quitgame = false;
        View instance = new View();
        instance.displayBoard(square, current, quitgame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
