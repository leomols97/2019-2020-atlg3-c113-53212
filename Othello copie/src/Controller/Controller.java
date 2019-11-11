package Controller;

import Models.*;
import View.View;
import java.util.ArrayList;
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
        Position pos = new Position(in.nextInt()-1, in.nextInt()-1);
        while (!board.positionable(pos, piece)
                || (pos.getColumn() < 0
                || pos.getColumn() > 8
                || pos.getRow() < 0
                || pos.getRow() > 8)
                || board.isFree(pos))
        {            
            System.out.println("La position entrée est soit en dehors du plateau, soit, ne vous appartient pas !");
            System.out.print("Réessayez :");
            pos.setRow(in.nextInt()-1);
            pos.setColumn(in.nextInt()-1);
        }
        board.addPiece(piece, pos);
    }
}
