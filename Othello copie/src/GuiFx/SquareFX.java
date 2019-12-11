package GuiFx;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author leopoldmols
 */
public class SquareFX extends Rectangle
{
    private final int row, column;

    public SquareFX(int row, int column)
    {
        super(40, 40);
        this.row = row;
        this.column = column;
        setFill(Paint.valueOf("#00FF00"));
        setStrokeWidth(4);
    }
    
    public void playableSquare(boolean playable)
    {
        if (playable)
        {
            setFill(Paint.valueOf("#efd752")); //YELLOW
        }
        else
        {
            setFill(Paint.valueOf("#ef5252")); //RED
        }
    }
}