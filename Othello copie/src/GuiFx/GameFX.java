package GuiFx;

import Models.Game;
import Models.Observer;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


/**
 *
 * @author leopoldmols
 */

public class GameFX extends VBox implements Observer
{
    private final Game game;
    private final BoardFX board;
    
    public GameFX (Game game)
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
    
    public Game getGame()
    {
        return game;
    }

    public BoardFX getBoard()
    {
        return board;
    }
    
    @Override
    public void update()
    {
        board.update();
    }
}
