package Models;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author leopoldmols
 */

public class Game implements Model{
    
    private Board board;
    private Player current;
    private Player oponent;
    private Position selected;
    
    public Game()
    {
        initialize();
    }
    
    @Override
    public void initialize()
    {
        this.board = new Board ();
        
        current = new Player(Color.WHITE);
        oponent = new Player(Color.BLACK);
        
        Piece p1 = new Piece(current.getColor());
        Piece p2 = new Piece(current.getColor());
        Piece p3 = new Piece(current.getColor());
        Piece p4 = new Piece(current.getColor());
        
        Position posp1 = new Position(5, 5);
        Position posp2 = new Position(5, 6);
        Position posp3 = new Position(6, 5);
        Position posp4 = new Position(6, 6);
        
    }
    
    /**
     * This methods overrides the methods "start()" received from the class Model and verifies if the playing board exists and
     * if any piece is over any other piece via the following method in this class
     *
     * This method throws a IllegalStateException("Le plateau de jeu n'a pas été initialisé !") if the board doesn't exist
     * This method throws a IllegalArgumentException("La partie est terminée !") if the game is finished
     */
    @Override
    public void start()
    {
        if (board == null)
        {
            throw new IllegalStateException("Le plateau de jeu n'a pas été initialisé !");
        }
        if (isOver())
        {
            throw new IllegalArgumentException("La partie est terminée !");
        }
        System.out.println(board.getBoard());
    }
    
    /**
     * Overrides the method "isOver()" that comes from the class Model.
     * Verifies if both players have moves left and if both of them still have their own flags
     * @return true if both players have moves left and if both of them still have their own flags and false either
     */
    @Override
    public boolean isOver() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j].getColor() == Color.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Overrides the method "getBoard()" from the class Model.
     * @return the playing board from the current playing board
     */
    @Override
    public Piece [][] getBoard()
    {
        initialize();
        return this.board.getBoard();
    }
    
    /**
     * Overrides the method "select(int row, int column)" from the class Model.
     */
    @Override
    public void select(int row, int column)
    {
        Position position = new Position(row, column);
        if (!this.board.isInside(position)) {
            throw new NullPointerException("La position sélectionnée n'est pas dans le plateau de jeu !");
        }
        if (this.board.isFree(position)) {
            throw new NullPointerException("La position ne contient pas de pièce !");
        }
        this.selected = position;
    }
    
    /**
     * Overrides the method "getSelected()" from the class Model.
     */
    @Override
    public Piece getSelected()
    {
        return this.board.getPiece(selected);
    }
    
    /**
     * Overrides the method "getCurrent()" from the class Model.
     */
    @Override
    public Player getCurrent()
    {
        return this.current;
    }
    
    /**
     * Overrides the method "put(Position pos)" from the class Model.
     */
    @Override
    public void put (Position pos)
    {
        this.board.addPiece(this.board.getPiece(pos), pos);
    }
    
    /**
     * Overrides the method "getSquare(Position pos)" from the class Model.
     */
    @Override
    public Piece getPiece(Position pos)
    {
        return board.getPiece(pos);
    }
    
    /**
     * Change of current player
     */
    @Override
    public void changePlayer()
    {
        Player tmp;
        tmp = oponent;
        oponent = current;
        current = tmp;
    }
    
    /**
     * Verifies if the place is okay belonging the rules
     * @param pos the position where to put the piece
     * @return true if the player can put the piece or not
     */
    /*
    @Override
    public boolean legalPlace(Position pos) {
        
        boolean legal = false;
        if (board.isInside(pos))
        {
            for (Direction dir : Direction.values())
            {
                try
                {
                    Position p = pos.move(dir);
                    if (!board.isFree(pos)
                            && board.isInside(pos)
                            && board.getSquare(pos).getPiece().getColor() == oponent.getColor())
                    {
                        Position newPos = pos.move(dir);
                        while (board.isFree(pos)
                                && board.isInside(pos)
                                && !legal)
                        {
                            if (board.getSquare(newPos).getPiece().getColor() == current.getColor())
                            {
                                legal = true;
                            }
                            newPos  = newPos.move(dir);
                        }
                    }
                } catch (Exception e)
                {
                    System.out.println("La piece ne peut pas être placée à cet endroit !");
                }
            }
        }
        return legal;
    }*/
    
    /**
     * Verifies if the player can place a piece at a certain position
     * @param pos the position where to place the piece
     * @return true if he can and false else
     */
    @Override
    public boolean canPlace(Position position)
    {
        boolean legalPlace = false;
        
        if (this.board.isInside(position))
        {
            if (this.board.isFree(position))
            {
                for (Direction dir : Direction.values())
                {
                    try {
                        Position pos = position.next(dir);
                        if (this.board.isInside(pos)
                                && !this.board.isFree(pos)
                                && this.board.getBoard()[pos.getRow()][pos.getColumn()].getColor() == this.current.getColor().invert())
                        {
                            Position next = pos.next(dir);
                            while (!legalPlace
                                    && this.board.isInside(next)
                                    && !this.board.isFree(next))
                            {
                                if (this.board.getBoard()[next.getRow()][next.getColumn()].getColor() == this.current.getColor())
                                {
                                    legalPlace = true;
                                }
                                next = next.next(dir);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        throw new IllegalArgumentException("Vous ne pouvez pas place votre pièce à cet endroit !");
                    }
                }
            }
            return legalPlace;
        }
        else
        {
            throw new IllegalArgumentException("Cette position est en dehors du plateau de jeu !");
        }
    }
    
    /**
     * Verifies if the player can even place a piece on the playing board
     * @return true if he can and false else
     */
    
    @Override
    public boolean canPlaceSmw()
    {
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[0].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == Color.EMPTY)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * gets the score of the White player
     * @return the score of the White player
     */
    @Override
    public int getScoreWhite()
    {
        int cpt = 0;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[0].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == Color.WHITE)
                {
                    cpt++;
                }
            }
        }
        return cpt;
    }
    
    /**
     * gets the score of the Black player
     * @return the score of the Black player
     */
    @Override
    public int getScoreBlack()
    {
        int cpt = 0;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[0].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == Color.BLACK)
                {
                    cpt++;
                }
            }
        }
        return cpt;
    }

    
    
    
    
    
    
    /**
     * Place a piece at a certain position
     * @param position the position where to place the piece
     */
    @Override
    public void place(Position position)
    {
        if (this.canPlace(position)
                && this.board.positionable(position, this.board.getPiece(position)))
        {
            this.board.getPiece(position).setColor(current.getColor());
            for (Direction dir : Direction.values())
            {
                try
                {
                    Position pos = position.next(dir);
                    if (this.board.isInside(pos)
                            && !this.board.isFree(pos)
                            && this.board.getPiece(pos).getColor() == this.current.getColor().invert())
                    {
                        Position next = pos.next(dir);
                        LinkedList<Position> previousPos = new LinkedList<>();
                        previousPos.add(pos);
                        boolean endPreviousPos = false;
                        while (!endPreviousPos
                                && this.board.isInside(next)
                                && this.getPiece(next).getColor() != Color.EMPTY)
                        {     
                            if (this.board.getPiece(next).getColor() == this.current.getColor())
                            {
                                previousPos.forEach(prevPos -> this.board.getPiece(prevPos).invert());
                                endPreviousPos = true;
                            }
                            else
                            {
                                previousPos.add(next);
                                next = next.next(dir);
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Vous ne pouvez pas placer de pièce à cet endroit !");
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("Vous ne pouvez pas placer de pièce à cet endroit !");
        }
    }
    
    
    
    
    
    
    /**
     * Verifies if the piece that stands on a square on the playing board the playing board has the same color than a color
     * @param position where the method has to verify if there's a piece on it and if well, if it has the same color than the second parameter
     * @param color the color that has to be compared to the piece on the position given as first parameter
     * @return true if the piece has the same color than the color given in the parameters and true either
     * 
     * This metho throws a NullPointerException("La position n'existe pas !") if the piece doesn't exist
     * This throws a new IllegalStateException("La position ne fait pas partie du tableau de jeu !") if the position is not insiade the playing board
     */
    public boolean isMyOwn(Position position, Color color)
    {
        if (position == null)
        {
            throw new NullPointerException("La position n'existe pas !");
        }
        if (!this.board.isInside(position))
        {
            throw new IllegalStateException("La position ne fait pas partie du tableau de jeu !");
        }
        return this.getPiece(position).isMyOwn(color);
    }

    @Override
    public boolean legalPlace(Position pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}