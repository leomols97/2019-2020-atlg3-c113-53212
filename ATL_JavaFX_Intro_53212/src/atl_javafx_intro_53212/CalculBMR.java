package atl_javafx_intro_53212;

import View.View;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class CalculBMR extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        
        View view = new View();
        Scene principal = new Scene(view);
        
        primaryStage.setTitle("Calcul du BMR");
        GridPane root = new GridPane();
        
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(5);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(principal);
        primaryStage.show();

    }
    
}