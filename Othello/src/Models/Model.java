package Models;

import java.util.List;

/**
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
    
    /**
     * Gets the list of winners (even if there will only be one winner)
     * 
     * @return the list of the winners of a hole game
     */
    List<Player> getWinners();
    
    /**
     * Gets the list of loosers (even if there will only be one looser)
     * 
     * @return the list of the loosers of a hole game
     */
    List<Player> getLoosers();
    
    /**
     * Verifies if the board is full of pieces or not
     * 
     * @param board the playing board to verify
     * @return true if the board is full and false else
     */
    boolean boardIsFull(Board board);
}
