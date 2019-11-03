package Models;

/**
 * Only constructs an object color
 * 
 * @author leopoldmols
 */
public class Piece {
    
    /**
     * The initial color
     */
    private final Color color;

    /*public Piece getPiece() {
        return piece;
    }*/

    /**
     * Constructs the color
     * @param color the initial color
     */
    public Piece(/*Piece piece,*/ Color color)
    {
//        this.piece = piece;
        this.color = color;
    }
    
    /**
     * Gets the current color
     * @return the current color
     */
    public Color getColor()
    {
        return color;
    }
}