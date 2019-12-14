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
    // La vue du menu d'enregistrement des joueurs
    private final MenuView menuView;
    private final ButtonsFX buttons;
    private final ProgressIndicator gameProgression;
    // La barre de progression qui montre
    // le joueur qui gagne pour le moment
    private final ProgressBar currentWinner;
    private final Button play;
    private final WhitePlayerInfos whitePlayerInfos;
    
    public ViewFX (Game game)
    {
        this.game = new GameFX(game);
        this.menuView = new MenuView();
        this.buttons = new ButtonsFX(menuView);
        this.gameProgression = new ProgressIndicator();
        this.currentWinner = new ProgressBar();
        this.play = new Button("Jouer");
        this.whitePlayerInfos = new WhitePlayerInfos();
        
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
        
        this.buttons.getHistorique().setOnAction((event) ->
        {
            this.buttons.displayGameHistoric();
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
                whitePlayerInfos,
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
            //Label secondLabel = new Label("I'm a Label on new Window");
            Label lblScorePlayer1 = new Label(menuView.getMenu().getTfdPlayer1());
            displayScore();
            
            StackPane secondaryLayout = new StackPane();
            //secondaryLayout.getChildren().add(secondLabel);
            secondaryLayout.getChildren().add(lblScorePlayer1);
            
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
    
    public GridPane displayScore ()
    {
        GridPane results = new GridPane();
        Label lblScorePlayer1;
        //String namePlayer1;
        //String namePlayer2;
        this.setPadding(new Insets(10));
        //this.setHgap(10);
        //this.setVgap(5);
        
        TextField whiteScore = new TextField("Score du joueur blanc : ");
        TextField blackScore = new TextField("Score du joueur noir : ");
        if (this.game.getGame().isOver())
        {
            this.game.getGame().getScore(Color.WHITE);
        }
        //namePlayer1 = menuView.getMenu().getTfdPlayer1().getText();
        //results.add(menuView.getMenu().getTfdPlayer1(), 0, 0);
        //namePlayer2 = menuView.getMenu().getTfdPlayer2().getText();
        results.add(menuView.getMenu().getTfdPlayer2(), 0, 1);
        //menuView.getMenu().getTfdPlayer1().setText(menuView.getMenu().getTfdPlayer1());
        return results;
    }
    
    public MenuView getMenuView ()
    {
        return menuView;
    }
    
    public GameFX getGameFX ()
    {
        return this.game;
    }
    
    @Override
    public void update ()
    {
        menuView.update();
        displayGameProgression();
    }
}