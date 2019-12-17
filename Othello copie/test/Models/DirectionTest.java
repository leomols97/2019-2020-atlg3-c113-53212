package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class DirectionTest {
    
    public DirectionTest() {
    }

    /**
     * Test of values method, of class Direction.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Direction[] expResult = null;
        Direction[] result = Direction.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Direction.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Direction expResult = null;
        Direction result = Direction.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class Direction.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Direction instance = null;
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumn method, of class Direction.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Direction instance = null;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}