package Controller;

import Models.*;
import View.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class controls the way the game will begin, keep on and finish
 * 
 * @author leopoldmols
 */
public class Controller {

    private Model game;
    private View view;
    Scanner clavier = new Scanner (System.in);
          
    /**
     * This constructs an object "Controller"
     * @param game the game of the object Controller
     * @param view the view of the object
     *
     * Throw a NullPointerException("Le game n'existe pas !") if the game is null
     * Throw a NullPointerException("La view n'existe pas !") if the game is null
     */
    public Controller(Game game, View view)
    {
        if (game == null)
        {
            throw new NullPointerException("Le game n'existe pas !");
        }
        if (view == null)
        {
            throw new NullPointerException("La view n'existe pas !");
        }
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
        
        game.start();
        
        boolean quitGame = false;
        
        while (!game.isOver() && !quitGame)
        {
            System.out.println();
            this.view.displayBoard(game.getBoard(), game.getCurrent(), false);
            System.out.println();
            view.displayCurrentPlayer(game.getCurrent()); // shows the player that has to play now
            System.out.println();
            view.displayHelp(); // shows the different commands the player can do
            System.out.println();
            quitGame = command();
        }
        
        if (!quitGame)
        {
            this.view.displayBoard(game.getBoard(), game.getCurrent(), true);
            System.out.println();
            game.getWinners();
            System.out.println();
            view.displayOver(game.getWinners(), game.getLoosers());
        }
    }
    
    /**
     * Handels the  different possible commands entered by the user
     */
    private boolean command ()
    {
        int row = 0;
        int col = 0;
        Position pos = null;
        String[] separate;
        boolean end = false;
        boolean correctCom = false;
        ArrayList<String> commandList = new ArrayList<>();
        while (!correctCom)
        {
            separate = this.view.askCommand().trim().split(" ");
            for (int i = 0; i < separate.length; i++) {
                separate[i].toLowerCase(); // makes the String entered by the user in lower case for the following comparison we'll do with it
            }
            switch(separate[0])
            { // compare the string that is in the first place in the table "separate"
                case "show" :
                    correctCom = true;
                    view.displayBoard(game.getBoard(), game.getCurrent(), end);
                    view.displayHelp();
                    System.out.println(game.getCurrent());
                    break;
                case "score" :
                    correctCom = true;
                    int cptNoirs = 0;
                    int cptBlancs = 0;
                    for (int i = 0; i < game.getBoard().length; i++) {
                        if (view.) {
                            
                        }
                    }
                    break;
                case "play" :
                    correctCom = true;
                    int i = 0;
                    int j = 0;
                    try
                    {
                        i = Integer.parseInt(separate[1]);
                        j = Integer.parseInt(separate[2]);
                        Square [][] squareTest = null; // To verify if there's a piece next to the one the player wants to put
                        try {
                            squareTest[i+1][j] = null;
                            squareTest[i-1][j] = null;
                            squareTest[i][j+1] = null;
                            squareTest[i][j-1] = null;
                        } catch (Exception e)
                        {
                            System.out.println("Vous ne pouvez pas placer de pion qui n'en cotoie pas un autre !");
                        }
                    } catch (Exception e)
                    {
                        System.out.println("La commande n'est pas correctement entrée ! Ce n'est peut-être plus à votre tour...");
                    } finally
                    {
                        game.getSquare(pos[i][j]);
                    }
                default : 
                    view.displayError("La commande n'est pas correctement entrée ! Suivez les instruction proposées !");
            }
        }
        return end;
    }
}
