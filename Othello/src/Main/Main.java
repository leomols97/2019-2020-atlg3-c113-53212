package Main;

import Controller.Controller;
import Models.Game;
import View.View;

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
        Game jeu = new Game();
        View vue = new View();
        Controller controller = new Controller(jeu, vue);
        controller.initialize();
        controller.startGame();
    }
}
