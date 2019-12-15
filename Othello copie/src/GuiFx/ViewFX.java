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
    private final HBox up; // Contains the board and the gameInfos
    private final HBox down; // Contains the buttons and the game progressions
    private final VBox gameInfos; // Contains the informations about the game
    private final VBox progressionsAndButtons; // The buttons and progressions under the game
    private final HBox playersInfos; // All the infos about the players
    private final HBox HBCompletion; // The infos of the completion of the game
    private final HBox HBCurrentWinner; // All the infos about the current winner
    private final Label lblCompletion;
    private final Label lblCurrentWinner;
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
    private Historic historic;
    
    public ViewFX (Game game)
    {
        this.lblCurrentWinner = new Label("Ratio NOIRS/BALNCS ");
        this.lblCompletion = new Label("Jeu complété à ");
        this.up = new HBox();
        this.down = new HBox();
        this.gameInfos = new VBox();
        this.progressionsAndButtons = new VBox();
        this.playersInfos = new HBox();
        this.HBCompletion = new HBox();
        this.HBCurrentWinner = new HBox();
        this.historic = new Historic(game);
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
            this.buttons.displayGameHistoric(game.getGame());
        });
        
        displayGameProgression();
    }
    
    private void addMenu ()
    {
        this.getChildren().addAll(menuView, play);
    }
    
    private void addAll ()
    {
        this.HBCompletion.getChildren().addAll(lblCompletion, gameProgression);
        this.HBCompletion.setAlignment(Pos.BOTTOM_CENTER);
        this.HBCurrentWinner.getChildren().addAll(lblCurrentWinner, currentWinner);
        this.HBCurrentWinner.setAlignment(Pos.CENTER);
        this.gameInfos.getChildren().add(historic);
        this.up.getChildren().addAll(
                game,
                gameInfos
        );
        this.buttons.setAlignment(Pos.CENTER);
        this.progressionsAndButtons.getChildren().addAll(
                HBCompletion,
                HBCurrentWinner,
                whitePlayerInfos,
                buttons
        );
        this.down.getChildren().add(progressionsAndButtons);
        this.getChildren().addAll(up, down);
    }
    
    private void beginGame ()
    {
        menuView.clickOnPlayButton();
    }
    
    public GridPane displayGameProgression ()
    {
        GridPane GPScore = new GridPane();
        double progression = (this.game.getGame().getNbPieces() / this.game.getGame().getNbCases());
        if (progression == 1)
        {
            Label lblScorePlayer1 = new Label(menuView.getMenu().getTfdPlayer1());
            GridPane.setHalignment(lblScorePlayer1, HPos.CENTER);
            GridPane.setValignment(lblScorePlayer1, VPos.CENTER);
            GPScore.add(lblScorePlayer1, 0, 0);
            
            Label scorePlayer1 = new Label();
            
            Label lblScorePlayer2 = new Label(menuView.getMenu().getTfdPlayer2());
            GPScore.add(lblScorePlayer2, 0, 1);
            
            //displayScore();
            //GPScore.getChildren().add(secondLabel);
            /*GPScore.getChildren().addAll(
            lblScorePlayer1,
            lblScorePlayer2
            );*/
            
            Scene secondScene = new Scene(GPScore, 230, 100);
            
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
        return GPScore;
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
        //results.add(menuView.getMenu().getTfdPlayer2(), 0, 1);
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
        displayGameProgression();
    }
}