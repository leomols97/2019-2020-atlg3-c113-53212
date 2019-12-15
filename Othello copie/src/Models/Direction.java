package Models;

/**
 * Intialize the different directions possible.
 * The different directions possible will be adapted belonging the piece and its position
 * 
 * @author leopoldmols
 */
public enum Direction
{
    
    /**
     * Possible directions
     */
    
    UP (-1, 0),

    /**
     *
     */
    DOWN (1, 0),

    /**
     *
     */
    LEFT (0, -1),

    /**
     *
     */
    RIGHT (0, 1),

    /**
     *
     */
    DOWNLEFT (1, -1),

    /**
     *
     */
    DOWNRIGHT (1, 1),

    /**
     *
     */
    UPLEFT (-1, -1),

    /**
     *
     */
    UPRIGHT (-1, 1);
    
    /**
     * As the directions are moves, it is necessary to know the row and the column
     * that will be the values of the different deltas of moves
     */
    
    private final int row;
    private final int column;

    
    /**
     * Constructs the parameters of the class that makes the new position that is made by a new row and a new Column
     * 
     * @param row the row of the direction standing
     * @param column the column of the direction standing
     */
    
    private Direction(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    
    /**
     * Allows the other classes to access the row of the direction
     * 
     * @return the row of the direction
     */
    
    public int getRow()
    {
        return row;
    }

    
    /**
     * Allows the other classes to access the column of the direction
     * 
     * @return the column of the direction
     */
    
    public int getColumn()
    {
        return column;
    }
}