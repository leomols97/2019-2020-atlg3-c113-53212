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
    Piece [][] getBoard();
    
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
     * Inserts a piece on the playing board if this is possible
     * 
     * @param pos the position where to pu the piece
     */
    void put (Position pos);
    
    /**
     * Gets the quare on a position
     * 
     * @param pos the position where to find the square
     * @return the square
     */
    Piece getPiece(Position pos);
    
    /**
     * Change of current player
     */
    void changePlayer();

    /**
     * Verifies if the player can place a piece at a certain position
     * 
     * @param pos the position where to place the piece
     * @return true if he can and false else
     */
    boolean canPlace(Position pos);
    
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
     * Place a piece at a certain position
     * 
     * @param pos the position where to place the piece
     */
    void place (Position pos);
    
    /**
     * Verifies if a selected position contains a piece that belongs to the current player
     * 
     * @param position the position where to look
     * @param color the color of the current player
     * @return true if the position contains a piece that is the same color than the current color and false else
     */
    boolean isMyOwn(Position position, Color color);
    
    /**
     * Displays the player
     * 
     * @param over 
     */
    //void Player (boolean over);
}
