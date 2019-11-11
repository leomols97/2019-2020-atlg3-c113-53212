/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class OthelloTest {
    
    public OthelloTest() {
    }

    /**
     * Test of main method, of class Othello.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Othello.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Othello.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Stage primaryStage = null;
        Othello instance = new Othello();
        instance.start(primaryStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
