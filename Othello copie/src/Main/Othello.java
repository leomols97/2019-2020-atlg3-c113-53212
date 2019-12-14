package Main;

import GuiFx.*;
import Models.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This class manages all the views, models and controllers
 * 
 * @author leopoldmols
 */

public class Othello extends Application
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        Game g = new Game();
        g.initialize();
        ViewFX view = new ViewFX(g);
        g.registerObserver(view);
        
        primaryStage.setTitle("Othello");
        primaryStage.setMinHeight(750);
        primaryStage.setMinWidth(600);
        
        Scene principal = new Scene(view);
        
        primaryStage.setScene(principal);
        primaryStage.show();
    }
}