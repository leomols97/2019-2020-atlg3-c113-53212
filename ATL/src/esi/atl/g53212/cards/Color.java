package esi.atl.g53212.cards;

/**
 *
 * @author leopoldmols
 */
public enum Color {
    CLUB ("trèfle"),
    DIAMOND ("carreau"),
    HEART ("coeur"),
    SPADE ("pique");
    
    private String color;

    private Color(String color) {
        this.color = color;
    }
    
    @Override
    public String toString () {
        return this.color;
    }
}
