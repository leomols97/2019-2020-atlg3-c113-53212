package Models;
/**
 * This class initialisaze an object "Position" that manages the positions on the playing board
 *
 * @author Léopold Mols
 */
public class Position {
    
    private final int row;
    private final int column;
    
    /**
     * This constructs the object Position with the parameters "row" and "column" received as class parameters
     * @param row the row of the position
     * @param column the column of the position
     * 
     * this method throws an IllegalArgumentException if the row is negative
     * this method throws an IllegalArgumentException if the column is negative
     */
    public Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    
    /**
     * This method allows the other classes to know the row of the current position
     * @return the row of the current object "Position"
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * This method allows the other classes to know the row of the current position
     * @return the row of the current object "Position"
     */
    public int getColumn()
    {
        return column;
    }
    
    /**
     * Overrides the method hashCode() from the Java API
     * @return the hashcode from the Object
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 47 * hash + this.row;
        hash = 47 * hash + this.column;
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
        final Position other = (Position) obj;
        if (this.row != other.row)
        {
            return false;
        }
        return this.column == other.column;
    }
    
    /**
     * Overrides the method "toString()" from Java API
     * @return the row and the column of the current Position with a sentence
     */
    @Override
    public String toString()
    {
        return "La position est de ligne " + row + " et en colonne " + column;
    }
    
    /**
     * Purpose to the program the next position possible by a piece on the playing board
     * @param direction the next position of the piece
     * @return a new position by adding the row of the new direction to the row of the actual position of the piece
     * and by adding the column of the new direction to the column of the actual position of the piece
     */
    public Position next(Direction direction)
    {
        return new Position(this.row + direction.getRow(), this.column + direction.getColumn());
    }
}