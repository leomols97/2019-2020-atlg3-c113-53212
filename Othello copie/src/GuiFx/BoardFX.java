package GuiFx;

import Models.*;
import javafx.scene.layout.*;

/**
 *
 * @author leopoldmols
 */
public class BoardFX extends HBox implements Observer {

    private final Game game;
    private final int SIZE = 8;

    private final GridPane plateau;
    private final SquareFX[][] squares;

    public BoardFX(Game game) {
        this.game = game;
        plateau = new GridPane();

        squares = new SquareFX[SIZE][SIZE];
        createGrid();
        
        this.getChildren().add(plateau);
    }

    void createGrid() {
        for (int y = 0; y < SIZE; y++)
        {
            for (int x = 0; x < SIZE; x++)
            {
                squares[y][x] = new SquareFX();
                addEvents(x, y);
                plateau.add(squares[y][x], x, y);
            }
        }
        
        updatePieces();
    }

    void addEvents(int x, int y)
    {
        Position pos = new Position(x, y);
        
        squares[y][x].setOnMouseEntered(e ->
        {
            squares[y][x].playableSquare(game.canPlay(pos));
        });
        squares[y][x].setOnMouseExited(e ->
        {
            squares[y][x].setBGGreen();
        });
        squares[y][x].setOnMouseClicked(e ->
        {
            if (game.canPlay(pos))
                game.play(pos);
        });
    }
    
    void updatePieces()
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
