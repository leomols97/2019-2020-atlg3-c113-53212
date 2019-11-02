package Main;

/**
 *
 * @author leopoldmols
 */
public class Main {
    
    public static void main(String[] args) {
        Game jeu = new Game();
        View vue = new View();
        Controller controller = new Controller(jeu, vue);
        controller.initialize();
        controller.startGame();
    }
}
