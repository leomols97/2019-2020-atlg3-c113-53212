package GuiFx;

import Models.Color;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author leopoldmols
 */
public class SquareFX extends StackPane
{

    private final Rectangle rect;
    private final Circle piece;

    private final Paint colorBlack = Paint.valueOf("#000000");
    private final Paint colorWhite = Paint.valueOf("#FFFFFF");
    private final Paint colorGreen = Paint.valueOf("#00FF00");

    public SquareFX()
    {
        rect = new Rectangle(40, 40);
        rect.setFill(Paint.valueOf("#00FF00"));
        rect.setStroke(colorGreen);
        rect.setStrokeWidth(5);

        piece = new Circle(20);
        piece.setVisible(false);
        
        getChildren().addAll(rect, piece);
    }
    
    void drawPiece(Color color)
    {
        switch (color)
        {
            case BLACK:
                piece.setFill(colorBlack);
                piece.setVisible(true);
                break;
            case WHITE:
                piece.setFill(colorWhite);
                piece.setVisible(true);
                break;
            case EMPTY:
                piece.setVisible(false);
                break;
        }
    }
    
    void setBGGreen()
    {
        rect.setFill(colorGreen);
    }

    void playableSquare(boolean playable)
    {
        if (playable)
        {
            rect.setFill(Paint.valueOf("#efd752")); //YELLOW
        }
        else
        {
            rect.setFill(Paint.valueOf("#ef5252")); //RED
        }
    }

    public Rectangle getRect()
    {
        return rect;
    }

    public Paint getColorGreen()
    {
        return colorGreen;
    }
}