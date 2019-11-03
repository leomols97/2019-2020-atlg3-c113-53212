package Models;

import java.util.List;

/**
 *  Model of Othello for the class "Game"
 * 
 * @author leopoldmols
 */
public interface Model {
    
    /**
     * Initializes a new game with a default board
     */
    void initialize();
    
    /**
     * Checks if a match can start
     * 
     * @throws IllegalStateException if no board is set.
     * @throws IllegalStateException if the board set is incomplete.
     * 
     */
    void start();
    
    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isOver();
    
    /**
     * Gets the playing board
     * 
     * @return the board.
     */
    Square [][] getBoard();
    
    /**
     * Select a position at a position to make it change of color
     * 
     * @param row the row of the position
     * @param column the column of the position
     */
    void select (int row, int column);
    
    /**
     * Gets the piece at a selected position
     * 
     * @return the position of a selected piece
     */
    Piece getSelected();
    
    /**
     * This method gives the current player
     * 
     * @return the player that has to play now
     */
    Player getCurrent();
    
//    /**
//     * Inserts a piece on the playing board if this is possible
//     * 
//     * @param pos the position where to pu the piece
//     */
//    void put (Position pos);
    
    /**
     * Gets the quare on a position
     * @param pos the position where to find the square
     * @return the square
     */
    Square getSquare(Position pos);
}
