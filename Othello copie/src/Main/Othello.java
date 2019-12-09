package Main;

import GuiFx.BoardFX;
import Models.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * This class manages all the views, models and controllers
 * 
 * @author leopoldmols
 */

public class Othello extends Application
{

    private Game game;

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
        this.game = new Game();
        game.initialize();
        
        primaryStage.setMinHeight(1000);
        primaryStage.setMinWidth(1000);
        
        BoardFX board = new BoardFX(this.game);
        
        Scene principal = new Scene(board);
        
        primaryStage.setTitle("Othello");
        HBox root = new HBox();
        
        root.setPadding(new Insets(10));
        root.getChildren().add(board);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(principal);
        primaryStage.show();
        
        /*GridPane root = new GridPane();
        BoardFX board = new BoardFX();
        Button btn = new Button();
        board.showGrid();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>()
        {    
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Hello World!");
            }
        });
        
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 1000, 500);
        
        primaryStage.setTitle("Calcul du BMR");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }
    
}
