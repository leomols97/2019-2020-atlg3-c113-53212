package Models;

/**
 * This is the way we have to give the different possibilities of colors for the player so that any other color will be rejected
 *
 * @author leopoldmols
 */
public enum PlayerColor {
    WHITE (0),
    BLACK (1);
    
    private final int color;

    private PlayerColor(int color) {
        this.color = color;
    }

    public int getColor()
    {
        return color;
    }
}
