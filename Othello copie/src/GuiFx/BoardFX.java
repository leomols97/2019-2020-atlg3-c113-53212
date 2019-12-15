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

    private final Game game;
    private final int SIZE = 8;

    private final GridPane plateau;
    private final SquareFX[][] squares;

    public BoardFX(Game game)
    {
        this.game = game;
        plateau = new GridPane();

        squares = new SquareFX[SIZE][SIZE];
        createBoard();
        
        this.getChildren().add(plateau);
    }

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

    public void addEvents(int x, int y)
    {
        Position pos = new Position(x, y);
        
        squares[y][x].setOnMouseEntered(e ->
        {
            squares[y][x].playableSquare(game.canPlay(pos));
            if (game.canPlay(pos))
            {
                squares[y][x].getRect().setStroke(Paint.valueOf("#efd752")); // Yellow border
            }
            else
            {
                squares[y][x].getRect().setStroke(Paint.valueOf("#ef5252")); // red border
            }
        });
        squares[y][x].setOnMouseExited(e ->
        {
            squares[y][x].setBGGreen();
            squares[y][x].getRect().setStroke(squares[y][x].getColorGreen());
        });
        squares[y][x].setOnMouseClicked(e ->
        {
            if (game.canPlay(pos))
            {
                game.play(pos);
            }
        });
    }
    
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

    @Override
    public void update()
    {
        updatePieces();
    }
}
