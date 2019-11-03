package Main;

import Controller.Controller;
import Models.Game;
import View.View;

/**
 *
 * @author leopoldmols
 */
public class Main {
    
    public static void main(String[] args)
    {
        Game jeu = new Game();
        View vue = new View();
        Controller controller = new Controller(jeu, vue);
        controller.initialize();
        controller.startGame();
    }
}
