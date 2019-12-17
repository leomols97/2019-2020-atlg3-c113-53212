package GuiFx;

import Models.*;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;


/**
 * This class handels the ratio between more black or more white pieces
 * that stands on the playing board
 * @author leopoldmols
 */
public class RatioBlackAndWhite extends ProgressIndicator implements Observer
{
    // The game belonging which the ratio will be displayed
    private final Model game;
    
    
    /**
     * Constructs the game with the game received as paramters
     * 
     * @param game the game that will define
     * how the ratio will be displayed
     */
    public RatioBlackAndWhite(Model game)
    {
        this.game = game;
    }

    
    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update()
    {
        double black = 0.0;
        double white = 0.0;
        if (this.game.getCurrent().getColor().equals(Color.BLACK))
        {
            black = (double) game.getScore(game.getCurrent().getColor());
            white = (double) game.getScore(game.getOponent().getColor());
        }
        else
        {
            black = (double) game.getScore(game.getOponent().getColor());
            white = (double) game.getScore(game.getCurrent().getColor());
        }
        setProgress((black + white) / 64.0);
    }
}