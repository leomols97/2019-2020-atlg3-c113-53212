package esi.atl.g53212.cards;

/**
 *
 * @author leopoldmols
 */
public class Card {
    
    private Color color;
    private Value value;

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
    public String toString() {
        return this.value + " de " + this.color;
    }
}
