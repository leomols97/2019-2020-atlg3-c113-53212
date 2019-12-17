package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;


/**
 * This class initializes properly all the contain of the window
 * That's why there are so much parameters :
 *  A lot of them only stands for the right poisitionning
 *  of the window elements.
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
    private Label lblCompletion; // The point at which the game is finished
    // The ratio of more whites or black pieces on the playing board
    private Label lblCurrentWinner;
    private GameFX gameFX;
    // La vue du menu d'enregistrement des joueurs
    private MenuView menuView;
    private ButtonsFX buttons;
    private ProgressIndicator gameProgression;
    // La barre de progression qui montre
    // le joueur qui gagne pour le moment
    private RatioBlackAndWhite currentWinner;
    private Button play;
    private BlackPlayerInfos blackPlayerInfos;
    private WhitePlayerInfos whitePlayerInfos;
    private HistoricView historicView;
    private final MenuBar menuBar; // Shows a menu bar at the top of the window
    private final VBox VBoxMenuBar;
    private final Menu menu;
    private final Game game;
    private boolean isBot;
    
    
    /**
     * Constructs the hole window
     */
    public ViewFX ()
    {
        this.isBot = false;
        this.menu = new Menu("Othello"); // The title of the window
        // The menuBar that stands at the top of the window
        this.menuBar = new MenuBar();
        this.VBoxMenuBar = new VBox(); // The VBox that contains the menuBar
        // This HBox contains all what concerns by the menu
        this.up = new HBox();
        this.lblCurrentWinner = new Label("Partage NOIRS/BALNCS ");
        this.lblCompletion = new Label("Jeu complété à ");
        // This HBox contains all what concerns the playing board and the menuView
        this.middle = new HBox();
        // This HBox contains progressionsAndButtons
        this.down = new HBox();
        // This VBox contains all what concerns the progress menus and the buttons
        this.progressionsAndButtons = new VBox();
        // This HBox contains only the progress menu 
        // thats stand to know how much the game is finished
        this.HBCompletion = new HBox();
        // This HBox contains only the progress menu 
        // thats stand to know which player is currently winning
        this.HBCurrentWinner = new HBox();
        this.menuView = new MenuView();
        // Only to know if a player is a bot or not
        if (menuView.getMenu().getCBPlayer1() != PlayerFX.HUMAN || menuView.getMenu().getCBPlayer2() != PlayerFX.HUMAN)
        {
            this.isBot = true;
        }
        this.game = new Game(isBot);
        this.gameFX = new GameFX(game);
        this.game.registerObserver(this);
        this.historicView = new HistoricView(game);
        this.buttons = new ButtonsFX(menuView);
        this.gameProgression = new ProgressIndicator();
        this.currentWinner = new RatioBlackAndWhite(game);
        this.play = new Button("Jouer");
        this.blackPlayerInfos = new BlackPlayerInfos(this.game, this.menuView);
        this.whitePlayerInfos = new WhitePlayerInfos(this.game, this.menuView);
        
        // Adds the menu bar to the window
        this.VBoxMenuBar.getChildren().addAll(this.menuBar);
        this.getChildren().addAll(VBoxMenuBar);
        
        displayView();
        addMenu();
    }
    
    
    /**
     * Displays the view and makes the differents buttons interactive
     */
    public void displayView ()
    {
        this.play.setDisable(true);
        this.menuView.getMenu().setGameVisible(true);
        this.menuBar.getMenus().add(menu);
        
        // This a hamburger-like menu
        Menu partie = new Menu("Partie");
        MenuItem jouer = new MenuItem("Jouer");
        MenuItem scoreActuel = new MenuItem("Score actuel");
        partie.getItems().add(jouer);
        partie.getItems().add(scoreActuel);
        menu.getItems().add(partie);
        
        // Sets the menuItem "jouer" interactive
        jouer.setOnAction(e ->
        {
            // Sets the "play" button visible
            this.play.setDisable(false);
            // Sets the menu at visible
            this.menuView.getMenu().setGameVisible(false);
        });
        
        // Sets the menuItem "scoreActuel" interactive
        scoreActuel.setOnAction(e ->
        {
            // Opens a new window to diplay the actual score
            this.buttons.displayActualScore(game);
        });
        
        this.setPadding(new Insets(10));
        
        play.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHalignment(play, HPos.CENTER);
        GridPane.setHalignment(buttons, HPos.CENTER);
        
        // Sets the "play" button interactive
        this.play.setOnAction((event) ->
        {
            beginGame(); // Begins a game
            // Adds all what was missing in the game to the window
            addAll(false);
        });
        
        // Sets the "pass" button interactive
        this.buttons.getPass().setOnAction((event) ->
        {
            this.game.passRowTable();
            this.game.changePlayer();
            //this.buttons.noStrikesLeft(game.getGame());
        });
        
        // Sets the "actualScore" button interactive
        this.buttons.getActualScore().setOnAction((event) ->
        {
            this.buttons.displayActualScore(game);
        });
        
        // Sets the "abandon" button interactive
        // It also creates and initializes an new game
        this.buttons.getAbandon().setOnAction((event) ->
        {
            this.buttons.displayEndGame(game);
            this.play.setDisable(false);
            Game game = new Game(isBot);
            this.gameFX = new GameFX(game);
            blackPlayerInfos.reInit(game);
            whitePlayerInfos.reInit(game);
            game.initialize();
        });
        
        // Sets the "restart" button interactive
        this.buttons.getRestart().setOnAction((event) ->
        {
            // Adds all the missing elements of the window
            // because a new game has begun
            addAll(true);
            //addAll(false);
            //restartGame();
        });
        
        displayGameProgression();
    }
    
    /**
     * Adds only the menu to the window
     */
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
            // Properly positions every Box
            this.HBCompletion.setAlignment(Pos.BOTTOM_CENTER);
            this.HBCurrentWinner.setAlignment(Pos.CENTER);
            this.gameFX.setAlignment(Pos.BOTTOM_LEFT);
            this.blackPlayerInfos.setAlignment(Pos.CENTER_LEFT);
            this.whitePlayerInfos.setAlignment(Pos.CENTER_LEFT);
            this.buttons.setAlignment(Pos.CENTER);
            this.up.setAlignment(Pos.CENTER);
            
            /**
             * Adds every little element to his correspondant box
             * and every correspondant box to her correspondant bigger box
             * and so on until the 3 boxes up, middle and down
             * that are added to the current VBox
             */
            this.HBCompletion.getChildren().addAll(lblCompletion, gameProgression);
            this.HBCurrentWinner.getChildren().addAll(lblCurrentWinner, currentWinner);
            this.up.getChildren().addAll(
                    blackPlayerInfos,
                    whitePlayerInfos
            );
            this.middle.getChildren().addAll(
                    gameFX,
                    historicView
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
            /**
             * In case of restart,
             * it only adds the playing board and the tableView
             * to the current VBox
             */
            this.middle.getChildren().clear();
            restartGame(this.game);
        }
    }
    
    /**
     * Displays again the TextFields and the play button
     * so that the new players can enter their names
     * and begin a new game
     * It also creates a new game
     * and adds it to the "middle" HBox
     * 
     * @param game the game belgoning which a new game will restart
     */
    private void restartGame (Model game)
    {
        displayGameProgression();
        this.play.setDisable(false);
        this.menuView.clickOnRestartButton();
        
        this.buttons.displayEndGame(game);
        
        this.middle.getChildren().clear();
        
        this.gameFX = new GameFX(game);
        //this.historicView = new HistoricView(game);
        this.gameFX.getBoardFX().resetBoard(game);
        this.blackPlayerInfos = new BlackPlayerInfos(this.game, this.menuView);
        this.whitePlayerInfos = new WhitePlayerInfos(this.game, this.menuView);
        
        this.middle.getChildren().addAll(
                this.gameFX//,
                //historicView
        );
    }
    
    /**
     * Begins a new game
     * by disabling the "menu" and the "play" button
     */
    private void beginGame ()
    {
        this.play.setDisable(true);
        this.menuView.clickOnPlayButton();
    }
    
    /**
     * Displays the game progression 
     * and if the playing board is full of pieces,
     * it opens a new window to let the players what their scores are
     * 
     * @return the gridPane that will stand in the window
     */
    public GridPane displayGameProgression ()
    {
        GridPane GPScore = new GridPane();
        
        double progression = (this.game.getNbPieces() / this.game.getNbCases());
        
        // if the playing board is full
        if (progression == 1)
        {
            this.buttons.displayActualScore(this.game);
            Button ok = new Button("Ok");
            ok.setMaxWidth(Double.MAX_VALUE);
            GPScore.setHalignment(ok, HPos.CENTER);
            GPScore.setValignment(ok, VPos.CENTER);
        }
        this.gameProgression.setProgress(progression);
        return GPScore;
    }
    
    /**
     * Gets the menuView
     * to let the classes know what the menuView contains
     * 
     * @return the menuView
     */
    public MenuView getMenuView ()
    {
        return this.menuView;
    }
    
    /**
     * Gets the gameFX
     * to let the other classes know what the gameFX contains
     * @return
     */
    public GameFX getGameFX ()
    {
        return this.gameFX;
    }

    /**
     * Gets the buttons
     * to let the other classes know what the buttons are
     * and to interact with them if needed
     * 
     * @return the buttons
     */
    public ButtonsFX getButtons()
    {
        return buttons;
    }

    
    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update ()
    {
        displayGameProgression();
        whitePlayerInfos.update();
        blackPlayerInfos.update();
    }
}