package esi.atl.g53212.cards;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author leopoldmols
 */
public class Deck {
    
    private List<Card> cardList;

    public Deck() {
    }
    
    public void shuffle () {
        Collections.shuffle(this.cardList);
    }
    
    public boolean isEmpty () {
        return this.cardList.isEmpty();
    }
    
    public Card hit () {
        return this.cardList.remove(0);
    }
}
