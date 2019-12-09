package GuiFx;

import javafx.scene.layout.StackPane;
import Models.*;
import static GuiFx.BoardFX.game;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author leopoldmols
 */
public class SquareFX /*extends StackPane*/ extends Rectangle
{
    private final int row, column;

    public SquareFX(int row, int column)
    {
        super(60, 60);
        this.row = row;
        this.column = column;
        setStroke(Color.BLACK);
        setFill(Color.GRAY);
        setStrokeWidth(2);
        updateCase();
        setOnMouseClicked(event ->
        {
            if (game.canPlay(new Position(this.row, this.column)))
            {
                game.play(new Position(this.row, this.column));
            }
            if(game.isOver())
            {
                // END THE GAME .setEndGame(game);
            }
        });
    }
    
    public void updateCase()
    {
        if (game.canPlay(new Position(this.row, this.column)))
        {
            setStroke(Color.BLACK);
            setFill(Color.CHARTREUSE);
        }
        else
        {
            setStroke(Color.BLACK);
            setFill(Color.RED);
        }
        try
        {
            if (game.getBoard()[this.row][this.column].getColor() == Models.Color.BLACK
                    || game.getBoard()[this.row][this.column].getColor() == Models.Color.WHITE)
            {
                setStroke(Color.BLACK);
                setFill(Color.DARKGRAY);
            }
        }
        catch (NullPointerException e)
        {

        }
    }
    /*private PieceFX pieceFX;
    
    public SquareFX (PieceFX pieceFX)
    {
        this.pieceFX = pieceFX;
    }*/
}
