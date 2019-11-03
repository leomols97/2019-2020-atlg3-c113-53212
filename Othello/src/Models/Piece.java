package Models;

/**
 *
 * @author leopoldmols
 */
public class Piece {
    
//    private Piece piece;
    private final Color color;

    /*public Piece getPiece() {
        return piece;
    }*/

    public Piece(/*Piece piece,*/ Color color)
    {
//        this.piece = piece;
        this.color = color;
    }
    
    public Color getColor()
    {
        return color;
    }
}