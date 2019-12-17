package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * This class creates, initializes and rightly
 * place the buttons needed for the game after it begins
 * 
 * @author leopoldmols
 */
public class ButtonsFX extends HBox implements Observer
{
    // The menu belonging which buttons have to react
    private final MenuView menu;
    private final Button abandon;
    private final Button pass;
    private final Button restart;
    private final Button actualScore;
    private final Button quit;
    
    
    /**
     * Constructs the object "ButtonFX" that will contain
     * evry button
     * 
     * @param menuView the menu that contains all the information needed
     * to make the buttons rightly react
     */
    public ButtonsFX(MenuView menuView)
    {
        this.menu = menuView;
        this.restart = new Button("Recommencer");
        this.abandon = new Button("Abandon");
        this.pass = new Button("Pass");
        this.actualScore = new Button("Score actuel");
        this.quit = new Button("Quitter");
        
        displayButtons();
    }
    
    
    /**
     * Adds all the buttons to the window
     */
    public void displayButtons()
    {
        this.setSpacing(10);
        this.getChildren().addAll(
                abandon, 
                pass, 
                restart, 
                actualScore,
                quit
        );
    }

    
    /**
     * Gets the button "abandon"
     * @return the button "abandon"
     */
    public Button getAbandon ()
    {
        return abandon;
    }

    
    /**
     * Gets the button "pass"
     * @return the button "pass"
     */
    public Button getPass ()
    {
        return pass;
    }

    
    /**
     * Gets the button "restart"
     * @return the button "restart"
     */
    public Button getRestart ()
    {
        return restart;
    }

    
    /**
     * Gets the button "actualScore"
     * @return the button "actuakScore"
     */
    public Button getActualScore ()
    {
        return actualScore;
    }

    
    /**
     * Gets the button "quit"
     * @return the button "quit"
     */
    public Button getQuit()
    {
        return quit;
    }
    
    
    /**
     * Displays a new window with the ending information
     * 
     * @param game the game belonging which the information will be updated
     * 
     * @return the gridpane that will contain the ending information
     */
    public GridPane displayEndGame (Model game)
    {
        // New window that will contain the gridpane
        Stage newWindow = new Stage();
        newWindow.setTitle("Fin de la partie");
        newWindow.centerOnScreen();
        
        // New GridPane that contains all the ending information
        GridPane GPScore = new GridPane();
        Button ok = new Button("Ok"); // The button to exit the window
        ok.setMaxWidth(Double.MAX_VALUE);
        GPScore.setHalignment(ok, HPos.CENTER);
        GPScore.setValignment(ok, VPos.CENTER);
        
        //The new scene that will be inside the window and contain the gridpane
        Scene gameHisto = new Scene(GPScore, 250, 80);
        newWindow.setScene(gameHisto);
        
        Label endGame = new Label("Abandon");
        endGame.setUnderline(true);
        GPScore.add(endGame, 0, 0);
        
        //Displays rightly the name of the player 1
        Label lblScorePlayer1 = new Label(menu.getMenu().getTfdPlayer1() + " : ");
        GridPane.setHalignment(lblScorePlayer1, HPos.CENTER);
        GridPane.setValignment(lblScorePlayer1, VPos.CENTER);
        GPScore.add(lblScorePlayer1, 0, 1);
        
        //Displays rightly the score of the player 1
        Label scorePlayer1 = new Label("" + game.getScoreWHITE(Color.WHITE));
        GPScore.add(scorePlayer1, 1, 1);
        
        //Displays rightly the name of the player 2
        Label lblScorePlayer2 = new Label(menu.getMenu().getTfdPlayer2() + " : ");
        GridPane.setHalignment(lblScorePlayer2, HPos.CENTER);
        GridPane.setValignment(lblScorePlayer2, VPos.CENTER);
        GPScore.add(lblScorePlayer2, 0, 2);
        
        //Displays rightly the score of the player 2
        Label scorePlayer2 = new Label("" + game.getScoreBLACK(Color.BLACK));
        GPScore.add(scorePlayer2, 1, 2);
        
        // The okay button to exit the window
        GPScore.add(ok, 1, 3);
        
        newWindow.show();
        
        // The action to close the window
        ok.setOnAction((event) ->
        {
            menu.getMenu().setGameVisible(false);
            newWindow.close();
        });
        
        return GPScore;
    }
    
    
    /**
     * Creates a new window with the actual scores
     * 
     * @param game the game belonging which
     * the scores has to be displayed
     * 
     * @return the gridpane contained by the window
     */
    public GridPane displayActualScore (Model game)
    {
        // Nouvelle fenêtre
        Stage newWindow = new Stage();
        newWindow.setTitle("Score des joueurs");
        newWindow.centerOnScreen();
        
        // New GridPane that contains all the ending information
        GridPane GPScore = new GridPane();
        Button ok = new Button("Ok"); // The button to exit the window
        ok.setMaxWidth(Double.MAX_VALUE);
        GPScore.setHalignment(ok, HPos.CENTER);
        GPScore.setValignment(ok, VPos.CENTER);
        
        //The new scene that will be inside the window and contain the gridpane
        Scene gameHisto = new Scene(GPScore, 400, 100);
        newWindow.setScene(gameHisto);
        
        //Displays rightly the name of the player 1
        Label lblScorePlayer1 = new Label(menu.getMenu().getTfdPlayer1() + " : ");
        GridPane.setHalignment(lblScorePlayer1, HPos.CENTER);
        GridPane.setValignment(lblScorePlayer1, VPos.CENTER);
        GPScore.add(lblScorePlayer1, 0, 0);
        
        //Displays rightly the score of the player 1
        Label scorePlayer1 = new Label("Nombre de vos pièces : " + game.getNbWhites() + ". Votre score : " + game.getScoreWHITE(Color.WHITE));
        GPScore.add(scorePlayer1, 1, 0);
        
        //Displays rightly the name of the player 2
        Label lblScorePlayer2 = new Label(menu.getMenu().getTfdPlayer2() + " : ");
        GridPane.setHalignment(lblScorePlayer2, HPos.CENTER);
        GridPane.setValignment(lblScorePlayer2, VPos.CENTER);
        GPScore.add(lblScorePlayer2, 0, 1);
        
        //Displays rightly the score of the player 2
        Label scorePlayer2 = new Label("Nombre de vos pièces : " + game.getNbBlacks() + ". Votre score : " + game.getScoreBLACK(Color.BLACK));
        GPScore.add(scorePlayer2, 1, 1);
        
        GPScore.add(ok, 1, 3);
        
        newWindow.show();
        
        // The action to close the window
        ok.setOnAction((event) ->
        {
            newWindow.close();
        });
        
        return GPScore;
    }
    
    
    /**
     * Shows a new window if the current player hasn't strikes left
     * 
     * @param game
     */
    public void noStrikesLeft (Model game)
    {
        // New window
        Stage newWindow = new Stage();
        newWindow.setTitle("Plus de mouvement");
        newWindow.centerOnScreen();
        
        GridPane GPNoStrikesLeft = new GridPane();
        
        Scene secondScene = new Scene(GPNoStrikesLeft, 230, 100);
        newWindow.setScene(secondScene);
        
        Button ok = new Button("Ok");
        ok.setMaxWidth(Double.MAX_VALUE);
        Label lblNoStrikesLeft = new Label("Vous ne pouvez pas jouer lors de ce tour. Le programme va changer de joueur.");
        game.changePlayer();
        GPNoStrikesLeft.add(lblNoStrikesLeft, 0, 0);
        
        ok.setOnAction((event) ->
        {
            newWindow.close();
        });
    }
    
    
    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update()
    {
        displayButtons();
    }
}