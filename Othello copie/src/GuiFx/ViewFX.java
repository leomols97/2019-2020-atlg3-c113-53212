package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 *
 * @author leopoldmols
 */

public class ViewFX extends VBox implements Observer
{
    private final GameFX game;
    
    //private final BoardFX board;
    
    // La vue du menu d'enregistrement des joueurs
    private final MenuView menuView;
    private final ButtonsFX buttons;
    private final ProgressIndicator gameProgression;
    // La barre de progression qui montre 
    // le joueur qui gagne pour le moment
    private final ProgressBar currentWinner;
    private final Button play;
    
    public ViewFX (Game game)
    {
        this.game = new GameFX(game);
        //this.board = new BoardFX(game);
        this.menuView = new MenuView();
        this.buttons = new ButtonsFX();
        this.gameProgression = new ProgressIndicator();
        this.currentWinner = new ProgressBar();
        this.play = new Button("Jouer");
        
        displayView();
        addMenu();
    }
    
    public void displayView ()
    {
        this.setPadding(new Insets(10));
        
        play.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHalignment(play, HPos.CENTER);
        GridPane.setHalignment(buttons, HPos.CENTER);
        
        this.play.setOnAction((event) ->
        {
            beginGame();
            addAll();
        });
        
        displayGameProgression();
    }
    
    private void addMenu ()
    {
        this.getChildren().addAll(menuView, play);
    }
    
    private void addAll ()
    {
        this.getChildren().addAll(
                game,
                gameProgression,
                currentWinner,
                buttons
        );
    }
    
    private void beginGame ()
    {
        menuView.clickOnPlayButton();
    }
    
    public void displayGameProgression ()
    {
        double progression = (this.game.getGame().getNbPieces() / this.game.getGame().getNbCases());
        if (progression == 1)
        {
            Label secondLabel = new Label("I'm a Label on new Window");
 
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
 
                Scene secondScene = new Scene(secondaryLayout, 230, 100);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);
 
                // Set position of second window, related to primary window.
                //newWindow.setX(primaryStage.getX() + 200);
                //newWindow.setY(primaryStage.getY() + 100);
 
                newWindow.show();
        }
        this.gameProgression.setProgress(progression);
    }
    
    public void displayScore ()
    {
        TextField whiteScore = new TextField("Score du joueur blanc : ");
        TextField blackScore = new TextField("Score du joueur noir : ");
        if (this.game.getGame().isOver())
        {
            this.game.getGame().getScore(Color.WHITE);
        }
    }
    
    @Override
    public void update ()
    {
        displayGameProgression();
    }
}