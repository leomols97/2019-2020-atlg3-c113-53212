package Controller;

import Models.*;
import View.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class controls the way the game will begin, keep on and finish
 *
 * @author leopoldmols
 */
public class Controller
{
    private Model game;
    private View view;
    Scanner in = new Scanner(System.in);

    public Controller(Model game, View view)
    {
        this.game = game;
        this.view = view;
    }
    
    /**
     * Adds a piece in the playing board
     * @param playerColor the color of the piece that belongs to the player so that it knows which color the added piece has to be
     * @param board the board in which the piece has to be added
     */
    public void addPiece (Color playerColor, Board board)
    {
        Piece piece = new Piece(playerColor);
        Position pos = new Position(in.nextInt() - 1, in.nextInt() - 1);
        //Position pos1 = new Position(5, 3);
        //LinkedList<Direction> dirList = board.listDirection(pos, playerColor);
        /*
        LinkedList<Piece> pieceList = null;
        for (Direction dir : dirList) {
            pieceList = board.listPieces(dir, pos);
        }
        LinkedList<Piece> pieceListToFlip = board.listPiecesToFlip(pieceList);
*/
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
        /*
        LinkedList<LinkedList<Position>> listDirsOfPieceToFlip = board.dirsToFlip(pos);
        board.addPiece(piece, pos1);
//        board.flipB(listDirsOfPieceToFlip, pos);
        for(int i = 0; i < listDirsOfPieceToFlip.size(); i++){
            board.flip(listDirsOfPieceToFlip.get(i));
        }
        */
        board.addPiece(piece, pos);
    }
    
    /**
     * This initialize the current game and the current view
     * by calling the appropriate method ("initialize")
     * respectively in the Model Package and the View package
     */
    public void initialize()
    {
        game.initialize();
        view.initialize();
    }

    /**
     * This starts a game by calling the method "start()" in the package Model.
     * It will create a new variable "arretJeu" that will automatically take the value given by the method "isOver()" from the class "Game"
     * This also creates a variable "arretJeu" to stop a while that creates a new variable "board" of Square type and a new variable "arret" of String type.
     * Still in the while, "board" will be displayed  and the variable "arretJeu"
     * will change to true if the variable "arret" typed in by the user takes the value "quit"
     */
    public void startGame()
    {
        boolean endCom = false;
        boolean newTurn = false;
        
        turn();
        
        while (!this.game.isOver() && !endCom)
        {            
            if (newTurn)
            {
                this.game.changePlayer();
                turn();
                if (!this.game.canPlaceSmw())
                {
                    System.out.println("Le joueur actuel ne peut pas jouer lors de ce tour !");
                    this.game.changePlayer();
                    turn();
                }
                newTurn = false;
            }
        }
        
        String[] separate = this.view.askCommand().split(" ");
        for (int i = 0; i < separate.length; i++)
        {
            separate[i].toLowerCase();
        }
        switch(separate[0])
        {
            case "quit" :
                endCom = true;
                break;
            case "help" :
                view.displayHelp();
                break;
            case "score" :
                System.out.println("Score du joueur noir : " + game.getScoreBlack());
                System.out.println("Score du joueur blanc : " + game.getScoreWhite());
                break;
            case "play" :
                Position pos;
                try
                {
                    pos = new Position(Integer.parseInt(separate[1]), Integer.parseInt(separate[2]));
                    this.game.place(pos);
                    newTurn = true;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Les 2 derniers arguments ne sont pas des chiffres !");
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println("La commande comporte trop ou pas assez d'arguments !");
                }
                catch (Exception e)
                {
                    view.displayError(e.getMessage());
                }
                break;
            default :
                System.out.println("La commande n'est pas correctement entrée");
        }
        if (endCom)
        {
            this.view.displayQuit();
        }
        else
        {
            this.view.displayOver();
            this.game.getScoreBlack();
            this.game.getScoreWhite();
        }
    
    }
    
    /**
     * Displays who's turn it is
     */
    private void turn ()
    {
        if (game.getCurrent().getColor() == Color.BLACK)
        {
            System.out.println("Au tour du joueur noir !");
        }
        else
        {
            System.out.println("Au tour du joueur blanc !");
        }
    }
}
