package Models;

import java.util.LinkedList;

/**
 * This class initialize a game board to welcome the Pieces to play It also
 * halps the other classes to know all the information that directly concerns
 * the playing board and its contained pieces, like if a piece is inside the
 * playing board or not
 *
 * @author leopoldmols
 */
public class Board /* implements Model */
{

    /**
     * The initial board
     */
    private final Piece[][] board;

    /**
     * This constructs the object Board with the parameter "board" received as
     * class parameter
     */
    public Board()
    {
        this.board = new Piece[8][8];
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                this.board[i][j] = new Piece(Color.EMPTY);
            }
        }
    }

    public void initialize()
    {

        board[3][3].setColor(Color.WHITE);
        board[3][4].setColor(Color.BLACK);
        board[4][4].setColor(Color.WHITE);
        board[4][3].setColor(Color.BLACK);

    }

    /**
     * This method helps the other class to be able to access to the value of
     * the playing board. This get the value of the variable "board"
     *
     * @return board that returns the dimensions of the playing board
     */
    public Piece[][] getBoard()
    {
        // MAUVAIS ! Il faut utiliser des méthodes qui existent dans l'API java pour les tableaux
        return board;
    }

    /**
     * Adds a piece on the playing board
     *
     * @param player the player that wants to add a piece
     * @param pos the position where to add the piece
     */
    public void addPiece(Player player, Position pos)
    {
        this.board[pos.getRow()][pos.getColumn()].setColor(player.getColor());
    }

    /**
     * Verifies if the square of position received as parameters contains any
     * piece or not
     *
     * @param pos the position in which the method has to verify if any piece
     * stays or not
     * @return true if the square at the position is free of piece and false
     * either
     *
     * throws an IllegalArgumentException("La position ne fait pas partie du tableau de jeu !")
     * if the position is outside the board
     */
    public boolean isFree(Position pos)
    {
        if (!isInside(pos))
        {
            throw new IllegalArgumentException("La position ne fait pas partie du tableau de jeu !");
        }
        return this.board[pos.getRow()][pos.getColumn()].getColor() == Color.EMPTY;
    }
    
    /**
     * Boolean method that returns true if the position given in the parameters
     * is contained in the playing board and false either
     *
     * @param pos the position given by the methods that calls this one to be
     * able to know if the following is contained by the playing board or not
     * @return true if the position given in the parameters is contained by the
     * playing board, and false if not
     */
    public boolean isInside(Position pos)
    {
        return pos.getColumn() >= 0
                && pos.getColumn() <= this.board.length
                && pos.getRow() >= 0
                && pos.getRow() <= this.board[0].length;
    }
    
    /**
     * Shows the caracteristics of the object "Piece" that stands on the
     * position given as parameters
     *
     * @param pos the position where the piece has to be returned
     * @return the piece that stands on the position given as paramters
     *
     * This throws a new ArrayIndexOutOfBoundsException("La position ne fait pas
     * partie du tableau de jeu !") if the position is not insiade the playing
     * board
     */
    public Piece getPiece(Position pos)
    {
        if (isFree(pos)
                || isInside(pos))
        {
            throw new ArrayIndexOutOfBoundsException("La position n'est pas dans le tableau ou est vide !");
        }
        return this.board[pos.getRow()][pos.getColumn()];
    }
}

    /**
     * Verifies if a position can welcome a piece or not
     *
     * @param pos the position where a piece should come
     * @param piece the piece that has to come
     * @return true if the position can welcome a piece with the current color
     * and false else
     */
    /*public boolean positionable(Position pos, Piece piece) {
        if (pos.getRow() == 0) {
            if (pos.getColumn() == 0) {
                return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                        && board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY)
                        || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                        && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                        || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                        && board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY));
            } else if (pos.getColumn() == 7) {
                return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                        && board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY)
                        || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                        && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                        || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                        && board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY));
            }
            return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY)
                    || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY));
        } else if (pos.getRow() == 7) {
            if (pos.getColumn() == 0) {
                return ((board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                        && board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY)
                        || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                        && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                        || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                        && board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY));
            } else if (pos.getColumn() == 7) {
                return ((board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                        && board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY)
                        || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                        && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                        || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                        && board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY));
            }
            return ((board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY));
        }
        if (pos.getColumn() == 0) {
            return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY)
                    || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY));
        }
        if (pos.getColumn() == 7) {
            return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY)
                    || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                    || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                    && board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY));
        }
        return ((board[pos.getRow() + 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                || (board[pos.getRow()][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != Color.EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn()].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY)
                || (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                || (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != Color.EMPTY)
                || (board[pos.getRow()][pos.getColumn() - 1].getColor() != piece.getColor()
                && board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY));
    }*/
    
    
    /*public boolean verifDirection(Position pos, Piece piece)
    {
        LinkedList<Piece> pieceList = new LinkedList<>();
        LinkedList<Piece> flippableList = new LinkedList<>();
        LinkedList<Position> posToFlip = new LinkedList<>();
        for (Direction dir1 : Direction.values())
        {
            posToFlip.clear();
            Position pos1 = new Position(pos.getRow() + dir1.getRow(), pos.getColumn() + dir1.getColumn());
            if (isInside(pos1))
            {
                if (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY
                        && board[pos1.getRow()][pos1.getColumn()].getColor() != null
                        && board[pos1.getRow()][pos1.getColumn()].getColor() != piece.getColor())
                {
                    while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY
                            && board[pos1.getRow()][pos1.getColumn()].getColor() != null
                            && board[pos1.getRow()][pos1.getColumn()].getColor() != piece.getColor()
                            && isInside(pos1))
                    {

                        pos1.setRow(pos1.getRow() + dir1.getRow());
                        pos1.setColumn(pos1.getColumn() + dir1.getColumn());
                        pieceList.add(board[pos1.getRow()][pos1.getColumn()]);
                        posToFlip.add(pos1);
                        System.out.println(pos1.toString() + "0");
                    }
                    System.out.println(posToFlip.toString());
                    flip(positionsToFlip(dir1, pos1));
                }
            }
        }
        for (int i = 0; i < pieceList.size(); i++)
        {
            if (pieceList.get(i).getColor() != piece.getColor())
            {
                flippableList.add(pieceList.get(i));
            }
        }
        return pieceList.get(0).getColor() != Color.EMPTY
                && pieceList.get(0).getColor() != piece.getColor()
                && pieceList.get(flippableList.lastIndexOf(piece) + 1).getColor() == piece.getColor();
    }*/
    
    

    /**
     * Flips the color of each piece that stands between the one that we put and
     * the one on the other side
     *
     * @param list the list of Positions to flip
     */
    /*public void flip(LinkedList<Position> list)
    {
        for (int i = 0; i < list.size(); i++) {
            board[list.get(i).getRow()][list.get(i).getColumn()].invert();
        }
    }*/
    
    
    
    /*public void dirsToFlip (Position position)
    {
        //LinkedList<Direction> flipableDirs = new LinkedList<>();
        LinkedList<LinkedList<Position>> listOfDirectionOfListOfPiecesToFlip = new LinkedList<>();
        for (Direction dir : Direction.values())
        {
            LinkedList<Position> listAFlip = new LinkedList<>();
            Position next = position.next(dir);
            System.out.println(isInside(next));
            System.out.println(board[next.getRow()][next.getColumn()].getColor() != Color.EMPTY);
            System.out.println(!isMyOwn(next, board[position.getRow()][position.getColumn()].getColor()));
            if (isInside(next)
                    && board[next.getRow()][next.getColumn()].getColor() != Color.EMPTY
                    && !isMyOwn(next, board[position.getRow()][position.getColumn()].getColor()))
            {
                System.out.println(listOfDirectionOfListOfPiecesToFlip.toString());
                //listOfDirectionOfListOfPiecesToFlip.add(listPiecesToFlip(listPieces(dir, next)));
                // Faire appel à la méthode qui renverra une liste de pieces dont la couleur de la dernière différera de la couleur des autres.
                // si elle est vide, passer à la direction suivante
                //      donc, si elle n'est pas vide, s'occuper de la direction
                //flipableDirs.add(dir);
                listAFlip = listPieces(dir, position);
            }
            flipB(listAFlip);
        }
        System.out.println(listOfDirectionOfListOfPiecesToFlip.toString());
        
    }
    
    public void flipB(LinkedList<Position> listPosToFlip)
    {
        for (int i = 0; i < listPosToFlip.size(); i++)
        {
            board[listPosToFlip.get(i).getColumn()][listPosToFlip.get(i).getRow()].invert();
        }
    }*/
    
    
    
    /**
     * Makes a list of directions belonging a position and a color
     *
     * @param pos the position around which it has to add the differnet
     * directions
     * @param color the color of the piece around which it has to add the
     * differnet directions
     * @return the list of directions
     */
    /*public LinkedList<Direction> listDirection(Position pos, Color color) {
        LinkedList<Direction> listDir = new LinkedList<>();
        for (Direction dir : Direction.values()) {
            if (board[pos.getRow()][pos.getColumn()].getColor() != color) {
                listDir.add(dir);
            }
        }
        return listDir;
    }

    public void flipPos(LinkedList<LinkedList<Piece>> listDirsOfPieceToFlip) {
        for (int i = 0; i < listDirsOfPieceToFlip.size(); i++) {
            for (int j = 0; j < listDirsOfPieceToFlip.get(i).size(); j++) {

            }
        }
    }

    public LinkedList<Position> listPieces(Direction direction, Position position) {
        LinkedList<Position> piToFlip = new LinkedList<>();

        while (isInside(position)
                && board[position.getRow()][position.getColumn()].getColor() != Color.EMPTY) {
            for (Direction dir : Direction.values()) {
                piToFlip.add(position);
                position.setRow(position.getRow() + direction.getRow());
                position.setColumn(position.getColumn() + direction.getColumn());
            }
        }
        System.out.println("-1" + piToFlip.toString());
        return piToFlip;
    }
    
    public LinkedList<Position> listPiecesToFlip(LinkedList<Position> listToGoFlipable)
    {
        LinkedList<Position> flippingList = new LinkedList<>();
        for (int i = 0; i < listToGoFlipable.size(); i++)
        {
            if (board[listToGoFlipable.get(i).getRow()][listToGoFlipable.get(i).getColumn()].getColor() == board[listToGoFlipable.get(listToGoFlipable.size() - 1).getRow()][listToGoFlipable.get(listToGoFlipable.size() - 1).getColumn()].getColor())
            {
                System.out.println("1" + flippingList.toString());
                for (int j = 1; j < listToGoFlipable.size(); j++)
                {
                    System.out.println("2" + flippingList.toString());
                    if (board[listToGoFlipable.get(i).getRow()][listToGoFlipable.get(i).getColumn()].getColor() != board[listToGoFlipable.get(listToGoFlipable.size() - 1).getRow()][listToGoFlipable.get(listToGoFlipable.size() - 1).getColumn()].getColor())
                    {
                        flippingList.add(listToGoFlipable.get(j));
                        System.out.println("3" + flippingList.toString());
                    }
                    System.out.println("4" + flippingList.toString());
                }
            }
        }
        System.out.println("5" + flippingList.toString());
        return flippingList;
    }

    
    public LinkedList<Position> positionsToFlip(Direction dir, Position position) {
        LinkedList<Position> piToFlip = new LinkedList<>();
        Position pos = new Position(position.getRow(), position.getColumn());
        Position nextPos = new Position(pos.getRow() + dir.getRow(), pos.getColumn() + dir.getColumn());
        while (isInside(nextPos)
                && isInside(pos)
                && board[nextPos.getRow()][nextPos.getColumn()].getColor() != Color.EMPTY
                && board[nextPos.getRow()][nextPos.getColumn()].getColor() != board[position.getRow()][position.getColumn()].getColor()) {
            piToFlip.add(nextPos);
            pos.setRow(nextPos.getRow());
            pos.setColumn(nextPos.getColumn());
            nextPos.setRow(nextPos.getRow() + dir.getRow());
            nextPos.setColumn(nextPos.getColumn() + dir.getColumn());
        }
        return piToFlip;
    }*/
