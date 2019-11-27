package Models;

/**
 * Enumerates both possible colors and values for the colors
 * 
 * @author leopoldmols
 */
public enum Color {
    
    /**
     * Possible colors
     */
    WHITE,
    BLACK,
    EMPTY;

    public Color invert() {
        if (this == WHITE)
        {
            return BLACK;
        }
        else if (this == BLACK)
        {
            return WHITE;
        }
        else
        {
            return EMPTY;
        }
    }
}