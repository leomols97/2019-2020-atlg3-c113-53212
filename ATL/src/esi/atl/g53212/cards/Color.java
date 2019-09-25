package esi.atl.g53212.cards;

/**
 * This enumeration purpose exactly 4 possibilities for the card color
 * @author leopoldmols
 */
public enum Color {
    CLUB ("trèfle"),
    DIAMOND ("carreau"),
    HEART ("coeur"),
    SPADE ("pique");
    
    private String color;

    /**
     * Constructs a color with the first class parameter
     * @param color the color to initialize
     */
    private Color(String color) {
        this.color = color;
    }
    /**
     * @return only the color initialized
     */
    @Override
    public String toString () {
        return this.color;
    }
}
