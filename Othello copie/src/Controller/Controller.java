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
     * This initialize the current game and the current view
     * by calling the appropriate method ("initialize")
     * respectively in the Model Package and the View package
     */
    
    /*public void initialize()
    {
        game.initialize();
        view.displayStart();
    }*/

    /**
     * This starts a game by calling the method "start()" in the package Model.
     * It will create a new variable "arretJeu" that will automatically take the value given by the method "isOver()" from the class "Game"
     * This also creates a variable "arretJeu" to stop a while that creates a new variable "board" of Square type and a new variable "arret" of String type.
     * Still in the while, "board" will be displayed  and the variable "arretJeu"
     * will change to true if the variable "arret" typed in by the user takes the value "quit"
     */
    public void startGame()
    {
        this.game.start();
        boolean endCom = false;
        boolean newTurn = false;
        
        this.view.displayStart();
        this.view.displayBoard(this.game.getBoard());
        this.view.displayHelp();
        turn();
        
        while (!this.game.isOver()
                && !endCom)
        {
                     if (newTurn)
            {
                this.game.changePlayer();
                if (!this.game.canPlaceSmw())
                {
                    this.view.displayError("Ce joueur ne peut pas jouer lors de ce tour.");
                    this.game.changePlayer();
                }
                turn();
            }
            String command = this.view.askCommand();
            String[] separate = command.split(" ");
            switch(separate[0])
            {
                case "quit" :
                    endCom = true;
                    break;
                case "help" :
                    view.displayHelp();
                    break;
                case "score" :
                    System.out.println("Score du joueur noir (2) : " + game.getScoreBlack());
                    System.out.println("Score du joueur blanc (1) : " + game.getScoreWhite());
                    break;
                case "play" :
                    Position pos;
                    try
                    {
                        pos = new Position(Integer.parseInt(separate[1]) - 1, Integer.parseInt(separate[2]) - 1);
                        this.game.place(pos);
                        newTurn = true;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Les 2 derniers arguments ne sont pas des chiffres !");
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("La commande comporte pas assez ou trop d'arguments !");
                    }
                    catch (Exception e)
                    {
                        view.displayError(e.getMessage());
                    }
                    break;
                case "show":
                    this.view.displayBoard(this.game.getBoard());
                    break;
                default :
                    System.out.println("zut");
                    System.out.println("La commande n'est pas correctement entrée");
            }
        }
        if (endCom == true)
        {
            this.view.displayQuit();
        }
        else
        {
            this.game.getScoreBlack();
            this.game.getScoreWhite();
            this.view.displayOver();
            this.view.displayQuit();
        }
        
    }
    
    /**
     * Displays who's turn it is
     */
    private void turn ()
    {
        if (game.getCurrent().getColor() == Color.BLACK)
        {
            System.out.println("Au tour du joueur noir (2) : ");
        }
        else
        {
            System.out.println("Au tour du joueur blanc (1) : ");
        }
    }
}
