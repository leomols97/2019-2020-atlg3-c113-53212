package GuiFx;

import Models.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;


/**
 *
 * @author leopoldmols
 */

public class BoardFX extends HBox implements Observer
{

    private Model game;
    private final int SIZE = 8;

    private GridPane plateau;
    private SquareFX[][] squares;

    /**
     *
     * @param game
     */
    public BoardFX(Model game)
    {
        this.game = game;
        plateau = new GridPane();

        squares = new SquareFX[SIZE][SIZE];
        createBoard();
        
        this.getChildren().add(plateau);
    }

    /**
     *
     */
    public void createBoard()
    {
        for (int y = 0; y < SIZE; y++)
        {
            for (int x = 0; x < SIZE; x++)
            {
                plateau.setHgap(2);
                plateau.setVgap(2);
                squares[y][x] = new SquareFX();
                addEvents(x, y);
                plateau.add(squares[y][x], x, y);
            }
        }
        updatePieces();
    }
    
    /**
     *
     * @param game
     */
    public void resetBoard (Model game)
    {
        this.getChildren().clear();
        
        this.game = game;
        plateau = new GridPane();

        squares = new SquareFX[SIZE][SIZE];
        createBoard();
        
        this.getChildren().add(plateau);
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addEvents(int x, int y)
    {
        Position pos = new Position(x, y);
        
        squares[y][x].setOnMouseEntered(e ->
        {
            squares[y][x].playableSquare(game.canPlay(pos));
            if (game.canPlay(pos))
            {
                squares[y][x].rect.setStroke(Paint.valueOf("#efd752")); // Yellow border
            }
            else
            {
                squares[y][x].rect.setStroke(Paint.valueOf("#ef5252")); // red border
            }
        });
        squares[y][x].setOnMouseExited(e ->
        {
            squares[y][x].setBGGreen();
            squares[y][x].rect.setStroke(squares[y][x].getColorGreen());
        });
        squares[y][x].setOnMouseClicked(e ->
        {
            if (game.canPlay(pos))
            {
                game.play(pos);
            }
        });
    }
    
    /**
     *
     */
    public void updatePieces()
    {
        for (int y = 0; y < SIZE; y++)
        {
            for (int x = 0; x < SIZE; x++)
            {
                squares[y][x].drawPiece(game.getBoard()[x][y].getColor());
            }
        }
    }

    /**
     *
     */
    @Override
    public void update()
    {
        updatePieces();
    }
}
