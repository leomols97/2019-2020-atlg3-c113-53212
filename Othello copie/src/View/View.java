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
    
    /**
     * Constructs a new View
     */
    public View()
    {
        in = new Scanner(System.in);
    }
    
    /**
     * This shows a welcoming message to the user
     */
    public void initialize()
    {
        System.out.println("Un petit Othello ? Go :");
    }
    
    /**
     * This show a goobye message to the user
     */
    public void quit()
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
        System.out.println("Commandes possibles : ");
        System.out.println(" - 'show' : afficher le plateau de jeu");
        System.out.println(" - 'score' : afficher le score des joueurs");
        System.out.println(" - 'play i j' : jouer où 'i' représente la ligne dans laquelle placer votre pion et 'j' la colonne");
        System.out.println(" - 'quit' : quitter le jeu");
    }
    
    /**
     * Asks the user to enter a command that has to be entered
     * 
     * @return the command the user entered
     */
    public String askCommand()
    {
        System.out.print("Entrez votre commande :");
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
     * Displays a message with a color belonging the current player color.
     * 
     * This message only shows which player has to play now
     * @param player helps the message to be colored in the color of the player
     */
    /*
    public void displayCurrentPlayer(Player player)
    {
    //TODO
    }*/
    
    /**
     * Shows the top row of the playing board that shows the number of the columns
     * 
     * @param plateaus the playing game that is received as parameters to know which step of the game it has to return
     */
    private void topRow (Piece[][] plateau)
    {
        for (int i = 1; i <= plateau[0].length; i++)
        {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
    
    
    
    /**
     * Shows each lines of the playing board beginning with "Row#0" following the row's number
     * 
     * @param plateaus the playing game that is received as parameters to know which step of the game it has to return
     * @param current the current player. It allows the program to know which player's pieces has to be hidden by putting them "PI"
     * @param rowNum the number of the row only to display to the user where his pieces exctly are
     */
    /*
    private void row (Piece[][] plateaus, Player current, int rowNum, boolean quitGame)
    {
    
    
    System.out.print("Row#0" + rowNum + " | ");
    
    for (Piece plateau : plateaus[rowNum])
    {
    displayplateaus(plateau, current, quitGame);
    }
    System.out.println();
    
    
    }
    */
    
    /**
     * Displays the different plateaus with the piece that it contains (if it contains one) and the background belonging the plateau is a land or is water
     * 
     * @param plateau the plateau to show
     * @param current the player's piece that let the method know which player's pieces it has to show or hide by showing "PI"
     */
    /*
    private void displaySquares(Piece plateau /*, Player current, boolean quitGame )
    {
    //String resCol = ".";
    String color = "";
    String piece = "";
    
    if (!plateau.isFree())
    {
    if (plateau.isMyOwn(current.getColor()) || quitGame)
    {
    //piece = this.piece(plateau.getPiece().getColor());
    } else {
    }
    */
    /*
    if (plateau.getPiece().getColor() == 0)
    {
    color = "0";
    }
    else
    {
    color = "1";
    }*/
    /*
    if (plateau.getPiece().getColor() == 0)
    {
    color = "0";
    }
    else
    {
    color = "1";
    }
    }*/
    /*
    
    System.out.println(color);
    System.out.println(piece);
    }
    */
    
    /**
     * Shows a piece
     *
     * @param color the color of the piec eto show
     * @return the piece
     */
    /*
    private String piece (String color)
    {
    if (color.equals("0") && color.equals("1"))
    {
    throw new IllegalArgumentException("La couleur reçue en paramètre n'est pas correcte : " + color);
    }
    String piece = "0";
    if (color.equals("1"))
    {
    piece = "1";
    }
    return piece;
    }
    */
    
    /**
     * Shows the board
     *
     * @param plateau the plateaus
     * @param current the current player
     * @param quitgame to know if the game is finished or not
     */
    public void displayBoard (Piece[][] plateau /*, Player current, boolean quitgame */)
    {
        
        for (Piece plateaus : plateau[0])
        {
            System.out.print("---");
        }
        System.out.println();
        
        topRow(plateau);
        
        for (Piece[] plateau1 : plateau)
        {
//            row(plateau, current, i, quitgame);
            for (Piece item : plateau1)
                
                if (null != item.getColor())
                {
                    switch (item.getColor())
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
            System.out.println();
        }
    }
}