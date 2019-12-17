package GuiFx;

import Models.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;


/**
 * This class constructs the playing board and observe the Game
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
     * Constructs the object BoardFX
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
     * Really creates the board
     */
    public void createBoard()
    {
        for (int y = 0; y < SIZE; y++)
        {
            for (int x = 0; x < SIZE; x++)
            {
                plateau.setHgap(2); //sets the gap between the playing board cases
                plateau.setVgap(2); //sets the gap between the playing board cases
                squares[y][x] = new SquareFX();
                addEvents(x, y);
                plateau.add(squares[y][x], x, y);
            }
        }
        updatePieces();
    }
    
    
    /**
     * Resets the game as it hasn't been played on
     * 
     * @param game the game belonging which the board has to be shown
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
     * Adds events to every playing board square to make them cliquable
     * 
     * @param x the row parameter at which the square will become cliquable
     * @param y the column parameter at which the square will become cliquable
     */
    public void addEvents(int x, int y)
    {
        Position pos = new Position(x, y);
        
        squares[y][x].setOnMouseEntered(e ->
        {
            if (game.isBonusCase(pos))
            {
                if (game.canPlay(pos))
                {
                    squares[y][x].rect.setStroke(Paint.valueOf("#efd752")); // Yellow border
                }
                else
                {
                    squares[y][x].rect.setStroke(Paint.valueOf("#ef5252")); // Red border
                }
                squares[y][x].rect.setFill(Paint.valueOf("#ABCDEF"));
            }
            else
            {
                squares[y][x].rect.setFill(Paint.valueOf("#00FF00"));
                //squares[y][x].playableSquare(game.canPlay(pos));
                if (game.canPlay(pos))
                {
                    squares[y][x].rect.setStroke(Paint.valueOf("#efd752")); // Yellow border
                }
                else
                {
                    squares[y][x].rect.setStroke(Paint.valueOf("#ef5252")); // Red border
                }
            }
        });
        
        squares[y][x].setOnMouseExited(e ->
        {
            if (game.isBonusCase(pos))
            {
                squares[y][x].rect.setFill(Paint.valueOf("#ABCDEF"));
                squares[y][x].rect.setStroke(Paint.valueOf("#ABCDEF"));
            }
            else
            {
                squares[y][x].setBGGreen(); // sets the background color to green
                // sets the stroke of the square to the color it has to be if the square is playable or not
                squares[y][x].rect.setStroke(squares[y][x].getColorGreen());
            }
        });
        
        squares[y][x].setOnMouseClicked(e ->
        {
            if (game.canPlay(pos))
            {
                //squares[y][x].setBGGreen(); // sets the background color to green
                // sets the stroke of the square to the color it has to be if the square is playable or not
                //squares[y][x].rect.setStroke(squares[y][x].getColorGreen());
                game.play(pos);
                squares[y][x].rect.setFill(Paint.valueOf("#ABCDEF"));
                squares[y][x].rect.setStroke(Paint.valueOf("#ABCDEF"));
            }
            else if (game.isBonusCase(pos)
                    && !game.isFree(pos))
            {
                squares[y][x].rect.setFill(Paint.valueOf("#ABCDEF"));
                squares[y][x].rect.setStroke(Paint.valueOf("#ABCDEF"));
            }
        });
    }
    
    
    /**
     * Updates the color of the piece that is contained by the square
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
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update()
    {
        updatePieces();
    }
}
