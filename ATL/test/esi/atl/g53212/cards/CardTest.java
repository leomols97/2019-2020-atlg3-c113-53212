package esi.atl.g53212.cards;

import static esi.atl.g53212.cards.Color.CLUB;
import static esi.atl.g53212.cards.Value.ACE;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class CardTest {
    
    public CardTest() {
    }

    /**
     * Test of constructor Card method, of class Card.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testColorNull() {
        System.out.println("testColorNull");
        Card instance = new Card(null, Value.ACE);
    }
    
    /**
     * Test of constructor Card method, of class Card.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testValueNull() {
        System.out.println("testValueNull");
        Card instance = new Card(Color.CLUB, null);
    }
    
    /**
     * Test of constructor Card method, of class Card.
     */
    @Test
    public void testConstruct() {
        System.out.println("testConstruct");
        Card result = new Card(Color.CLUB, Value.ACE);
        Color expResultColor = CLUB;
        Value expResultValue = ACE;
        Card expResult = new Card(expResultColor, expResultValue);
        assertEquals(expResult, result);
    }
}
