package Models;

/**
 * Only constructs an object Piece
 * 
 * @author leopoldmols
 */
public class Piece {
    
    /**
     * The initial color
     */
    private Color color;

    /*public Piece getPiece() {
        return piece;
    }*/

    /**
     * Constructs the color
     * 
     * @param color the initial color
     */
    public Piece(/*Piece piece,*/ Color color)
    {
//        this.piece = piece;
        this.color = color;
    }
    
    /**
     * Gets the current color
     * 
     * @return the current color
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Change the color of the piece from BLACK to WHITE or invert
     */
    public void invert ()
    {
        if (this.color == Color.WHITE)
        {
            this.color = Color.BLACK;
        }
        if (this.color == Color.BLACK)
        {
            this.color = Color.WHITE;
        }
    }

    /**
     * Sets a new color to a piece
     * 
     * @param color the new color of the piece
     */
    public void setColor(Color color)
    {
        this.color = color;
    }
}