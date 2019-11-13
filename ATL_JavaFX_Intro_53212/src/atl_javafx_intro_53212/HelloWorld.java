//package atl_javafx_intro_53212;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
///**
// *
// * @author leopoldmols
// */
//public class ATL_JavaFX_Intro_53212 extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Write 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}

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
//        root.setTop(helloText);
//        root.setBottom(helloText);
//        root.setLeft(helloText);
//        root.setRight(helloText);
        Scene scene = new Scene(root, 250, 100);
        helloText.setFont(Font.font("Times New Roman", 40));
        helloText.setFill(Color.RED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
