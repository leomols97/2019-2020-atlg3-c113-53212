package GuiFx;

import Models.Model;
import Models.Observer;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


/**
 * This class creates a new view of the game
 * 
 * @author leopoldmols
 */
public class GameFX extends VBox implements Observer
{
    private final Model game;
    private final BoardFX board;
    
    
    /**
     * Constructs a view of the game belonging the game
     * 
     * @param game the game that will define the view of the game
     */
    public GameFX (Model game)
    {
        this.game = game;
        this.game.initialize();
        this.board = new BoardFX(this.game);
        game.registerObserver(board);
        
        displayView();
    }
    
    
    /**
     * Adds everything on the game view
     */
    public void displayView ()
    {
        this.setPadding(new Insets(10));
        this.getChildren().add(board);
    }
    
    
    /**
     * Gets the game
     * 
     * @return the game
     */
    public Model getGame()
    {
        return game;
    }

    
    /**
     * Gets the actual playing board
     * 
     * @return the actual playing board
     */
    public BoardFX getBoardFX()
    {
        return board;
    }
    
    
    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update()
    {
        board.update();
    }
}