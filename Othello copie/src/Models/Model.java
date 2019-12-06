package Models;


/**
 *  Model of Othello for the class "Game"
 * 
 * @author leopoldmols
 */

public interface Model
{
    
    
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
    
    Piece [][] getBoard();
    
    
    /**
     * This method gives the current player
     * 
     * @return the player that has to play now
     */
    
    Player getCurrent();
    
    
    /**
     * Verifies if the player can even place a piece on the playing board
     * 
     * @return true if he can and false else
     */
    
    boolean canPlaceSmw();
    
    
    /**
     * gets the score of a player
     * 
     * @param color the color of the player that wants his score
     * 
     * @return the score of the player
     */
    
    int getScore(Color color);
    
    
    /**
     * Puts a piece at a certain position and flips all the flippable pieces around
     * 
     * @param position the position where to add a piece
     */
    
    void play(Position position);
    
    
    /**
     * Change the current player
     */
    
    void changePlayer();
}
