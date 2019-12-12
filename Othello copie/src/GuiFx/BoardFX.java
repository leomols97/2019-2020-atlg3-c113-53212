package GuiFx;

import Models.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


/**
 *
 * @author leopoldmols
 */

public final class BoardFX extends GridPane implements Observer
{
    
    private Game game;
    private final int SIZE = 8;
    
    public BoardFX(Game game)
    {
        setHgap(2);
        setVgap(2);
        this.game = game;
        showGrid();
    }
    
    public void showGrid()
    {
        getChildren().clear();
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                SquareFX square = new SquareFX(i, j);
                square.setStroke(Paint.valueOf("#00FF00")); //GREEN
                this.add(square, j, i);
                Position position = new Position(i, j);
                
                switch (game.getBoard()[i][j].getColor())
                {
                    case BLACK:
                        Circle shapeB = new Circle(20, Paint.valueOf("#000000")); //BLACK
                        shapeB.setFill(Paint.valueOf("#000000")); //BLACK
                        shapeB.setTranslateX(2);
                        this.add(shapeB, j, i);
                        break;
                    case WHITE:
                        Circle shapeW = new Circle(20, Paint.valueOf("#FFFFFF")); //WHITE
                        shapeW.setFill(Paint.valueOf("#FFFFFF")); //WHITE
                        shapeW.setTranslateX(2);
                        this.add(shapeW, j, i);
                        break;
                    case EMPTY:
                        SquareFX square1 = new SquareFX(i, j);
                        square1.setFill(Paint.valueOf("#00FF00")); //GREEN
                        this.add(square1, j, i);
                        square1.setOnMouseEntered(event ->
                        {
                            square1.setTranslateX(2);
                            square1.playableSquare(game.canPlay(position));
                        });
                        square1.setOnMouseExited(event ->
                        {
                            square1.setFill(Paint.valueOf("#00FF00"));
                        });
                        square1.setOnMouseClicked(event ->
                        {
                            addToGrid(position, new Circle());
                        });
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    private void addToGrid (Position position, Circle cercle)
    {
        game.play(position);
        this.add(this, position.getRow(), position.getColumn());
    }
    
    @Override
    public void update()
    {
        showGrid();
    }
}