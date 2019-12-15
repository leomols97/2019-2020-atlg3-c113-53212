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
    private final HBox up; // Contains all the players details 
    private final HBox middle; // Contains the board and the historic
    private final HBox down; // Contains the buttons and the game progressions
    private final VBox progressionsAndButtons; // The buttons and progressions under the game
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
    private final BlackPlayerInfos blackPlayerInfos;
    private final Historic historic;
    
    public ViewFX (Game game)
    {
        this.up = new HBox();
        this.lblCurrentWinner = new Label("Partage NOIRS/BALNCS ");
        this.lblCompletion = new Label("Jeu complété à ");
        this.middle = new HBox();
        this.down = new HBox();
        this.progressionsAndButtons = new VBox();
        this.HBCompletion = new HBox();
        this.HBCurrentWinner = new HBox();
        this.historic = new Historic(game);
        this.game = new GameFX(game);
        this.menuView = new MenuView();
        this.buttons = new ButtonsFX(menuView);
        this.gameProgression = new ProgressIndicator();
        this.currentWinner = new ProgressBar();
        this.play = new Button("Jouer");
        this.whitePlayerInfos = new WhitePlayerInfos(game, this.menuView.getMenu());
        this.blackPlayerInfos = new BlackPlayerInfos(game, this.menuView.getMenu());
        
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
        this.HBCompletion.setAlignment(Pos.BOTTOM_CENTER);
        this.HBCurrentWinner.setAlignment(Pos.CENTER);
        this.game.setAlignment(Pos.BOTTOM_LEFT);
        this.whitePlayerInfos.setAlignment(Pos.CENTER_LEFT);
        this.blackPlayerInfos.setAlignment(Pos.CENTER_LEFT);
        this.buttons.setAlignment(Pos.CENTER);
        this.up.setAlignment(Pos.CENTER);
        
        this.HBCompletion.getChildren().addAll(lblCompletion, gameProgression);
        this.HBCurrentWinner.getChildren().addAll(lblCurrentWinner, currentWinner);
        this.up.getChildren().addAll(
                whitePlayerInfos,
                blackPlayerInfos
        );
        this.middle.getChildren().addAll(
                game,
                historic
        );
        this.progressionsAndButtons.getChildren().addAll(
                HBCompletion,
                HBCurrentWinner,
                buttons
        );
        this.down.setAlignment(Pos.CENTER);
        this.down.getChildren().add(progressionsAndButtons);
        this.getChildren().addAll(up, middle, down);
    }
    
    private void beginGame ()
    {
        this.play.setDisable(true);
        this.menuView.clickOnPlayButton();
    }
    
    
    /**
     * Shows a new window if the current player hasn't strikes left
     */
    
    public void noStrikesLeft ()
    {
        GridPane GPNoStrikesLeft = new GridPane();
        Button ok = new Button("Ok");
        Label lblNoStrikesLeft = new Label("Vous ne pouvez pas jouer lors de ce tour. Le programme va changer de joueur.");
        GPNoStrikesLeft.add(lblNoStrikesLeft, 0, 0);
        Scene secondScene = new Scene(GPNoStrikesLeft, 230, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Plus de mouvement");
        newWindow.setScene(secondScene);
        ok.setOnAction((event) ->
        {
            newWindow.close();
        });
    }
    
    public GridPane displayGameProgression ()
    {
        GridPane GPScore = new GridPane();
        Button ok = new Button("Ok");
        ok.setMaxWidth(Double.MAX_VALUE);
        GPScore.setHalignment(ok, HPos.CENTER);
        GPScore.setValignment(ok, VPos.CENTER);
        
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
            GPScore.add(ok, 2, 0);
            
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
            
            ok.setOnAction((event) ->
            {
                newWindow.close();
            });
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

    public ButtonsFX getButtons()
    {
        return buttons;
    }
    
    @Override
    public void update ()
    {
        displayGameProgression();
        blackPlayerInfos.update();
        whitePlayerInfos.update();
    }
}