package esi.atl.g53212.cards;

/**
 * This enumeration allows exactly 12 possibilities of value to assign to each card
 * @author leopoldmols
 */
public enum Value {
    ACE ("As"),
    TWO ("Deux"),
    THREE ("Trois"),
    FOUR ("Quatre"),
    FIVE ("Cinq"),
    SIX ("Six"),
    SEVEN ("Sept"),
    EIGHT ("Huit"),
    NINE ("Neuf"),
    TEN ("Dix"),
    JACK ("Valet"),
    QUEEN ("Dame"),
    KING ("Roi");
    
    private String value;

    /**
     * Construct a value with the first class parameters
     * @param value the value received as parameters
     */
    private Value(String value) {
        this.value = value;
    }
    
    /**
     * @return one of the 12 values
     */
    @Override
    public String toString () {
        return this.value;
    }
}
