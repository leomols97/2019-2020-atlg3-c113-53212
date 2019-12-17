package Models;

import GuiFx.BotLevel1;
import java.util.*;


/**
 * This class rules all the game thanks to the objects of the other classes
 * 
 * @author leopoldmols
 */
public class Game implements Observable, Model
{
    /**
     * @Board the playong board of the game
     * @current the current player
     * @oponent the oponent player
     */
    private int id;
    private Board board;
    private Position selected;
    private Player current;
    private Player oponent;
    private final List<Observer> observers;
    private final List<Tour> tours;
    
    
    /**
     * Constructs the game by creating a new playing board,
     * a new current player
     * and a new oponent player
     * @param bot
     */
    public Game(boolean bot)
    {
        this.current = new Player(Color.BLACK);
        if (bot)
        {
            this.oponent = new BotLevel1(Color.WHITE);
        }
        else
        {
            this.oponent = new Player(Color.WHITE);
        }
        this.observers = new ArrayList<>();
        this.tours = new ArrayList<>();
        this.tours.add(new Tour(id, this.current.getName(), Action.NOUVELLE_PARTIE, 0, 0, 0));
        id++;
    }
    
    
    /**
     * Initiates the board by calling the method "initialize()" in the Board class
     */
    @Override
    public void initialize()
    {
        this.id = 0;
        this.board = new Board();
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
        System.out.println(Arrays.toString(board.getBoard()));
    }
    
    
    /**
     * Overrides the method "isOver()" that comes from the class Model.
     * Verifies if both players have moves left and if both of them still have their own flags
     *
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
        return this.board.getBoard();
    }
    
    
    /**
     * Gets the piece that stands at a cerrtain position
     * 
     * @param pos the position wherre the piece stands
     * 
     * @return the piece
     */
    public Piece getPiece(Position pos)
    {
        if (!this.board.isInside(pos))
        {
            throw new IllegalArgumentException("la position ne fait pas partie du tableau !");
        }
        if (isFree(pos))
        {
            throw new IllegalArgumentException("La position ne contient pas de pièce !");
        }
        return this.board.getPiece(pos);
    }
    
    
    /**
     * Tells if a position is free or not
     * 
     * @param pos the position to verify
     * 
     * @return true if the position is free and false else
     */
    @Override
    public boolean isFree(Position pos)
    {
        if (!this.board.isInside(pos))
        {
            throw new IllegalArgumentException("la position ne fait pas partie du tableau !");
        }
        return this.board.isFree(pos);
    }
    
    
    /**
     * Gets the current player
     * @return the current player
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
        Player tmp;
        tmp = oponent;
        oponent = current;
        current = tmp;
        if (current instanceof BotLevel1)
        {
            ((BotLevel1) current).play(selected, this);
        }
    }
    
    
    /**
     * Gets the score of the White player
     * 
     * @param color The color of the player that has to know its score
     * 
     * @return the score of the White player
     */
    @Override
    public int getScoreBLACK (Color color)
    {
        int cpt = 0;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[0].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == color)
                {
                    if (board.getBoard()[i][j].getColor() == Color.BONUSBLACK)
                    {
                        cpt += 3;
                    }
                    else if (board.getBoard()[i][j].getColor() == Color.BLACK)
                    {
                        cpt++;
                    }
                }
            }
        }
        return cpt;
    }
    
    
    /**
     * Gets the score of the White player
     * 
     * @param color The color of the player that has to know its score
     * 
     * @return the score of the White player
     */
    @Override
    public int getScoreWHITE (Color color)
    {
        int cpt = 0;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[0].length; j++)
            {
                if (board.getBoard()[i][j].getColor() == color)
                {
                    if (board.getBoard()[i][j].getColor() == Color.BONUSWHITE)
                    {
                        cpt += 3;
                    }
                    else if (board.getBoard()[i][j].getColor() == Color.WHITE)
                    {
                        cpt++;
                    }
                }
            }
        }
        return cpt;
    }
    
    
    /**
     * Makes the current player play at a certain position and flips the flippable pieces
     * 
     * @param position the position where the current player wants to put a piece
     */
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
            throw new IllegalArgumentException("La position n'est pas libre ! ");
        }
        
        /*if (!hasStrikes(current.getColor()))
        {
            changePlayer();
        }*/
        
        if (!canPlay(position))
        {
            changePlayer();
        }
        System.out.println(nbPiecesGot(position, getCurrent().getColor()));
        if (!onlyOneColor(getCurrent().getColor()))
        {
            if (canPlay(position))
            {
                this.selected = position;
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
                    
                    if (canFlip(position, dir))
                    {
                        while (this.board.isInside(pos)
                                && !this.board.isFree(pos)
                                && !isMyOwn(pos, current.getColor()))
                        {
                            this.board.getPiece(pos).invert();
                            pos = pos.next(dir);
                        }
                    }
                }
            }
            else
            {
                throw new IllegalArgumentException("Le joueur ne peut pas placer de pion sur cette case !");
            }
            changePlayer();
            // Place a row in the table with the information about the strike that the player played
            placePieceRowTable();
            notifyObservers();
        }
        else
        {
            throw new IllegalArgumentException("Il n'y a plus qu'une seule couleur sur le plateau de jeu !");
        }
    }
    
    
    /**
     * Verifies if the current player can play at a certain position by verifying if at least a direction has flippable pieces
     * 
     * @param position the position where the player wants to put a new piece
     * 
     * @return true if the player can play and false else
     */
    @Override
    public boolean canPlay (Position position)
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
        
        for (Direction dir : Direction.values())
        {
            if (canFlip(position, dir))
            {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Verifies if a certain direction contains flippable pieces belonging a certain position
     * 
     * @param position the position where a new piece should be put
     * @param direction the direction to verify if it contains flippable pieces
     * 
     * @return true of the direction contains flippable pieces
     */
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
     * Looks for the playable positions
     * 
     * @param position the position where to pu a piece
     * 
     * @return a list of positions
     */
    @Override
    public List<Position> possiblePositions (Position position)
    {
        List<Position> list = new ArrayList<>();
        Position pos;
        for (int i = 0; i < this.board.getBoard().length; i++)
        {
            for (int j = 0; j < this.board.getBoard()[i].length; j++)
            {
                pos = new Position(i, j);
                if (canPlay(pos))
                {
                    list.add(pos);
                }
            }
        }
        return list;
    }
    
    
    /**
     * Verifies if a piece standing at a certain position has the came color than a certain color
     * 
     * @param position where the method has to verify if there's a piece on it and if well, if it has the same color than the second parameter
     * @param color the color that has to be compared to the piece on the position given as first parameter
     * 
     * @return true if the piece has the same color than the color given as the second parameter and true either
     * 
     * This method throws a NullPointerException("La position n'existe pas !") if the piece doesn't exist
     * This throws a new IllegalStateException("La position ne fait pas partie du tableau de jeu !") if the position is not inside the playing board
     */
    private boolean isMyOwn(Position position, Color color)
    {
        Objects.requireNonNull(position, "La position n'existe pas !");
        if (!this.board.isInside(position))
        {
            throw new IllegalStateException("La position ne fait pas partie du tableau de jeu !");
        }
        return this.board.getPiece(position).isMyOwn(color);
    }
    
    
    /**
     * Verifies if the player can even place a piece somewhere on the playing board
     * 
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
     * Adds an observer in the observer list
     * 
     * @param obs the observer to add
     */
    @Override
    public void registerObserver(Observer obs)
    {
        this.observers.add(obs);
    }
    
    
    /**
     * Remove an observer from the observer list
     * 
     * @param obs the observer to remove
     */
    @Override
    public void removeObserver(Observer obs)
    {
        this.observers.remove(obs);
    }
    
    
    /**
     * Calls each method update()
     * from each observer from the observer list
     */
    @Override
    public void notifyObservers()
    {
        for (int i = 0; i < this.observers.size(); i++)
        {
            this.observers.get(i).update();
        }
    }
    
    
    /**
     * Counts the number of white piece on the playing board
     * 
     * @return the number of white pieces that stands on the board
     */
    @Override
    public int getNbWhites ()
    {
        int nbWhites = 0;
        Position pos;
        for (int i = 0; i < this.getBoard().length; i++)
        {
            for (int j = 0; j < this.getBoard()[i].length; j++)
            {
                pos = new Position(i, j);
                if (!isFree(pos)
                        && this.getPiece(pos).getColor() == Color.WHITE)
                {
                    nbWhites++;
                }
            }
        }
        return nbWhites;
    }
    
    
    /**
     * Counts the number of white piece on the playing board
     * 
     * @return the number of white pieces that stands on the board
     */
    @Override
    public int getNbBlacks ()
    {
        int nbBlack = 0;
        Position pos;
        for (int i = 0; i < this.getBoard().length; i++)
        {
            for (int j = 0; j < this.getBoard()[i].length; j++)
            {
                pos = new Position(i, j);
                if (!isFree(pos)
                        && this.getPiece(pos).getColor() == Color.BLACK)
                {
                    nbBlack++;
                }
            }
        }
        return nbBlack;
    }
    
    
    /**
     * Counts the number of pieces that stands on the playing board
     * 
     * @return the number of pieces that stands on the playing board
     */
    @Override
    public double getNbPieces ()
    {
        double nbPieces = 0;
        Position pos;
        for (int i = 0; i < this.getBoard().length; i++)
        {
            for (int j = 0; j < this.getBoard()[i].length; j++)
            {
                pos = new Position(i, j);
                if (!isFree(pos)
                        && this.getPiece(pos).getColor() != Color.EMPTY)
                {
                    nbPieces++;
                }
            }
        }
        return nbPieces;
    }
    
    
    /**
     * Count the number of squares that compose the playing board
     * 
     * @return the number of squares that compose on the playing board
     */
    @Override
    public double getNbCases ()
    {
        double nbCases = 0;
        for (int i = 0; i < this.getBoard().length; i++)
        {
            for (int j = 0; j < this.getBoard()[i].length; j++)
            {
                nbCases++;
            }
        }
        return nbCases;
    }
    
    
    /**
     * Verifies if a player has strikes left
     * 
     * @param color the color of the player
     * that the method has to verify if he has strikes left or not
     * 
     * @return true if he has at least one strike left and false else
     */
    @Override
    public boolean hasStrikes (Color color)
    {
        Position pos;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[i].length; j++)
            {
                pos = new Position(i, j);
                if (canPlay(pos)) 
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    /**
     * Verifies if there's only one color on the playing board
     * 
     * @param color the color to verify
     * 
     * @return true if there's only this color on the playing board and false else
     */
    @Override
    public boolean onlyOneColor (Color color)
    {
        Position pos;
        for (int i = 0; i < board.getBoard().length; i++)
        {
            for (int j = 0; j < board.getBoard()[i].length; j++)
            {
                pos = new Position(i, j);
                if (board.getPiece(pos).getColor() != color) 
                {
                    return false;
                }
            }
        }
        return true;
    }

    
    /**
     * Gets the strike done by a player
     * 
     * @return a list of every strikes
     */
    @Override
    public List<Tour> getTours ()
    {
        return tours;
    }
    
    
    /**
     * Adds to the table the informations about a turn when the player puts a piece
     */
    @Override
    public void placePieceRowTable ()
    {
        this.tours.add(
                new Tour(id, 
                        this.current.getName(),
                        Action.PLACE_PIECE,
                        this.selected.getColumn() + 1,
                        this.selected.getRow() + 1,
                        nbPiecesGot(
                                selected,
                                getCurrent().getColor()
                        )
                )
        );
        id++;
    }
    
    
    /**
     * Adds to the table a row when the player passed his turn
     */
    @Override
    public void passRowTable ()
    {
        this.tours.add(
                new Tour(
                        id,
                        this.current.getName(),
                        Action.PASSE_TOUR,
                        0,
                        0,
                        nbPiecesGot(
                                selected,
                                getCurrent().getColor()
                        )
                )
        );
        id++;
    }

    
    /**
     * Gets the oponent player
     * 
     * @return the oponent player
     */
    @Override
    public Player getOponent()
    {
        return oponent;
    }
    
    
    /**
     * Counts the number of pieces that the turn will flip
     * 
     * @param position the position where the player will play
     * @param color the color of the player
     * 
     * @return the number of pieces that will be flipped
     */
    @Override
    public int nbPiecesGot (Position position, Color color)
    {
        int cptFlippablePieces = 0;
        if (canPlay(position))
        {
            for (Direction dir : Direction.values())
            {
                if (canFlip(position, dir))
                {
                    Position next = position.next(dir);
                    while (getBoard()[next.getRow()][next.getColumn()].getColor() != color)
                    {
                        next = next.next(dir);
                        cptFlippablePieces++;
                    }
                }
            }
        }
        return cptFlippablePieces;
    }

    @Override
    public boolean isBonusCase(Position position)
    {
        return this.board.getBoard()[position.getRow()][position.getColumn()].getColor() == Color.BONUS;
    }
}
















// La suite ne contient que des méthodes en commentaire





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







//JUSTE POUR LE FUN


/**
     * Verifies if a position can welcome a piece or not
     * 
     * @param pos the position where a piece should come
     * @param piece the piece that has to come
     * @return true if the position can welcome a piece with the current color and false else
     */

    /*
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
*/