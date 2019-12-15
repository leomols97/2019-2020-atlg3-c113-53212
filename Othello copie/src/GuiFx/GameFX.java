package GuiFx;

import Models.Model;
import Models.Observer;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


/**
 *
 * @author leopoldmols
 */

public class GameFX extends VBox implements Observer
{
    private final Model game;
    private final BoardFX board;
    
    public GameFX (Model game)
    {
        this.game = game;
        this.game.initialize();
        this.board = new BoardFX(this.game);
        game.registerObserver(board);
        
        displayView();
    }
    
    public void displayView ()
    {
        this.setPadding(new Insets(10));
        this.getChildren().add(board);
    }
    
    public Model getGame()
    {
        return game;
    }

    public BoardFX getBoardFX()
    {
        return board;
    }
    
    @Override
    public void update()
    {
        board.update();
    }
}