package atl_javafx_intro_53212;

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
        primaryStage.setTitle("Calcul du BMR");
        GridPane root = new GridPane();
        
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(5);
        
        Label lblDonnees = new Label("Données");
        GridPane.setHalignment(lblDonnees, HPos.RIGHT);
        root.add(lblDonnees, 0, 0);
        
        Label lblTaille = new Label("Taille (cm)");
        GridPane.setHalignment(lblTaille, HPos.RIGHT);
        root.add(lblTaille, 0, 1);
        
        TextField tfdTaille = new TextField();
        tfdTaille.setText("Taille en cm");
        tfdTaille.setPrefColumnCount(20);
        root.add(tfdTaille, 1, 1);
        
        Label lblName = new Label("Poids (kg)");
        GridPane.setHalignment(lblName, HPos.RIGHT);
        root.add(lblName, 0, 2);
        
        TextField tfdPoids = new TextField();
        tfdPoids.setPrefColumnCount(20);
        root.add(tfdPoids, 1, 2);
        
        Label lblPassword = new Label("Age (années)");
        root.add(lblPassword, 0, 3);
        
        TextField tfdAge = new TextField();
        tfdAge.setPrefColumnCount(20);
        root.add(tfdAge, 1, 3);
        
        RadioButton rbSexe = new RadioButton();
        rbSexe.setText("Sexe");
        root.add(rbSexe, 1, 4);
        
        GridPane.setHalignment(lblPassword, HPos.RIGHT);
        GridPane.setFillWidth(tfdAge, false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}