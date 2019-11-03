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
public class PlayerColorTest {
    
    public PlayerColorTest() {
    }

    /**
     * Test of values method, of class PlayerColor.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        PlayerColor[] expResult = null;
        PlayerColor[] result = PlayerColor.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class PlayerColor.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        PlayerColor expResult = null;
        PlayerColor result = PlayerColor.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class PlayerColor.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        PlayerColor instance = null;
        int expResult = 0;
        int result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
