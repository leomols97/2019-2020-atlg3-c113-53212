package esi.atl.g53212.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class creates a deck with a list of cards,
 * and offers the possibility to shuffle the cards, to verify if the deck is not empty, to show the first card of the deck
 * and to show the whole deck
 * @author leopoldmols
 */
public class Deck {
    
    private List<Card> cardList;

    /**
     * Creates an ArrayList of cards and gives a color and a value to each card
     */
    public Deck() {
        // APA : Pourquoi une arrayList
        //cardList = new LinkedList<Card>();
        // APA : Pourquoi ne pas avoir créer directement de 52
        cardList = new ArrayList<Card>();
        for (Color colorCard : Color.values()) {
            for (Value valueCard : Value.values()) {
                Card card = new Card(colorCard, valueCard);
                this.cardList.add(card);
            }
        }
    }
    
    /**
     * Shuffles the deck
     */
    public void shuffle () {
        Collections.shuffle(this.cardList);
    }
    
    /**
     * @return true if the deck is empty and false else
     */
    public boolean isEmpty () {
        return this.cardList.isEmpty();
    }
    
    /**
     * @return the first card of the deck
     */
    public Card hit () {
        // APA : Si la liste est vide ?
        // APA : cardList.remove(cardList.size()-1)
        return this.cardList.remove(0);
    }

    /**
     * This method allows the others to access to the values of cardList
     * @return cardList
     */
    public List<Card> getCardList() {
        return cardList;
    }
    
    /**
     * @return the deck of cards
     */
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
