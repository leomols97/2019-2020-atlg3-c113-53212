package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class initialize a game board to welcome the Pieces to play
 * It also halps the other classes to know all the information that directly concerns the playing board and its contained pieces,
 * like if a piece is inside the playing board or not
 *
 * @author leopoldmols
 */
public class Board {
    
    /**
     * The initial board
     */
    private final Square [][] squares;
    
    /**
     * This constructs the object Board with the parameter "squares" received as class parameter
     */
    protected Board()
    {
        this.squares = new Square [10][10];
        
        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[0].length; j++)
            {
                squares[i][j] = new Square();
            }
        }
    }

    /**
     * This method helps the other class to be able to access to the value of the playing board. This get the value of the variable "squares"
     * @return squares that returns the dimensions of the playing board
     */
    public Square[][] getSquares()
    {
        return squares;
    }
    
    /**
     * Boolean method that returns true if the position given in the parameters is contained in the playing board and false either
     * @param pos the position given by the methods that calls this one to be able to know if the following is contained by the playing board or not
     * @return true if the position given in the parameters is contained by the playing board, and false if not
     */
    protected boolean isInside (Position pos)
    {
        return this.getSquares().length > pos.getRow() && this.getSquares()[0].length > pos.getColumn() 
                && pos.getRow() >= 0 && pos.getColumn() >= 0;
    }
    
    /**
     * Allows the other classes to know where's a position on the playing board of the position given in the parameters
     * @param pos the parameters that allows the method to know what is the place to return
     * @return the exact place of the position given in the parameters on the playing board
     * 
     * This throws an IllegalArgumentException("La pièce n'est pas sur le plateau de jeu !") if the method isInside() retturns false
     */
    protected Square getSquare(Position pos)
    {
        
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position n'est pas sur le plateau de jeu !");
        }
        return this.squares[pos.getRow()][pos.getColumn()];
    }
    
    /**
     * Add a piece on the palying board belonging the nature of the piece and the position where to add the piece
     * @param piece the piece to add
     * @param pos the position on the playing board where to add the piece
     * 
     * This throws an IllegalArgumentException("La pièce n'est pas sur le plateau de jeu !") if the method isInside() retturns false
     */
    protected void put(Piece piece, Position pos)
    {
        
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La pièce n'est pas sur le plateau de jeu !");
        }
        this.squares[pos.getRow()][pos.getColumn()].put(piece);
    }
    
    /**
     * Verifies if the square of position received as parameters contains any piece or not
     * @param pos the position in which the method has to verify if any piece stays or not
     * @return true if the square at the position is free of piece and false either
     * 
     * This method throws an ArrayIndexOutOfBoundsException("La position ne fait pas partie du tableau de jeu !")
     * if the position doesn't concerns a square that is in the playing board
     */
    public boolean isFree (Position pos)
    {
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position ne fait pas partie du tableau de jeu !");
        }
        return this.getSquare(pos).isFree();
    }
    
    /**
     * Shows  the caracteristics of the object "Piece" that stands on the position given as parameters
     * @param pos the position where the piece has to be returned
     * @return the piece that stands on the position given as paramters
     * 
     * This throws a new ArrayIndexOutOfBoundsException("La position ne fait pas partie du tableau de jeu !") if the position is not insiade the playing board
     */
    public Piece getPiece(Position pos)
    {
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position ne fait pas partie du tableau de jeu !");
        }
        return getSquare(pos).getPiece();
    }
    
    /**
     * Count the number of pieces that belongs to the player received as parameter
     * @param player
     * @return the number of pieces
     */
    public int getNumberOwnPieces(Player player)
    {
        int cpt = 0;
        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[i].length; j++)
            {
                if (squares[i][j].isMyOwn(player.getColor()))
                {
                    cpt++;
                }
            }
        }
        return cpt;
    }
}
