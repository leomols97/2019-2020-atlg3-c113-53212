package esi.atl.g53212.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author leopoldmols
 */
public class Deck {
    
    private List<Card> cardList;

    public Deck() {
        cardList = new ArrayList<Card>();
        for (Color colorCard : Color.values()) {
            for (Value valueCard : Value.values()) {
                Card card = new Card(colorCard, valueCard);
                this.cardList.add(card);
            }
        }
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
    
    public String toString () {
        if (cardList.isEmpty()) {
            return "Your deck is empty !" ;
        }
        int i = 1;
        String deck = "Your cards : ";
        while (i < cardList.size()) {
            deck += cardList.get(i) + ", ";
        }
        return deck;
    }
}
