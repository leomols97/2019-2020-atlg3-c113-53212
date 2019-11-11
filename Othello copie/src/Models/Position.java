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
}