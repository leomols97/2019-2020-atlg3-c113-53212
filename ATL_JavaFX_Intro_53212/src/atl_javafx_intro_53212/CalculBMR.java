package atl_javafx_intro_53212;

import View.DataView;
import View.ResultView;
import View.View;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

public class CalculBMR
        extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        
        View view = new View();
        DataView dataView = new DataView();
        ResultView resultView = new ResultView();
        Scene principal = new Scene(view);
//        Scene principal = new Scene(resultView);
        
        
        
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