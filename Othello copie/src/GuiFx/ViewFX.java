package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;


/**
 *
 * @author leopoldmols
 */

public class ViewFX extends VBox implements Observer
{
    private final Game game;
    private final BoardFX board;
    private final ButtonsFX buttons;
    private final ProgressIndicator gameProgression;
    private final ProgressBar currentWinner;
    
    public ViewFX (Game game)
    {
        this.game = game;
        this.buttons = new ButtonsFX();
        this.board = new BoardFX(game);
        this.gameProgression = new ProgressIndicator();
        this.currentWinner = new ProgressBar();
        
        displayView();
    }
    
    public void displayView ()
    {
        GridPane.setHalignment(buttons, HPos.CENTER);
        this.getChildren().addAll(
                board,
                gameProgression,
                currentWinner,
                buttons);
        
        this.setPadding(new Insets(10));
        
        displayGameProgression();
    }
    
    public void displayGameProgression ()
    {
        double progression = (this.game.getNbPieces() / this.game.getNbCases());
        this.gameProgression.setProgress(progression);
    }
    
    public void displayScore ()
    {
        TextField whiteScore = new TextField("Score du joueur blanc : ");
        TextField blackScore = new TextField("Score du joueur noir : ");
        if (this.game.isOver())
        {
            this.game.getScore(Color.WHITE);
        }
    }
    
    @Override
    public void update ()
    {
        board.update();
        displayGameProgression();
    }
}