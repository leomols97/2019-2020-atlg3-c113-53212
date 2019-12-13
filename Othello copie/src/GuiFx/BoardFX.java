package GuiFx;

import Models.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


/**
 *
 * @author leopoldmols
 */

public class BoardFX extends HBox implements Observer
{
    
    private Game game;
    private final int SIZE = 8;
    
    public BoardFX(Game game)
    {
        //setHgap(2);
        //setVgap(2);
        this.game = game;
        //game.initialize();
        //showGrid();
        adding();
    }
    
    public GridPane showGrid()
    {
        GridPane plateau = new GridPane();
        getChildren().clear();
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                SquareFX square = new SquareFX(i, j);
                square.setStroke(Paint.valueOf("#00FF00")); //GREEN
                plateau.add(square, j, i);
                Position position = new Position(i, j);
                switch (game.getBoard()[i][j].getColor())
                {
                    case BLACK:
                        Circle shapeB = new Circle(20, Paint.valueOf("#000000")); //BLACK
                        shapeB.setFill(Paint.valueOf("#000000")); //BLACK
                        shapeB.setTranslateX(2);
                        plateau.add(shapeB, j, i);
                        break;
                    case WHITE:
                        Circle shapeW = new Circle(20, Paint.valueOf("#FFFFFF")); //WHITE
                        shapeW.setFill(Paint.valueOf("#FFFFFF")); //WHITE
                        shapeW.setTranslateX(2);
                        plateau.add(shapeW, j, i);
                        break;
                    case EMPTY:
                        SquareFX square1 = new SquareFX(i, j);
                        square1.setFill(Paint.valueOf("#00FF00")); //GREEN
                        plateau.add(square1, j, i);
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
                            game.play(position);
                        });
                        break;
                    default:
                        break;
                }
            }
        }
        return plateau;
    }
    
    public void adding()
    {
        this.getChildren().add(showGrid());
    }
    
    /*private void addToGrid (Position position, Circle cercle)
    {
        game.play(position);
        this.add(cercle, position.getRow(), position.getColumn());
    }*/
    
    @Override
    public void update()
    {
        showGrid();
        adding();
    }
}