package Main;

import GuiFx.*;
import Models.*;
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
    
    private Game game;
    
    @Override
    public void start(Stage primaryStage)
    {
        this.game = new Game();
        this.game.initialize();
        ViewFX view = new ViewFX(this.game);
        this.game.registerObserver(view);
        
        primaryStage.setTitle("Othello");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(500);
        
        /*
        VBox fenetre = new VBox();
        GridPane boardGridPane = new GridPane();
        HBox buttonsAndProgression = new HBox();
        GridPane.setHalignment(buttonsAndProgression, HPos.CENTER);
        fenetre.getChildren().addAll(
                boardGridPane, 
                buttonsAndProgression);
        
        BoardFX board = new BoardFX(this.game);
        boardGridPane.getChildren().add(board);
        
        ButtonsFX buttonView = new ButtonsFX();
        buttonView.buttonsPositions();
        buttonsAndProgression.getChildren().add(buttonView);
        
        fenetre.setPadding(new Insets(10));
        */
        
        
        Scene principal = new Scene(view);
        
        primaryStage.setScene(principal);
        primaryStage.show();
    }
}