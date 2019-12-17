package GuiFx;

import Models.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


/**
 * This class handels each squares that stands on the playing board
 * 
 * @author leopoldmols
 */
public class SquareFX extends StackPane
{
    final Rectangle rect; // The rectangle that will be a square
    // The different possible pieces that can be contained on a square
    private final Circle piece;
    
    /**
     * The different colors that a piece can take
     */
    private final Paint colorBlack = Paint.valueOf("#000000");
    private final Paint colorWhite = Paint.valueOf("#FFFFFF");
    private final Paint colorGreen = Paint.valueOf("#00FF00");
    private final Paint bonusCasePaint = Paint.valueOf("#ABCDEF");

    
    /**
     * Constructs the square and the circle
     */
    public SquareFX ()
    {
        this.rect = new Rectangle(44.2, 44.2);
        this.rect.setFill(Paint.valueOf("#00FF00"));
        this.rect.setStroke(colorGreen);
        this.rect.setStrokeWidth(5);

        this.piece = new Circle(20);
        this.piece.setVisible(false);
        
        this.getChildren().addAll(rect, piece);
    }
    
    
    /**
     * Draw pieces on every square of the playing board
     * 
     * @param color the color that the piece will take
     */
    public void drawPiece (Color color)
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
            case BONUS:
                rect.setFill(bonusCasePaint);
                rect.setStroke(bonusCasePaint);
            case BONUSBLACK:
                piece.setFill(colorBlack);
                piece.setVisible(true);
                rect.setFill(bonusCasePaint);
                rect.setStroke(bonusCasePaint);
                break;
            case BONUSWHITE:
                piece.setFill(colorWhite);
                piece.setVisible(true);
                rect.setFill(bonusCasePaint);
                rect.setStroke(bonusCasePaint);
                break;
            case EMPTY:
                piece.setVisible(false);
                break;
        }
    }
    
    
    /**
     * Sets the square background at green
     */
    public void setBGGreen ()
    {
        rect.setFill(colorGreen);
    }
    
    
    /**
     * Sets the square background at green
     */
    public void setBGBonus ()
    {
        rect.setFill(bonusCasePaint);
    }

    
    /**
     * Sets the color of a square at YELLOW if the square is playable and RED else
     * 
     * @param playable the boolean value that will define the color of the square
     */
    public void playableSquare (boolean playable)
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
     * Gets the Green color of a square
     * 
     * @return the parameter "colorgreen" 
     * as this is the color of the parameter
     */
    public Paint getColorGreen ()
    {
        return colorGreen;
    }

    
    /**
     * Gets the Bonus color of a square
     * 
     * @return the parameter "bonusCasePaint" 
     * as this is the color of the parameter
     */
    public Paint getBonusCasePaint ()
    {
        return bonusCasePaint;
    }
}