/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ModelTest {
    
    public ModelTest() {
    }

    /**
     * Test of initialize method, of class Model.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Model instance = new ModelImpl();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Model.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Model instance = new ModelImpl();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOver method, of class Model.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Model instance = new ModelImpl();
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class Model.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Model instance = new ModelImpl();
        Piece[][] expResult = null;
        Piece[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent method, of class Model.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        Model instance = new ModelImpl();
        Player expResult = null;
        Player result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canPlaceSmw method, of class Model.
     */
    @Test
    public void testCanPlaceSmw() {
        System.out.println("canPlaceSmw");
        Model instance = new ModelImpl();
        boolean expResult = false;
        boolean result = instance.canPlaceSmw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class Model.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Color color = null;
        Model instance = new ModelImpl();
        int expResult = 0;
        int result = instance.getScore(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class Model.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Position position = null;
        Model instance = new ModelImpl();
        instance.play(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePlayer method, of class Model.
     */
    @Test
    public void testChangePlayer() {
        System.out.println("changePlayer");
        Model instance = new ModelImpl();
        instance.changePlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ModelImpl implements Model {

        public void initialize() {
        }

        public void start() {
        }

        public boolean isOver() {
            return false;
        }

        public Piece[][] getBoard() {
            return null;
        }

        public Player getCurrent() {
            return null;
        }

        public boolean canPlaceSmw() {
            return false;
        }

        public int getScore(Color color) {
            return 0;
        }

        public void play(Position position) {
        }

        public void changePlayer() {
        }
    }
    
}
