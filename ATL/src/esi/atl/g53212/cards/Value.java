package esi.atl.g53212.cards;

/**
 *
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

    private Value(String value) {
        this.value = value;
    }
    
    @Override
    public String toString () {
        return this.value;
    }
}
