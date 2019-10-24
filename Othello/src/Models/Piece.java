package Models;

/**
 *
 * @author leopoldmols
 */
public class Piece {
    
    private Piece piece;
    
    private final int color;
    
    private Piece (int color)
    {
        this.color = color;
    }
    
    public int getColor()
    {
        return color;
    }
}