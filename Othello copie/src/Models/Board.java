package Models;

import java.util.Random;


/**
 * This class initialize a game board to welcome the Pieces to play It also
 * helps the other classes to know all the information that directly concerns
 * the playing board and its contained pieces, like if a piece is inside the
 * playing board or not
 *
 * @author leopoldmols
 */
public class Board
{

    /**
     * The initial board
     * It will have 8 rows
     * It will have 8 columns
     */
    private final Piece[][] board;
    private final int rowLength = 8;
    private final int colLength = 8;

    
    /**
     * This constructs the object Board with the parameter "board" received as
     * class parameter
     */
    public Board()
    {
        this.board = new Piece[this.rowLength][this.colLength];
        for(int i = 0; i < rowLength; i++)
        {
            for(int j = 0; j < colLength; j++)
            {
                this.board[i][j] = new Piece(Color.EMPTY);
            }
        }
    }

    
    /**
     * Puts the four first pieces on the board
     * and the three bonus cases
     */
    public void initialize()
    {
        Position posBonus1 = random();
        Position posBonus2 = random();
        Position posBonus3 = random();
        while (isAlreadyBonusPosition(posBonus2))
        {            
            posBonus2 = random();
        }
        while (isAlreadyBonusPosition(posBonus3))
        {            
            posBonus3 = random();
        }
        this.board[posBonus1.getRow()][posBonus1.getColumn()].setColor(Color.BONUS);
        this.board[posBonus2.getRow()][posBonus2.getColumn()].setColor(Color.BONUS);
        this.board[posBonus3.getRow()][posBonus3.getColumn()].setColor(Color.BONUS);
        this.board[3][3].setColor(Color.WHITE);
        this.board[3][4].setColor(Color.BLACK);
        this.board[4][4].setColor(Color.WHITE);
        this.board[4][3].setColor(Color.BLACK);
    }
    
    
    /**
     * Verifies if a position is already a bonus position
     * 
     * @param position the position to verify
     * @return true if the position is already a bonus position and false else
     */
    public boolean isAlreadyBonusPosition (Position position)
    {
        /*if (!isFree(position))
        {
            throw new IllegalArgumentException("La position n'est pas libre !");
        }*/
        return board[position.getRow()][position.getColumn()].getColor() != Color.EMPTY
                || board[position.getRow()][position.getColumn()].getColor() == Color.BONUS;
    }
    
    
    /**
     * Initializes a random position
     * that's not one of which that already has a piece on it
     * 
     * @return the position
     */
    public Position random ()
    {
        Position pos = new Position(1, 1);
        int randomRow = intGeneration(1, rowLength);
        int randomCol = intGeneration(1, colLength);
        while (randomRow == 3
                || randomRow == 4)
        {            
            randomRow = intGeneration(1, rowLength);
        }
        while (randomCol == 3
                || randomCol == 4)
        {            
            randomCol = intGeneration(1, rowLength);
        }
        pos.setRow(randomRow);
        pos.setColumn(randomCol);
        return pos;
    }
    
    
    /**
     * Generates a random position between two numbers
     * 
     * @param min the minimal value of the random
     * @param max the maximal value of the random
     * 
     * @return the random value
     */
    public int intGeneration(int min, int max)
    {
        Random random = new Random();
        int nb;
        nb = min+random.nextInt(max-min);
        return nb;
    }
    
    
    /**
     * This method helps the other class to be able to access to the value of
     * the playing board. This get the value of the variable "board"
     *
     * @return a call to the private method that constructs the board
     */
    public Piece[][] getBoard()
    {
        return copieDefensiveBoard();
    }
    
    
    /**
     * Makes a defensive copy of the playong board
     * 
     * @return the playing board
     */
    private Piece[][] copieDefensiveBoard()
    {
        Piece[][] copyBoard = new Piece[rowLength][colLength];
        for (int i = 0; i < this.board.length; i++)
        {
            for (int j = 0; j < this.board[i].length; j++)
            {
                copyBoard[i][j] = new Piece(Color.EMPTY);
                copyBoard[i][j].setColor(this.board[i][j].getColor());
            }
        }
        return copyBoard;
    }
    
    
    /**
     * Adds a piece on the playing board
     *
     * @param player the player that wants to add a piece
     * @param pos the position where to add the piece
     */
    public void addPiece(Player player, Position pos)
    {
        if (player.getColor() == Color.BLACK
                && this.board[pos.getRow()][pos.getColumn()].getColor() == Color.BONUS)
        {
            this.board[pos.getRow()][pos.getColumn()].setColor(Color.BONUSBLACK);
        }
        else if (player.getColor() == Color.WHITE
                && this.board[pos.getRow()][pos.getColumn()].getColor() == Color.BONUS)
        {
            this.board[pos.getRow()][pos.getColumn()].setColor(Color.BONUSWHITE);
        }
        else
        {
            this.board[pos.getRow()][pos.getColumn()].setColor(player.getColor());
        }
    }

    
    /**
     * Verifies if the square of position received as parameters contains any
     * piece or not
     *
     * @param pos the position in which the method has to verify if any piece
     * stays or not
     * 
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
        return this.board[pos.getRow()][pos.getColumn()].getColor() == Color.EMPTY
                || this.board[pos.getRow()][pos.getColumn()].getColor() == Color.BONUS;
    }
    
    
    /**
     * Boolean method that returns true if the position given in the parameters
     * is contained in the playing board and false either
     *
     * @param pos the position given by the methods that calls this one to be
     * able to know if the following is contained by the playing board or not
     * 
     * @return true if the position given in the parameters is contained by the
     * playing board, and false if not
     */
    public boolean isInside(Position pos)
    {
        return pos.getColumn() >= 0
                && pos.getColumn() < this.board.length
                && pos.getRow() >= 0
                && pos.getRow() < this.board[0].length;
    }
   
    
    /**
     * Shows the caracteristics of the object "Piece" that stands on the
     * position given as parameters
     *
     * @param pos the position where the piece has to be returned
     * 
     * @return the piece that stands on the position given as paramters
     *
     * This throws a new ArrayIndexOutOfBoundsException("La position ne fait pas
     * partie du tableau de jeu !") if the position is not insiade the playing
     * board
     */
    public Piece getPiece(Position pos)
    {
        if (!isInside(pos))
        {
            throw new ArrayIndexOutOfBoundsException("La position n'est pas dans le tableau ou est vide !");
        }
        return this.board[pos.getRow()][pos.getColumn()];
    }
}





// La suite ne contient que des méthodes en commentaire





    
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
     * 
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
