package Models;

import java.util.List;


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
    int getScoreBLACK(Color color);
    
    
    /**
     * gets the score of a player
     * 
     * @param color the color of the player that wants his score
     * 
     * @return the score of the player
     */
    int getScoreWHITE(Color color);
    
    
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
    
    
    /**
     * Verifies if a player can play at a certain position
     * 
     * @param position the position where to verify if the current player can play
     * 
     * @return true if he can play and false else
     */
    boolean canPlay(Position position);
    
    
    /**
     * Tells if a position is free or not
     * 
     * @param pos the position to verify
     * 
     * @return true if the position is free and false else
     */
    boolean isFree(Position pos);
    
    
    /**
     * Counts the number of white pieces on the playing board
     * 
     * @return the number of white pieces that stands on the board
     */
    int getNbWhites ();
    
    
    /**
     * Counts the number of black pieces on the playing board
     * 
     * @return the number of black pieces that stands on the board
     */
    int getNbBlacks ();
            
    
    /**
     * Adds an observer in the observer list
     * 
     * @param obs the observer to add
     */
    void registerObserver(Observer obs);
    
    
    /**
     * Remove an observer from the observer list
     * 
     * @param obs the observer to remove
     */
    void removeObserver(Observer obs);
    
    
    /**
     * Calls each method update()
     * from each observer from the observer list
     */
    void notifyObservers();
    
    /**
     * 
     * Counts the number of pieces that stands on the playing board
     * 
     * @return the number of pieces that stands on the playing board
     */
    double getNbPieces ();
    
    
    /**
     * Count the number of squares that compose the playing board
     * 
     * @return the number of squares that compose on the playing board
     */
    double getNbCases ();
    
    
    /**
     * Looks for all the playable positions on the playing board
     * 
     * @param position the position where the player could add a piece
     * 
     * @return a list of all those positions
     */
    public List<Position> possiblePositions (Position position);
    
    
    /**
     * Gets the strike done by a player
     * 
     * @return a list of every strikes
     */
    List<Tour> getTours ();
    
    
    /**
     * Adds to the table the informations about a turn when the player puts a piece
     */
    void placePieceRowTable ();
    
    
    /**
     * Adds to the table a row when the player passed his turn
     */
    void passRowTable ();
    
    
    /**
     * Gets the oponent player
     * 
     * @return the oponent player
     */
    Player getOponent ();
    
    
    /**
     * Verifies if the current player has strikes left or not
     * 
     * @param color the color of the current player
     * 
     * @return true if the player can play and false else
     */
    boolean hasStrikes (Color color);
    
    
    /**
     * Verifies if there's only one color on the playing board
     * 
     * @param color the color to verify
     * 
     * @return true if there's only this color on the playing board and false else
     */
    boolean onlyOneColor (Color color);
    
    
    /**
     * Counts the number of pieces that the turn will flip
     * 
     * @param position the position where the player will play
     * @param color the color of the player
     * 
     * @return the number of pieces that will be flipped
     */
    int nbPiecesGot (Position position, Color color);
    
    boolean isBonusCase (Position position);
}