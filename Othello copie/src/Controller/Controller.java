package Controller;

import Models.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class controls the way the game will begin, keep on and finish
 *
 * @author leopoldmols
 */
public class Controller
{
    Scanner in = new Scanner(System.in);
    
    /**
     * Adds a piece in the playing board
     * @param playerColor the color of the piece that belongs to the player so that it knows which color the added piece has to be
     * @param board the board in which the piece has to be added
     */
    public void addPiece (Color playerColor, Board board)
    {
        Piece piece = new Piece(playerColor);
        Position pos = new Position(in.nextInt() - 1, in.nextInt() - 1);
        Position pos1 = new Position(5, 3);
        LinkedList<Direction> dirList = board.listDirection(pos, playerColor);
        /*
        LinkedList<Piece> pieceList = null;
        for (Direction dir : dirList) {
            pieceList = board.listPieces(dir, pos);
        }
        LinkedList<Piece> pieceListToFlip = board.listPiecesToFlip(pieceList);
*/
        LinkedList<LinkedList<Piece>> listDirsOfPieceToFlip = board.dirsToFlip(pos);
        while (!(board.positionable(pos, piece)
                || !board.isInside(pos)
                || !board.isFree(pos))
                || board.verifDirection(pos, piece))
        {            
            System.out.println("La position entrée est soit en dehors du plateau, soit, ne vous appartient pas, soit n'est pas positionnable !");
            System.out.print("Réessayez :");
            pos.setRow(in.nextInt()-1);
            pos.setColumn(in.nextInt()-1);
        }
        //board.flip(pos, piece);
        
        board.addPiece(piece, pos1);
        board.getBoard()[5][3].invert();
//        board.flipB(listDirsOfPieceToFlip, pos);
        board.addPiece(piece, pos);
    }
}
