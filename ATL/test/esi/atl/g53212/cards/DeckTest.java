package esi.atl.g53212.cards;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class DeckTest {
    
    public DeckTest() {
    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Deck cards = new Deck();
        for (int i = 0; i < cards.getCardList().size(); i++) {
            cards.hit();
        }
        assertTrue(true);
    }

    /**
     * Test of hit method, of class Deck.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Deck instance = new Deck();
        Card expResult = new Card(Color.CLUB, Value.ACE);
        Card result = instance.hit();
        assertEquals(expResult, result);
    }
}
