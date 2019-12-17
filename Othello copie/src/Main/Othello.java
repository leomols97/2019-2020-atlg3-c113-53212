package Main;

import GuiFx.*;
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
    //private MenuView menuView;
    
    @Override
    public void start(Stage primaryStage)
    {
        /*this.menuView = new MenuView();
        Model game = new Game(this.menuView.getMenu().checkBot());
        game.initialize();*/
        ViewFX view = new ViewFX(/*game*/);
        //game.registerObserver(view);
        
        primaryStage.setTitle("Othello");
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(970);
        
        Scene principal = new Scene(view);
        
        primaryStage.setScene(principal);
        primaryStage.show();
        
        view.getButtons().getQuit().setOnAction((event) ->
        {
            primaryStage.close();
        });
    }
}