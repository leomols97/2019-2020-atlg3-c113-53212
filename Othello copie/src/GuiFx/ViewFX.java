package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 *
 * @author leopoldmols
 */

public class ViewFX extends VBox implements Observer
{
    private HBox up; // Contains all the players details 
    private HBox middle; // Contains the board and the historic
    private HBox down; // Contains the buttons and the game progressions
    private VBox progressionsAndButtons; // The buttons and progressions under the game
    private HBox HBCompletion; // The infos of the completion of the game
    private HBox HBCurrentWinner; // All the infos about the current winner
    private Label lblCompletion;
    private Label lblCurrentWinner;
    private GameFX game;
    // La vue du menu d'enregistrement des joueurs
    private MenuView menuView;
    private ButtonsFX buttons;
    private ProgressIndicator gameProgression;
    // La barre de progression qui montre
    // le joueur qui gagne pour le moment
    private ProgressBar currentWinner;
    private Button play;
    private WhitePlayerInfos whitePlayerInfos;
    private BlackPlayerInfos blackPlayerInfos;
    private Historic historic;
    private final MenuBar menuBar; // Shows a menu bar at the top of the window
    private final VBox VBoxMenuBar;
    private final Menu menu;
    
    /**
     *
     * @param game
     */
    public ViewFX (Model game)
    {
        this.menu = new Menu("Othello");
        this.menuBar = new MenuBar();
        this.VBoxMenuBar = new VBox();
        this.up = new HBox();
        this.lblCurrentWinner = new Label("Partage NOIRS/BALNCS ");
        this.lblCompletion = new Label("Jeu complété à ");
        this.middle = new HBox();
        this.down = new HBox();
        this.progressionsAndButtons = new VBox();
        this.HBCompletion = new HBox();
        this.HBCurrentWinner = new HBox();
        this.game = new GameFX(game);
        this.historic = new Historic(game, menuView);
        this.menuView = new MenuView();
        this.buttons = new ButtonsFX(menuView);
        this.gameProgression = new ProgressIndicator();
        this.currentWinner = new ProgressBar();
        this.play = new Button("Jouer");
        this.whitePlayerInfos = new WhitePlayerInfos(this.game.getGame(), this.menuView);
        this.blackPlayerInfos = new BlackPlayerInfos(this.game.getGame(), this.menuView);
        
        displayView();
        addMenu();
    }
    
    /**
     *
     */
    public void displayView ()
    {
        this.play.setDisable(true);
        this.menuView.getMenu().setGameVisible(true);
        this.menuBar.getMenus().add(menu);
        //MenuItem partie = new MenuItem("Partie");
        
        Menu partie = new Menu("Partie");
        MenuItem jouer = new MenuItem("Jouer");
        MenuItem scoreActuel = new MenuItem("Score actuel");
        partie.getItems().add(jouer);
        partie.getItems().add(scoreActuel);
        menu.getItems().add(partie);
        
        menu.getItems().add(partie);
        
        this.VBoxMenuBar.getChildren().addAll(this.menuBar);
        
        this.getChildren().add(VBoxMenuBar);
        
        jouer.setOnAction(e ->
        {
            this.play.setDisable(false);
            this.menuView.getMenu().setGameVisible(false);
        });
        scoreActuel.setOnAction(e ->
        {
            this.buttons.displayActualScore(game.getGame());
        });
        
        this.setPadding(new Insets(10));
        
        play.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHalignment(play, HPos.CENTER);
        GridPane.setHalignment(buttons, HPos.CENTER);
        
        this.play.setOnAction((event) ->
        {
            beginGame();
            addAll(false);
        });
        
        this.buttons.getActualScore().setOnAction((event) ->
        {
            this.buttons.displayActualScore(game.getGame());
        });
        
        this.buttons.getPass().setOnAction((event) ->
        {
            this.game.getGame().changePlayer();
            //this.buttons.noStrikesLeft(game.getGame());
        });
        
        this.buttons.getAbandon().setOnAction((event) ->
        {
            this.play.setDisable(false);
            this.buttons.displayEndGame(game.getGame());
        });
        
        this.buttons.getRestart().setOnAction((event) ->
        {
            addAll(true);
            //addAll(false);
            //restartGame();
        });
        
        displayGameProgression();
    }
    
    private void addMenu ()
    {
        this.getChildren().addAll(menuView, play);
    }
    
    
    /**
     * Adds everything in the window or remove only the board and the historic
     *
     * @param remove if false, the method only adds everything,
     * and else, removes the board and the historic
     */
    
    private void addAll (boolean remove)
    {
        if (!remove)
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
        else
        {
            this.middle.getChildren().clear();
            restartGame(this.game.getGame());
        }
    }
    
    private void restartGame (Model game)
    {
        this.play.setDisable(false);
        this.menuView.clickOnRestartButton();
        
        this.middle.getChildren().clear();
        
        this.game = new GameFX(game);
        this.historic = new Historic(game, menuView);
        this.game.getBoardFX().resetBoard(game);
        this.whitePlayerInfos = new WhitePlayerInfos(this.game.getGame(), this.menuView);
        this.blackPlayerInfos = new BlackPlayerInfos(this.game.getGame(), this.menuView);
        
        this.middle.getChildren().addAll(
                this.game,
                historic
        );
    }
    
    private void beginGame ()
    {
        this.play.setDisable(true);
        this.menuView.clickOnPlayButton();
    }
    
    /**
     *
     * @return
     */
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
    
    /**
     *
     * @return
     */
    public MenuView getMenuView ()
    {
        return menuView;
    }
    
    /**
     *
     * @return
     */
    public GameFX getGameFX ()
    {
        return this.game;
    }

    /**
     *
     * @return
     */
    public ButtonsFX getButtons()
    {
        return buttons;
    }
    
    /**
     *
     */
    @Override
    public void update ()
    {
        displayGameProgression();
        blackPlayerInfos.update();
        whitePlayerInfos.update();
    }
}