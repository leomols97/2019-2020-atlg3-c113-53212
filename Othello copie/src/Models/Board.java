package Models;

import java.util.LinkedList;

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
    private final Piece [][] board;

    /**
     * This constructs the object Board with the parameter "board" received as class parameter
     */
    public Board()
    {
        this.board = new Piece[8][8];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = new Piece(Color.EMPTY);
            }
        }
        board[3][3].setColor(Color.WHITE);
        board[3][4].setColor(Color.BLACK);
        board[4][4].setColor(Color.WHITE);
        board[4][3].setColor(Color.BLACK);
    }

    /**
     * Gets the playing board
     * 
     * @return the playing board
     */
    public Piece[][] getBoard()
    {
        return board;
    }
    
    /**
     * Adds a piece on the playing board
     * 
     * @param piece the piece to add
     * @param pos the position where to add the piece
     */
    public void addPiece(Piece piece, Position pos)
    {
        this.board[pos.getRow()][pos.getColumn()] = piece;
    }
    
    /**
     * Verifies if the game is over or not
     * 
     * @return true of the game is over and false else
     */
    public boolean isOver()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j].getColor() == Color.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verifies if a position can welcome a piece or not
     * 
     * @param pos the position where a piece should come
     * @param piece the piece that has to come
     * @return true if the position can welcome a piece with the current color and false else
     */
    public boolean positionable (Position pos, Piece piece)
    {
        if (pos.getRow() == 0)
        {
            if (pos.getColumn() == 0)
            {
                return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                        && board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                        || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                        && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                        || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                        && board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                        );
            } else
                if (pos.getColumn() == 7)
                {
                    return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                            && board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                            || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                            && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                            || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                            && board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                            );
                }
            return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                );
        } else
            if (pos.getRow() == 7)
            {
                if (pos.getColumn() == 0)
                {
                    return ((board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                            && board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                            || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                            && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                            || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                            && board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                            );
                } else
                    if (pos.getColumn() == 7)
                    {
                        return ((board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                                && board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                                || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                                && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                                || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                                && board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                                );
                    }
                return ((board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                );
            }
        if (pos.getColumn() == 0)
        {
            return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                );
        }
        if (pos.getColumn() == 7)
        {
            return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                );
        }
        return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor().EMPTY)
                );
    }
    
    /*
    public Position direction (Position pos, Piece piece)
    {
        
    }*/
    
    /**
     * Verifies if there are some piece to "eat" in the up direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the up direction and false else
     */
    public boolean verifDirUp (Position pos, Color color)
    {
        Position pos1 = new Position(pos.getRow() + 1, pos.getColumn() + 1);
        LinkedList<Color> list = new LinkedList<>();
        while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY)
        {            
            pos1.setRow(pos1.getRow() + 1);
            pos1.setColumn(pos1.getColumn() + 1);
            list.add(board[pos1.getRow()][pos1.getColumn()].getColor());
        }
        if (list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != color && list.lastIndexOf(pos).getColor() == color)
        {
            return true;
        }
    }
    
    /**
     * Verifies if there are some piece to "eat" in the upLeft direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the upLeft direction and false else
     */
    public boolean verifDirUpLeft (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if there are some piece to "eat" in the upRight direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the upRight direction and false else
     */
    public boolean verifDirUpRight (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if there are some piece to "eat" in the down direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the down direction and false else
     */
    public boolean verifDirDown (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if there are some piece to "eat" in the downLeft direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the DownLeft direction and false else
     */
    public boolean verifDirDownLeft (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if there are some piece to "eat" in the downRight direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the downRight direction and false else
     */
    public boolean verifDirDownRight (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if there are some piece to "eat" in the right direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the right direction and false else
     */
    public boolean verifDirRight (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if there are some piece to "eat" in the left direction belonging the position of the piece
     * 
     * @param pos the position of the piece
     * @param color the color of the piece
     * @return true of there are some piece to "eat" in the left direction and false else
     */
    public boolean verifDirLeft (Position pos, Piece piece)
    {
        
    }
    
    /**
     * Verifies if a position is free
     * 
     * @param pos the position that has to be verified
     * @return true is the position is free and false else
     */
    public boolean isFree (Position pos)
    {
        return board[pos.getRow()][pos.getColumn()].getColor() != Color.EMPTY;
    }
    
    /**
     * This constructs the object Board with the parameter "board" received as class parameter
     */
    /*
    protected Board()
    {
        this.board = new Piece [10][10];
        
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = new Piece();
            }
        }
    }
    */

    /**
     * This method helps the other class to be able to access to the value of the playing board. This get the value of the variable "board"
     * @return board that returns the dimensions of the playing board
     */
    /*
    public Square[][] getboard()
    {
        return board;
    }
    */
    
    /**
     * Boolean method that returns true if the position given in the parameters is contained in the playing board and false either
     * @param pos the position given by the methods that calls this one to be able to know if the following is contained by the playing board or not
     * @return true if the position given in the parameters is contained by the playing board, and false if not
     */
    /*
    protected boolean isInside (Position pos)
    {
        return this.getboard().length > pos.getRow() && this.getboard()[0].length > pos.getColumn() 
                && pos.getRow() >= 0 && pos.getColumn() >= 0;
    }
    */
    
    /**
     * Allows the other classes to know where's a position on the playing board of the position given in the parameters
     * @param pos the parameters that allows the method to know what is the place to return
     * @return the exact place of the position given in the parameters on the playing board
     * 
     * This throws an IllegalArgumentException("La pièce n'est pas sur le board de jeu !") if the method isInside() retturns false
     */
    /*
    protected Square getSquare(Position pos)
    {
        
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position n'est pas sur le board de jeu !");
        }
        return this.board[pos.getRow()][pos.getColumn()];
    }
    */
    
    /**
     * Add a piece on the palying board belonging the nature of the piece and the position where to add the piece
     * @param piece the piece to add
     * @param pos the position on the playing board where to add the piece
     * 
     * This throws an IllegalArgumentException("La pièce n'est pas sur le board de jeu !") if the method isInside() retturns false
     */
    /*
    public void put(Piece piece, Position pos)
    {
        
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La pièce n'est pas sur le board de jeu !");
        }
        this.board[pos.getRow()][pos.getColumn()].put(piece);
    }
    */
    
    /**
     * Verifies if the square of position received as parameters contains any piece or not
     * @param pos the position in which the method has to verify if any piece stays or not
     * @return true if the square at the position is free of piece and false either
     * 
     * This method throws an ArrayIndexOutOfBoundsException("La position ne fait pas partie du tableau de jeu !")
     * if the position doesn't concerns a square that is in the playing board
     */
    /*
    public boolean isFree (Position pos)
    {
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position ne fait pas partie du tableau de jeu !");
        }
        return this.getSquare(pos).isFree();
    }
    */
    
    /**
     * Shows  the caracteristics of the object "Piece" that stands on the position given as parameters
     * @param pos the position where the piece has to be returned
     * @return the piece that stands on the position given as paramters
     * 
     * This throws a new ArrayIndexOutOfBoundsException("La position ne fait pas partie du tableau de jeu !") if the position is not insiade the playing board
     */
    /*
    public Piece getPiece(Position pos)
    {
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position ne fait pas partie du tableau de jeu !");
        }
        return getSquare(pos).getPiece();
    }
    */
    
    /**
     * Count the number of pieces that belongs to the player received as parameter
     * @param player
     * @return the number of pieces
     */
    /*
    public int getNumberOwnPieces(Player player)
    {
        int cpt = 0;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j].isMyOwn(player.getColor()))
                {
                    cpt++;
                }
            }
        }
        return cpt;
    }*/
}
