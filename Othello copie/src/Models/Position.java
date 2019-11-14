package Models;
/**
 * This class initialisaze an object "Position" that manages the positions on the playing board
 *
 * @author Léopold Mols
 */
public class Position {
    
    /**
     * The row and the column of a certain position
     */
    private int row;
    private int column;
    
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
     * 
     * @return the row of the current object "Position"
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * This method allows the other classes to know the row of the current position
     * 
     * @return the row of the current object "Position"
     */
    public int getColumn()
    {
        return column;
    }

    /**
     * Sets a new row to a certain position
     * 
     * @param row the new row of a position
     */
    public void setRow(int row)
    {
        this.row = row;
    }

    /**
     * Sets a new column to a certain position
     * 
     * @param column the new column of a position
     */
    public void setColumn(int column)
    {
        this.column = column;
    }
    
    /**
     * Purpose to the program the next position possible by a piece on the playing board
     * @param direction the next position of the piece
     * @return a new position by adding the row of the new direction to the row of the actual position of the piece
     * and by adding the column of the new direction to the column of the actual position of the piece
     */
    public Position next(Direction direction) {
        return new Position(this.row + direction.getRow(), this.column + direction.getColumn());
    }

    @Override
    public String toString() {
        return "Position{" + "row=" + row + ", column=" + column + '}';
    }
    
}