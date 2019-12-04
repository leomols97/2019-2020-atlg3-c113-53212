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
public class ColorTest {
    
    public ColorTest() {
    }

    /**
     * Test of values method, of class Color.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Color[] expResult = null;
        Color[] result = Color.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Color.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Color expResult = null;
        Color result = Color.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invert method, of class Color.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        Color instance = null;
        Color expResult = null;
        Color result = instance.invert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
