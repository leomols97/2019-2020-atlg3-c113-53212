package Models;

/**
 * Enumerates the different possible colors
 *
 * @author leopoldmols
 */
public enum Color
{
    /**
     * Possible colors
     */
    WHITE,
    BLACK,
    EMPTY,
    BONUS,
    BONUSBLACK,
    BONUSWHITE;
    
    
    /**
     * Inverts the color of a caracteristic peice
     *
     * @return the nexw color of this piece
     */
    public Color invert()
    {
        switch (this)
        {
            case WHITE:
                return BLACK;
            case BLACK:
                return WHITE;
            case BONUSBLACK:
                return BONUSWHITE;
            case BONUSWHITE:
                return BONUSBLACK;
            default:
                return EMPTY;
        }
    }
}