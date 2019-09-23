package esi.atl.g53212.cards;

/**
 *
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

    /**
     * This method only shows a more beautiful message to show which card and which card value is taken
     * @return the more beautiful message
     */
    @Override
    public String toString() {
        return this.value + " de " + this.color;
    }
}
