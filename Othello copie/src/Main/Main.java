package Main;

import Controller.*;
import Models.*;
import View.*;

/**
 * This class uses all methods from the other classes and initializes a hole game from the beginning to the end
 *
 * @author leopoldmols
 */
public class Main {
    
    /**
     * This calls all the methods to create and begin a hole game
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        View vue = new View();
        Controller controller = new Controller();
        Player current = new Player(Color.WHITE);
        Board board = new Board();
        while (!board.isOver())
        {
            vue.displayBoard(board.getBoard());
            controller.addPiece(current.getColor(), board);
            current.invert();
        }
    }
}
