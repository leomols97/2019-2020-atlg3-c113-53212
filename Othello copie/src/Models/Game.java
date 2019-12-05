package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author leopoldmols
 */

public class Game implements Model{
    
    private final Board board;
    private Player current;
    private Player oponent;
    
    public Game()
    {
        this.board = new Board();
        this.current = new Player(Color.WHITE);
        this.oponent = new Player(Color.BLACK);
        
    }
    
    @Override
    public void initialize()
    {
        this.board.initialize();
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
    public boolean isOver()
    {
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[i].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == Color.EMPTY)
                {
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
        //initialize();
        return this.board.getBoard();
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
     * Change of current player
     */
    @Override
    public void changePlayer()
    {
        changePlayerDefensive();
    }
    
    /**
     * Defensive copy of the moethod changePlayer
     */
    private void changePlayerDefensive()
    {
        Player tmp;
        tmp = oponent;
        oponent = current;
        current = tmp;
    }
    
    /**
     * gets the score of the White player
     * 
     * @param color The color of the player that has to know its score
     * 
     * @return the score of the White player
     */
    @Override
    public int getScore (Color color)
    {
        int cpt = 0;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[0].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == color)
                {
                    cpt++;
                }
            }
        }
        return cpt;
    }
    
    @Override
    public void play (Position position)
    {
        Objects.requireNonNull(position, "La position est vide !");
        if (!this.board.isInside(position))
        {
            throw new IllegalArgumentException("sout du play La position n'est pas dans le tableau ! ");
        }
        if (!this.board.isFree(position))
        {
            throw new IllegalArgumentException("sout du play La position n'est pas libre ! ");
        }
        if (canPlay(position))
        {
            this.board.addPiece(current, position);
            for (Direction dir : Direction.values())
            {
                Position pos = position.next(dir);
                Position posFin = pos.next(dir);
                do
                {
                    posFin = posFin.next(dir);
                } while (this.board.isInside(posFin)
                        && !this.board.isFree(posFin)
                        && !isMyOwn(posFin, this.current.getColor()));
                //System.out.println("Verification du play " + dir.toString() + " " + canFlip(position, dir));
                if (canFlip(position, dir))
                {
                    while (this.board.isInside(pos)
                            && !this.board.isFree(pos)
                            && !isMyOwn(pos, current.getColor())
                            /*&& this.board.isInside(posFin)
                            && !isMyOwn(posFin, this.current.getColor())*/)
                    {
                        this.board.getPiece(pos).invert();
                        pos = pos.next(dir);
                    }
                }
            }
            changePlayer();
        }
        else
        {
            throw new IllegalArgumentException("Le joueur ne peut pas placer de pion sur cette case !");
        }
    }
    
    private boolean canPlay (Position position)
    {
        Objects.requireNonNull(position, "La position est vide !");
        if (!this.board.isInside(position))
        {
            throw new IllegalArgumentException("can play La position n'est pas dans le tableau !");
        }
        if (!this.board.isFree(position))
        {
            return false;
        }
        //Position posFin = position;
        for (Direction dir : Direction.values())
        {
            if (canFlip(position, dir))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean canFlip (Position position, Direction direction)
    {
        Objects.requireNonNull(position, "La position est vide !");
        Objects.requireNonNull(direction, "La direction n'exite pas !");
        if (!this.board.isInside(position))
        {
            throw new IllegalArgumentException("can Play La position n'est pas dans le tableau !");
        }
        Position pos = new Position(position);
        Position posFin = position;
        do
        {
            posFin = posFin.next(direction);
        } while (this.board.isInside(posFin)
                && !this.board.isFree(posFin)
                && !isMyOwn(posFin, this.current.getColor()));
        do
        {
            pos = pos.next(direction);
        } while (this.board.isInside(pos)
                && !this.board.isFree(pos)
                && isMyOwn(pos, this.current.getColor()));
        return this.board.isInside(pos)
                && this.board.isInside(posFin)
                && this.board.isInside(position.next(direction))
                && !isMyOwn(position.next(direction), this.current.getColor())
                && !this.board.isFree(pos)
                && !isMyOwn(pos, this.current.getColor())
                && !this.board.isFree(posFin)
                && isMyOwn(posFin, this.current.getColor());
    }
    
    
    
    
    
    /**
     * Verifies if the piece that stands on a square on the playing board the playing board has the same color than a color
     * @param position where the method has to verify if there's a piece on it and if well, if it has the same color than the second parameter
     * @param color the color that has to be compared to the piece on the position given as first parameter
     * @return true if the piece has the same color than the color given in the parameters and true either
     * 
     * This metho throws a NullPointerException("La position n'existe pas !") if the piece doesn't exist
     * This throws a new IllegalStateException("La position ne fait pas partie du tableau de jeu !") if the position is not inside the playing board
     */
    private boolean isMyOwn(Position position, Color color)
    {
        Objects.requireNonNull(position, "La position n'existe pas !");
        if (!this.board.isInside(position))
        {
            throw new IllegalStateException("Game : isMyOwn : La position ne fait pas partie du tableau de jeu !");
        }
        /*if (this.board.isFree(position))
        {
            System.out.println("A");
            System.out.println(position);
            throw new IllegalArgumentException("La position ne contient pas de pièce !");
        }*/
        return this.board.getPiece(position).isMyOwn(color);
    }
    
    /**
     * Verifies if the player can even place a piece on the playing board
     * @return true if he can and false else
     */
    // PAS BONNE. IL NE FAUT PAS VERIFIER CELA MAIS SI LE JOUEUR PEUT PLACER UNE DE SES PIECES QQUE PART
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
     * @param position the position where to place the piece
     * @return true if he can and false else
     */
    /*@Override
    public boolean canPlace(Position position)
    {
        boolean legalPlace = false;
        if (this.board.isInside(position))
        {
            System.out.println("1");
            if (this.board.isFree(position))
            {
                System.out.println("2");
                for (Direction dir : Direction.values())
                {
                    System.out.println("3");
                    try
                    {
                        System.out.println("4");
                        System.out.println(position);
                        Position pos = position.next(dir);
                        System.out.println(pos);
                        System.out.println("isinside " + this.board.isInside(pos));
                        System.out.println("isfree " + this.board.isFree(pos));
                        System.out.println("W");
                        System.out.println("Piececolor " + this.board.getPiece(pos).getColor());
                        System.out.println("Y");
                        System.out.println("ennemyColor " + this.current.getColor().invert());
                        System.out.println("X");
                        if (this.board.isInside(pos)
                                && !this.board.isFree(pos)
                                && this.board.getPiece(pos).getColor() == this.current.getColor().invert())
                        {
                            System.out.println("5");
                            Position next = pos.next(dir);
                            while (!legalPlace
                                    && this.board.isInside(next)
                                    && !this.board.isFree(next))
                            {
                                System.out.println("6");
                                if (this.board.getPiece(next).getColor() == this.current.getColor())
                                {
                                    System.out.println("7");
                                    legalPlace = true;
                                }
                                next = next.next(dir);
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("8");
                    }
                }
            }
            return legalPlace;
        }
        else
        {
            System.out.println("9");
            throw new IllegalArgumentException("Vous ne pouvez pas placer de piece à cet endroit !");
        }
    }*/

    /**
     * Place a piece at a certain position
     * @param position the position where to place the piece
     */
    /*@Override
    public void place(Position position)
    {
        if (!this.canPlace(position))
        {
            throw new IllegalArgumentException("Vous ne pouvez pas placer de pièce à cet endroit !");
        }
        System.out.println("A");
        this.board.getPiece(position).setColor(current.getColor());
        for (Direction dir : Direction.values())
        {
            System.out.println("B");
            try
            {
                System.out.println("C");
                Position pos = position.next(dir);
                if (this.board.isInside(pos)
                        && !this.board.isFree(pos)
                        && this.isMyOwn(pos, this.oponent.getColor()))
                {
                    System.out.println("D");
                    Position next = pos.next(dir);
                    LinkedList<Position> previousPos = new LinkedList<>();
                    previousPos.add(pos);
                    boolean endPreviousPos = false;
                    while (!endPreviousPos
                            && this.board.isInside(next)
                            && !this.board.isFree(next))
                    {
                        System.out.println("E");
                        if (this.board.getPiece(next).getColor() == this.current.getColor())
                        {
                            System.out.println("F");
                            System.out.println(previousPos.size());
                            previousPos.forEach(prevPos -> {
                                System.out.println("Foreach");
                                System.out.println(pos);
                                System.out.println(this.board.getPiece(prevPos).getColor());
                                this.board.getPiece(prevPos).invert();
                                System.out.println(this.board.getPiece(prevPos).getColor());
                            });
                            endPreviousPos = true;
                        }
                        else
                        {
                            System.out.println("G");
                            previousPos.add(next);
                            next = next.next(dir);
                        }
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("H");
            }
        }
        
    }*/