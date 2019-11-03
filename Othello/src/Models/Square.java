package Models;

import java.util.Objects;

/**
 * This class represents a case on the player board. Every case is filled by 'ground' for the moment.
 * A square can welcome maximum one piece of a player
 *
 * @author Léopold Mols
 */
public class Square {
    
    private Piece piece;
    
    /**
     * This constructs the object Square
     */
    protected Square()
    {
        this.piece = null;
    }
    
    /**
     * This allows the other classes to know the piece that stays on the current position
     * @return the current object "piece"
     */
    public Piece getPiece()
    {
        return piece;
    }
    
    /**
     * Constructs a piece on a square the playing board belonging the object ('piece') as received in parameters
     *
     * @param piece the current object : piece
     * Throws a NullPointerException("La pièce n'existe pas !") if the object received as parameters "piece" doesn't exist
     * Throws a IllegalStateException("La pièce n'existe pas !") the current object "Piece" doesn't exist
     */
    protected void put (Piece piece)
    {
        if (piece == null)
        {
            throw new NullPointerException("La pièce n'existe pas !");
        }
        if (this.piece != null)
        {
            throw new IllegalStateException("La pièce n'existe pas !");
        }
        this.piece = piece;
    }
    
    /**
     * Verifies if the square already contains an object "piece" or not.
     * @return true is the square is free and false if not
     */
    public boolean isFree()
    {
        return this.piece == null;
    }
    
    /**
     * Verifies if the current player wants to move a piece that belongs to him or not
     * @param color the color that has to match with the color of the player
     * @return true if the piece exists and false if the color is different from RED or BLUE or if the colors don't match
     */
    public boolean isMyOwn(Color color)
    {
         return !isFree() && piece.getColor().equals(color);
    }
    
    /**
     * Overrides the method hashCode() from the Java API
     * @return the hashcode from the Object
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.piece);
        return hash;
    }
    
    /**
     * Overrides the method equals() from the Java API
     * @return the boolean value of the Object
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Square other = (Square) obj;
        return Objects.equals(this.piece, other.piece);
    }
    
    /**
     * Overrides the method "toString()" from Java API
     * @return the current piece
     */
    @Override
    public String toString()
    {
        return "La piece est " + piece;
    }
}