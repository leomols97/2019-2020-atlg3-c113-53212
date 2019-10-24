package atl_javafx_intro_53212 ;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloWorldProperty extends Application {
    public static void main(String[] args) { 
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();
        Label helloText = new Label("Hello World");
        helloText.setTextFill (Color.RED);
        helloText.setFont(Font.font("Verdana", 20));
        helloText.setUnderline(true);                   // souligné
        
        Label helloTextLibelle = new Label(helloText.getText());
        Label helloTextFont = new Label("" + helloText.getFont());
        Label helloTextColor = new Label("" + helloText.getTextFill());
        
        System.out.println("Le message du Libellé est " + helloText.getText());
        System.out.println("La police du Libellé est " + helloText.getFont());
        System.out.println("La couleur du Libellé est " + helloText.getTextFill ());
        
        root.setCenter(helloText);
        root.setLeft(helloTextLibelle);
        root.setRight(helloTextFont);
        root.setBottom(helloTextColor);
        
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene); primaryStage.show();
    }
}