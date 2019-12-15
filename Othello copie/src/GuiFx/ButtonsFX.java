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
 *
 * @author leopoldmols
 */

public class ButtonsFX extends HBox implements Observer
{
    private final MenuView menu;
    private final Button abandon;
    private final Button pass;
    private final Button restart;
    private final Button actualScore;
    private final Button quit;
    
    /**
     *
     * @param menuView
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
     *
     */
    public void displayButtons()
    {
        this.setSpacing(10);
        //this.setAlignment(Pos.CENTER);
        //this.setHover(true);
        //this.setDepthTest(DepthTest.ENABLE);
        //this.setMinSize(100, 25);
        //this.setFillHeight(true);
        
        this.getChildren().addAll(
                abandon, 
                pass, 
                restart, 
                actualScore,
                quit
        );
        
        // Ce morceau ne sert à rien car on appelle le bouton dans ViewFX
        this.actualScore.setOnMouseClicked(event ->
        {
            
        });
        
        this.abandon.setOnMouseClicked(event ->
        {
            
        });
    }

    /**
     *
     * @return
     */
    public Button getAbandon ()
    {
        return abandon;
    }

    /**
     *
     * @return
     */
    public Button getPass ()
    {
        return pass;
    }

    /**
     *
     * @return
     */
    public Button getRestart ()
    {
        return restart;
    }
    
    /**
     *
     * @return
     */
    public Button getActualScore ()
    {
        return actualScore;
    }

    /**
     *
     * @return
     */
    public Button getQuit()
    {
        return quit;
    }
    
    /**
     *
     * @param game
     * @return
     */
    public GridPane displayEndGame (Model game)
    {
        // Nouvelle fenêtre
        Stage newWindow = new Stage();
        newWindow.setTitle("Abandon");
        newWindow.centerOnScreen();
        
        GridPane GPScore = new GridPane();
        Button ok = new Button("Ok");
        ok.setMaxWidth(Double.MAX_VALUE);
        GPScore.setHalignment(ok, HPos.CENTER);
        GPScore.setValignment(ok, VPos.CENTER);
        
        Scene gameHisto = new Scene(GPScore, 300, 80);
        newWindow.setScene(gameHisto);
        
        Label endGame = new Label("Fin de la partie");
        endGame.setUnderline(true);
        GPScore.add(endGame, 0, 0);
        
        Label lblScorePlayer1 = new Label(menu.getMenu().getTfdPlayer1() + " : ");
        GridPane.setHalignment(lblScorePlayer1, HPos.CENTER);
        GridPane.setValignment(lblScorePlayer1, VPos.CENTER);
        GPScore.add(lblScorePlayer1, 0, 1);
        
        Label scorePlayer1 = new Label("" + game.getScore(Color.WHITE));
        GPScore.add(scorePlayer1, 1, 1);
        
        Label lblScorePlayer2 = new Label(menu.getMenu().getTfdPlayer2() + " : ");
        GPScore.add(lblScorePlayer2, 0, 2);
        
        Label scorePlayer2 = new Label("" + game.getScore(Color.BLACK));
        GPScore.add(scorePlayer2, 1, 2);
        
        GPScore.add(ok, 1, 3);
        
        newWindow.show();
        
        ok.setOnAction((event) ->
        {
            menu.getMenu().setGameVisible(false);
            newWindow.close();
        });
        
        return GPScore;
    }
    
    /**
     *
     * @param game
     * @return
     */
    public GridPane displayActualScore (Model game)
    {
        // Nouvelle fenêtre
        Stage newWindow = new Stage();
        newWindow.setTitle("Score des joueurs");
        newWindow.centerOnScreen();
        
        GridPane GPScore = new GridPane();
        Button ok = new Button("Ok");
        ok.setMaxWidth(Double.MAX_VALUE);
        GPScore.setHalignment(ok, HPos.CENTER);
        GPScore.setValignment(ok, VPos.CENTER);
        
        Scene gameHisto = new Scene(GPScore, 300, 60);
        newWindow.setScene(gameHisto);
        
        Label lblScorePlayer1 = new Label(menu.getMenu().getTfdPlayer1() + " : ");
        GridPane.setHalignment(lblScorePlayer1, HPos.CENTER);
        GridPane.setValignment(lblScorePlayer1, VPos.CENTER);
        GPScore.add(lblScorePlayer1, 0, 0);
        
        Label scorePlayer1 = new Label("" + game.getScore(Color.WHITE));
        GPScore.add(scorePlayer1, 1, 0);
        
        Label lblScorePlayer2 = new Label(menu.getMenu().getTfdPlayer2() + " : ");
        GPScore.add(lblScorePlayer2, 0, 1);
        
        Label scorePlayer2 = new Label("" + game.getScore(Color.BLACK));
        GPScore.add(scorePlayer2, 1, 1);
        
        GPScore.add(ok, 1, 3);
        
        newWindow.show();
        
        ok.setOnAction((event) ->
        {
            newWindow.close();
        });
        
        return GPScore;
    }
    
    
    /**
     * Shows a new window if the current player hasn't strikes left
     * @param game
     */
    
    public void noStrikesLeft (Model game)
    {
        // Nouvelle fenêtre
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
     *
     */
    @Override
    public void update()
    {
        displayButtons();
    }
}