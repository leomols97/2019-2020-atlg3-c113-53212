package GuiFx;

import Models.Color;
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

    final Rectangle rect;
    private final Circle piece;

    private final Paint colorBlack = Paint.valueOf("#000000");
    private final Paint colorWhite = Paint.valueOf("#FFFFFF");
    private final Paint colorGreen = Paint.valueOf("#00FF00");

    /**
     *
     */
    public SquareFX()
    {
        this.rect = new Rectangle(44.2, 44.2);
        this.rect.setFill(Paint.valueOf("#00FF00"));
        this.rect.setStroke(colorGreen);
        this.rect.setStrokeWidth(5);

        this.piece = new Circle(20);
        this.piece.setVisible(false);
        
        this.getChildren().addAll(rect, piece);
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

    /**
     *
     * @return
     */
    public Paint getColorGreen()
    {
        return colorGreen;
    }
}