package GuiFx;

import Models.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;


/**
 *
 * @author leopoldmols
 */

public class BoardFX extends GridPane
{
    static Game game;
    private final int SIZE = 8;
    //ChoiceBox CBStyleDeVie = new ChoiceBox(FXCollections.observableArrayList(StyleDeVie.values()));
    
    public BoardFX(Game game)
    {
        setHgap(5);
        setVgap(5);
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
                PieceFX case_ = new PieceFX(i, j);
                //case_.setOpacity(0.4);
                Shape shape = null;
                //Shape square = new Rectangle(40, 40, Paint.valueOf("#00FF00")); //GREEN
                SquareFX square = new SquareFX(i, j);
                square.setFill(Paint.valueOf("#00FF00"));
                this.add(square, j, i);
                Position position = new Position(i, j);
                //try
                //{
                    switch (game.getBoard()[i][j].getColor())
                    {
                        case BLACK:
                            shape = new Circle(20, Paint.valueOf("#000000")); //BLACK
                            shape.setStroke(Paint.valueOf("#000000")); //BLACK
                            shape.setStrokeWidth(2);
                            GridPane.
                            break;
                        case WHITE:
                            shape = new Circle(20, Paint.valueOf("#FFFFFF")); //WHITE
                            shape.setStroke(Paint.valueOf("#FFFFFF")); //WHITE
                            shape.setStrokeWidth(2);
                            break;
                        case EMPTY:
                            shape = new SquareFX(i, j);
                            shape.setStroke(Paint.valueOf("#00FF00")); //GREEN
                            shape.setStrokeWidth(2);
                            shape.setOnMouseEntered(event ->
                            {
                                square.playableSquare(game.canPlay(position));
                            });
                            //this.add(shape1, j, i);
                            break;
                        default:
                            shape.setVisible(false);
                            break;
                    }
                //}
                //catch (Exception e)
                //{
                //    System.out.println(e.getMessage());
                //}
                this.add(shape, j, i);
                //circle.setTranslateX(10);
            }
        }
        
        
        
        
        /*piano.setFitHeight(50);
        piano.setPreserveRatio(true);
        guitare.setFitHeight(50);
        guitare.setPreserveRatio(true);
        orgue.setFitHeight(50);
        orgue.setPreserveRatio(true);
        
        //on ajoute nos images à notre layout
        gridpane.add(piano, 1, 0);
        gridpane.add(guitare, 1, 1);
        gridpane.add(orgue, 1, 2);
        gridpane.setVgap(15);
        
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(5);*/
    }
}
