package esi.atl.g53212.cards;

import java.util.Objects;

/**
 * This class initializes a card defined by a value and by a color
 * @author leopoldmols
 */
public class Card {
    
    private Color color;
    private Value value;

    /**
     * This constructor initialize both class arguments
     * @param color the card color
     * @param value the card value
     * Throws an IllegalArgumentException("La couleur de la carte n'est pas correcte !") if the card color is null
     * Throws an IllegalArgumentException("La valeur de la carte n'est pas correcte !") if the card value is null
     */
    public Card(Color color, Value value) {
        if (color == null) {
            throw new IllegalArgumentException("La couleur de la carte n'est pas correcte !");
        }
        if (value == null) {
            throw new IllegalArgumentException("La valeur de la carte n'est pas correcte !");
        }
        this.color = color;
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.color);
        hash = 83 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        
        // APA :
        /*
            return this.color== other.color && this.value == other.value
        */
        if (this.color != other.color) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    /**
     * This method only shows a more beautiful message to show which card and which card value is taken
     * @return the more beautiful message
     */
    @Override
    public String toString() {
        return this.value + " de " + this.color;
    }
}
