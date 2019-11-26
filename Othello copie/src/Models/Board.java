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
public class Board /* implements Model */ {

    /**
     * The initial board
     */
    private final Piece[][] board;

    /**
     * This constructs the object Board with the parameter "board" received as
     * class parameter
     */
    public Board() {
        this.board = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            
            for(int j = 0; j < 8; j++) {

                this.board[i][j] = new Piece(Color.EMPTY);
                
            }
            
        }
    }

    public void initialize() {

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
    public Piece[][] getBoard() {
        // MAUVAIS ! Il faut utiliser des méthodes qui existent dans l'API java pour les tableaux
        return board;
    }

    public Piece getPiece(int row, int column) {
        return null;
    }

    /**
     * Adds a piece on the playing board
     *
     * @param piece the piece to add
     * @param pos the position where to add the piece
     */
    public void addPiece(Piece piece, Position pos) {
        this.board[pos.getRow()][pos.getColumn()].setColor(piece.getColor());
    }

    /**
     * Verifies if the game is over or not
     *
     * @return true of the game is over and false else
     */
    public boolean isOver() {
        for (Piece[] board1 : board) {
            for (Piece board11 : board1) {
                if (board11.getColor() == Color.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    public boolean flippable ()
    {
        
    }*/

    /**
     * Verifies if a position can welcome a piece or not
     *
     * @param pos the position where a piece should come
     * @param piece the piece that has to come
     * @return true if the position can welcome a piece with the current color
     * and false else
     */
    public boolean positionable(Position pos, Piece piece) {
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
    }

    /**
     * Makes a list of directions belonging a position and a color
     *
     * @param pos the position around which it has to add the differnet
     * directions
     * @param color the color of the piece around which it has to add the
     * differnet directions
     * @return the list of directions
     */
    public LinkedList<Direction> listDirection(Position pos, Color color) {
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
            /*
            piToFlip.add(board[position.getRow()][position.getColumn()]);
            position.setRow(position.getRow() + direction.getRow());
            position.setColumn(position.getColumn() + direction.getColumn());
             */
        }
        System.out.println("-1" + piToFlip.toString());
        return piToFlip;
    }

    public LinkedList<Position> listPiecesToFlip(LinkedList<Position> listToGoFlipable) {
        LinkedList<Position> flippingList = new LinkedList<>();
        for (int i = 0; i < listToGoFlipable.size(); i++) {
            //if (listToGoFlipable.get(0).getColor() == listToGoFlipable.get(listToGoFlipable.size() - 1).getColor())
            if (board[listToGoFlipable.get(i).getRow()][listToGoFlipable.get(i).getColumn()].getColor() == board[listToGoFlipable.get(listToGoFlipable.size() - 1).getRow()][listToGoFlipable.get(listToGoFlipable.size() - 1).getColumn()].getColor()) {
                /*System.out.println("0" + flippingList.toString());
                return flippingList;
                } else*/
                System.out.println("1" + flippingList.toString());
                for (int j = 1; j < listToGoFlipable.size(); j++) {
                    System.out.println("2" + flippingList.toString());
                    if (board[listToGoFlipable.get(i).getRow()][listToGoFlipable.get(i).getColumn()].getColor() != board[listToGoFlipable.get(listToGoFlipable.size() - 1).getRow()][listToGoFlipable.get(listToGoFlipable.size() - 1).getColumn()].getColor()) {
                        flippingList.add(listToGoFlipable.get(j));
                        System.out.println("3" + flippingList.toString());
                    }
                    /*else
                    {
                    System.out.println("4" + flippingList.toString());
                    flippingList.add(listToGoFlipable.get(j));
                    }*/
                    System.out.println("4" + flippingList.toString());
                }
            }
        }
        System.out.println("5" + flippingList.toString());
        return flippingList;
    }

    /*
    public void dirsToFlip (Position position)
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
     */

    public void flipB(LinkedList<Position> listPosToFlip/*LinkedList<LinkedList<Position>> listDirOfListPiecesToFlip*/ /*, Position position*/) {
        //listDirOfListPiecesToFlip = dirsToFlip(position);
        for (int i = 0; i < listPosToFlip.size(); i++) {
            //listPiecesToFlip(directionsToFlip.get(i));
            /*for (int j = 0; j < dirsToFlip.get(i).size(); j++) {
                Direction get = dirsToFlip.get(j);
            }*/
            //for (int j = 0; j < listDirOfListPiecesToFlip.get(i).size(); j++) {
            board[listPosToFlip.get(i).getColumn()][listPosToFlip.get(i).getRow()].invert();
            //}
            //board[directionsToFlip.get(i).getRow()][directionsToFlip.get(i).getColumn()].invert();
        }
    }

    /*
    
    
     */
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
    }

    /**
     * Flips the color of each piece that stands between the one that we put and
     * the one on the other side
     *
     * @param list the list of Positions to flip
     * @param direction the direction where to flip the pieces
     * @param pos the position where to put the new piece
     * @param piece the piece to put
     */
    public void flip(/*Direction direction,*/ /*Position pos, Piece piece,*/LinkedList<Position> list) {
        //LinkedList<Direction> dirList = new LinkedList<>();
        /*LinkedList<Piece> pieceList = new LinkedList<>();
        for (Direction dir1 : Direction.values())
        {
            Position pos1 = new Position(pos.getRow() + dir1.getRow(), pos.getColumn() + dir1.getColumn());
            if (isInside(pos1))
            {
                if (pieceList.get(0).getColor() == piece.getColor() || pieceList.get(0).getColor() != Color.EMPTY)
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
                            dir1.setRow(pos.getRow() + dir1.getRow());
                            dir1.setColumn(pos.getColumn() + dir1.getColumn());
                            pieceList.add(board[dir1.getRow()][dir1.getColumn()]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < pieceList.size(); i++) {
            pieceList.get(i).setColor(piece.getColor());
        }
         */
        for (int i = 0; i < list.size(); i++) {
            board[list.get(i).getRow()][list.get(i).getColumn()].invert();
        }
    }

    public boolean verifDirection(/*Direction direction,*/Position pos, Piece piece) {
        //Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> pieceList = new LinkedList<>();
        //LinkedList<Direction> dirList = new LinkedList<>();
        LinkedList<Piece> flippableList = new LinkedList<>();
        LinkedList<Position> posToFlip = new LinkedList<>();
        for (Direction dir1 : Direction.values()) {
            posToFlip.clear();
            Position pos1 = new Position(pos.getRow() + dir1.getRow(), pos.getColumn() + dir1.getColumn());
            if (isInside(pos1)) {
                if (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY
                        && board[pos1.getRow()][pos1.getColumn()].getColor() != null
                        && board[pos1.getRow()][pos1.getColumn()].getColor() != piece.getColor()) {
                    while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY
                            && board[pos1.getRow()][pos1.getColumn()].getColor() != null
                            && board[pos1.getRow()][pos1.getColumn()].getColor() != piece.getColor()
                            && isInside(pos1)) {
                        /*dir1.setRow(pos.getRow() + dir1.getRow());
                        dir1.setColumn(pos.getColumn() + dir1.getColumn());*/

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
        //verifDirDown(pos, piece);

        for (int i = 0; i < pieceList.size(); i++) {
            if (pieceList.get(i).getColor() != piece.getColor()) {
                flippableList.add(pieceList.get(i));
            }
        }
        return pieceList.get(0).getColor() != Color.EMPTY
                && pieceList.get(0).getColor() != piece.getColor()
                && pieceList.get(flippableList.lastIndexOf(piece) + 1).getColor() == piece.getColor();

        //return false;
    }

    /**
     * Verifies if there are some piece to "eat" in the up direction belonging
     * the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the up direction and
     * false else
     */
    public boolean verifDirUp(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow() - 1][pos.getColumn()].getColor() != Color.EMPTY && board[pos1.getRow() - 1][pos1.getColumn()].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setRow(pos1.getRow() - 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        if (list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor()) {
            return true;
        }
        return false;
    }

    /**
     * Verifies if there are some piece to "eat" in the upLeft direction
     * belonging the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the upLeft direction and
     * false else
     */
    public boolean verifDirUpLeft(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow() - 1][pos.getColumn() - 1].getColor() != Color.EMPTY && board[pos1.getRow() - 1][pos1.getColumn() - 1].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setRow(pos1.getRow() - 1);
                pos1.setColumn(pos1.getColumn() - 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();
    }

    /**
     * Verifies if there are some piece to "eat" in the upRight direction
     * belonging the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the upRight direction
     * and false else
     */
    public boolean verifDirUpRight(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow() - 1][pos.getColumn() + 1].getColor() != Color.EMPTY && board[pos1.getRow() - 1][pos1.getColumn() + 1].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setRow(pos1.getRow() - 1);
                pos1.setColumn(pos1.getColumn() + 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();
    }

    /**
     * Verifies if there are some piece to "eat" in the down direction belonging
     * the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the down direction and
     * false else
     */
    public boolean verifDirDown(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow() + 1][pos.getColumn()].getColor() != Color.EMPTY && board[pos1.getRow() + 1][pos1.getColumn()].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setRow(pos1.getRow() + 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();

        /*
        LinkedList<Position> posToFlip = new LinkedList<>();
        Position posInit = pos;
        posInit.setRow(pos.getRow() +1);
        posInit.setColumn(pos.getColumn());
        while (isInside(posInit) && board[posInit.getRow()][posInit.getColumn()].getColor()!= Color.EMPTY &&  board[posInit.getRow()][posInit.getColumn()].getColor()!= piece.getColor()){
            posToFlip.add(posInit);
            posInit.setRow(posInit.getRow()+1);
            posInit.setColumn(posInit.getColumn());
            
        }
        System.out.println(posToFlip.get(0));
        flip(posToFlip);
         */
    }

    /**
     * Verifies if there are some piece to "eat" in the downLeft direction
     * belonging the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the DownLeft direction
     * and false else
     */
    public boolean verifDirDownLeft(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow() + 1][pos.getColumn() - 1].getColor() != Color.EMPTY && board[pos1.getRow() + 1][pos1.getColumn() - 1].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setRow(pos1.getRow() + 1);
                pos1.setColumn(pos1.getColumn() - 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();
    }

    /**
     * Verifies if there are some piece to "eat" in the downRight direction
     * belonging the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the downRight direction
     * and false else
     */
    public boolean verifDirDownRight(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow() + 1][pos.getColumn() + 1].getColor() != Color.EMPTY && board[pos1.getRow() + 1][pos1.getColumn() + 1].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setRow(pos1.getRow() + 1);
                pos1.setColumn(pos1.getColumn() + 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();
    }

    /**
     * Verifies if there are some piece to "eat" in the right direction
     * belonging the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the right direction and
     * false else
     */
    public boolean verifDirRight(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow()][pos.getColumn() + 1].getColor() != Color.EMPTY && board[pos1.getRow()][pos1.getColumn() + 1].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setColumn(pos1.getColumn() + 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();
    }

    /**
     * Verifies if there are some piece to "eat" in the left direction belonging
     * the position of the piece
     *
     * @param pos the position of the piece
     * @param piece the color of the piece
     * @return true of there are some piece to "eat" in the left direction and
     * false else
     */
    public boolean verifDirLeft(Position pos, Piece piece) {
        Position pos1 = new Position(pos.getRow(), pos.getColumn());
        LinkedList<Piece> list = new LinkedList<>();
        if (board[pos.getRow()][pos.getColumn() - 1].getColor() != Color.EMPTY && board[pos1.getRow()][pos1.getColumn() - 1].getColor() != null) {
            while (board[pos1.getRow()][pos1.getColumn()].getColor() != Color.EMPTY || board[pos1.getRow()][pos1.getColumn()].getColor() != null) {
                pos1.setColumn(pos1.getColumn() - 1);
                list.add(board[pos1.getRow()][pos1.getColumn()]);
            }
        }
        return list.get(1).getColor() != Color.EMPTY && list.get(1).getColor() != piece.getColor() && list.get(list.lastIndexOf(piece)).getColor() == piece.getColor();
    }

    /**
     * Verifies if a position is free
     *
     * @param pos the position that has to be verified
     * @return true is the position is free and false else
     */
    public boolean isFree(Position pos) {
        return this.board[pos.getRow()][pos.getColumn()].getColor() == Color.EMPTY;
    }

    /**
     * This constructs the object Board with the parameter "board" received as
     * class parameter
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
     * This method helps the other class to be able to access to the value of
     * the playing board. This get the value of the variable "board"
     *
     * @return board that returns the dimensions of the playing board
     */
    /*
    public Square[][] getboard()
    {
        return board;
    }
     */
    /**
     * Boolean method that returns true if the position given in the parameters
     * is contained in the playing board and false either
     *
     * @param pos the position given by the methods that calls this one to be
     * able to know if the following is contained by the playing board or not
     * @return true if the position given in the parameters is contained by the
     * playing board, and false if not
     */
    public boolean isInside(Position pos) {
        return pos.getColumn() >= 0
                && pos.getColumn() <= 7
                && pos.getRow() >= 0
                && pos.getRow() <= 7;
    }

    /**
     * Allows the other classes to know where's a position on the playing board
     * of the position given in the parameters
     *
     * @param pos the parameters that allows the method to know what is the
     * place to return
     * @return the exact place of the position given in the parameters on the
     * playing board
     *
     * This throws an IllegalArgumentException("La pièce n'est pas sur le board
     * de jeu !") if the method isInside() retturns false
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
     * Add a piece on the palying board belonging the nature of the piece and
     * the position where to add the piece
     *
     * @param piece the piece to add
     * @param pos the position on the playing board where to add the piece
     *
     * This throws an IllegalArgumentException("La pièce n'est pas sur le board
     * de jeu !") if the method isInside() retturns false
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
     * Verifies if the square of position received as parameters contains any
     * piece or not
     *
     * @param pos the position in which the method has to verify if any piece
     * stays or not
     * @return true if the square at the position is free of piece and false
     * either
     *
     * This method throws an ArrayIndexOutOfBoundsException("La position ne fait
     * pas partie du tableau de jeu !") if the position doesn't concerns a
     * square that is in the playing board
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
    public Piece getPiece(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("La position ne fait pas partie du tableau de jeu !");
        }
        return this.board[pos.getRow()][pos.getColumn()];
    }

    /**
     * Count the number of pieces that belongs to the player received as
     * parameter
     *
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
