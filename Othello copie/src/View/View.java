package View;

import Models.*;
import java.util.Scanner;

/**
 * Initializes the View of the game to make the view of the game understandable to the player
 *
 * @author leopoldmols
 */
public class View {
    
    /**
     * To let the user enter some commands
     */
    private final Scanner in;
    private Model game;
    
    /**
     * Constructs a new View
     */
    public View(Model game)
    {
        in = new Scanner(System.in);
        this.game = game;
    }
    
    /**
     * This shows a welcoming message to the user
     */
    public void displayStart()
    {
        System.out.println("Bienvenue dans le jeu Othello");
    }
    
    /**
     * This show a goobye message to the user
     */
    public void displayQuit()
    {
        System.out.println("\nA la prochaine, et merci d'avoir joué !");
    }
    
    /**
     * This shows an error containeing the message that is received as parameters
     *
     * @param message the error message that should be shown when an error occurs
     */
    public void displayError(String message)
    {
        System.out.println(message);
    }
    
    /**
     * Shows only the first line to display the different commands for the player
     */
    public void displayHelp()
    {
        System.out.println("\nCommandes possibles : ");
        System.out.println(" - 'show' : afficher le plateau de jeu");
        System.out.println(" - 'score' : afficher le score des joueurs");
        System.out.println(" - 'play i j' : jouer où 'i' représente la ligne dans laquelle placer votre pion et 'j' la colonne");
        System.out.println(" - 'quit' : quitter le jeu\n");
    }
    
    /**
     * Asks the user to enter a command that has to be entered
     *
     * @return the command the user entered
     */
    public String askCommand()
    {
        System.out.print("Entrez votre commande : ");
        String command = in.nextLine();
        return command;
    }
    
    /**
     * Displays the user that the game is finished
     */
    public void displayOver()
    {
        System.out.println("Partie terminée.");
    }
    
    /**
     * Shows the top row of the playing board that shows the number of the columns
     *
     * @param plateaus the playing game that is received as parameters to know which step of the game it has to return
     */
    private void topRow (Piece[][] plateau)
    {
        for (int i = 0; i <= plateau[0].length; i++)
        {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
    
    /**
     * Shows the board
     *
     * @param plateau the plateaus
     */
    public void displayBoard (Piece[][] plateau)
    {
        
        for (int i = -1; i < plateau.length; i++) {
            System.out.print("---");
        }
        System.out.println();
        
        topRow(plateau);
        
        for (int i = 0; i < plateau.length; i++)
        {
            if (plateau[i][0].getColor() != null)
            {
                System.out.print(" " + (i + 1) + " ");
            }
            for (int j = 0; j < plateau[i].length; j++)
            {
                if (null != plateau[i][j].getColor())
                {
                    switch (plateau[i][j].getColor())
                    {
                        case EMPTY:
                            System.out.print(" 0 ");
                            break;
                        case BLACK:
                            System.out.print(" 2 ");
                            break;
                        case WHITE:
                            System.out.print(" 1 ");
                            break;
                        default:
                            break;
                    }
                }
            }
            System.out.println();
        }
        for (int i = -1; i < plateau.length; i++) {
            System.out.print("---");
        }
    }
}