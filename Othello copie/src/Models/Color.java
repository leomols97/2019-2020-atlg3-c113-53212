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
        else
        {
            return WHITE;
        }
    }
    
    //private int color;

    /**
     * Constructs the color
     * 
     * @param color the actual color
     */
    /*
    private Color(int color)
    {
        this.color = color;
    }
    */

    /**
     * Gets the current color
     * 
     * @return the actual color
     */
    /*
    public int getColor()
    {
        return color;
    }
*/
}