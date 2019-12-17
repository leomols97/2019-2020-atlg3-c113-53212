package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class ActionTest {
    
    public ActionTest() {
    }

    /**
     * Test of values method, of class Action.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Action[] expResult = null;
        Action[] result = Action.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Action.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Action expResult = null;
        Action result = Action.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNOUVELLE_PARTIE method, of class Action.
     */
    @Test
    public void testGetNOUVELLE_PARTIE() {
        System.out.println("getNOUVELLE_PARTIE");
        Action expResult = null;
        Action result = Action.getNOUVELLE_PARTIE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPLACE_PIECE method, of class Action.
     */
    @Test
    public void testGetPLACE_PIECE() {
        System.out.println("getPLACE_PIECE");
        Action expResult = null;
        Action result = Action.getPLACE_PIECE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPASSE_TOUR method, of class Action.
     */
    @Test
    public void testGetPASSE_TOUR() {
        System.out.println("getPASSE_TOUR");
        Action expResult = null;
        Action result = Action.getPASSE_TOUR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
