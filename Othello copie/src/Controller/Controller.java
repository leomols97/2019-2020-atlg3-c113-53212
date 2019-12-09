package Controller;

import Models.*;
import View.*;
import java.util.Scanner;

/**
 * This class controls the way the game will begin, keep on and finish
 *
 * @author leopoldmols
 */
public class Controller
{
    private final Model game;
    private final View view;
    Scanner in = new Scanner(System.in);
    
    
    /**
     * Constructs the controller that will control every class
     * @param game the class that rules the game
     * @param view the class that manages everything that will be shown on screen
     */
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
    
    public void initialize()
    {
        game.initialize();
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
        initialize();
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
                if (!this.game.canPlaceSmw())
                {
                    this.view.displayError("Ce joueur ne peut pas jouer lors de ce tour.");
                }
            }
            this.view.displayHelp();
            String command = this.view.askCommand();
            String[] separate = command.toLowerCase().split(" ");
            switch(separate[0])
            {
                case "quit" :
                    endCom = true;
                    break;
                case "help" :
                    view.displayHelp();
                    break;
                case "score" :
                    System.out.println("Score du joueur noir (2) : " + game.getScore(Color.BLACK));
                    System.out.println("Score du joueur blanc (1) : " + game.getScore(Color.WHITE));
                    break;
                case "play" :
                    Position pos;
                    try
                    {
                        pos = new Position(Integer.parseInt(separate[1]) - 1, Integer.parseInt(separate[2]) - 1);
                        this.game.play(pos);
                        newTurn = true;
                        turn();
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Les 2 derniers arguments ne sont pas des chiffres !");
                    }
                    catch (ArrayIndexOutOfBoundsException e)
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
            this.game.getScore(Color.BLACK);
            this.game.getScore(Color.WHITE);
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
            System.out.println("\nAu tour du joueur noir (2) : ");
        }
        else
        {
            System.out.println("\nAu tour du joueur blanc (1) : ");
        }
    }
}
