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
        Square[][] expResult = null;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class Model.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        int row = 0;
        int column = 0;
        Model instance = new ModelImpl();
        instance.select(row, column);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelected method, of class Model.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        Model instance = new ModelImpl();
        Piece expResult = null;
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
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
     * Test of getSquare method, of class Model.
     */
    @Test
    public void testGetSquare() {
        System.out.println("getSquare");
        Position pos = null;
        Model instance = new ModelImpl();
        Square expResult = null;
        Square result = instance.getSquare(pos);
        assertEquals(expResult, result);
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

        public Square[][] getBoard() {
            return null;
        }

        public void select(int row, int column) {
        }

        public Piece getSelected() {
            return null;
        }

        public Player getCurrent() {
            return null;
        }

        public Square getSquare(Position pos) {
            return null;
        }
    }
    
}
