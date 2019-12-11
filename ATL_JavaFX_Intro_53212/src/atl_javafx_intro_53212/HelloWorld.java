package atl_javafx_intro_53212;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init () 
    {
        System.out.println("Initialisation de l'écran");
    }
    
    @Override
    public void stop () 
    {
        System.out.println("Fin de l'écran");
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        
        primaryStage.initStyle(StageStyle.DECORATED);
        
        BorderPane root = new BorderPane();
        Text helloText = new Text("Hello World");
        root.setCenter(helloText);
        Scene scene = new Scene(root, 250, 100);
        helloText.setFont(Font.font("Times New Roman", 40));
        helloText.setFill(Color.RED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
