package View;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author leopoldmols
 */
public class DataView extends GridPane {
    
    Label lblDonnees = new Label("Données");
    Label lblTaille = new Label("Taille (cm)");
    Label lblName = new Label("Poids (kg)");
    Label lblAge = new Label("Âge (années)");
    Label lblSexe = new Label("Sexe");
    Label lblStyleDeVie = new Label("Style de vie sportif");
    TextField tfdTaille = new TextField();
    TextField tfdPoids = new TextField();
    TextField tfdAge = new TextField();
    RadioButton male = new RadioButton("H                         "); //A radio button with an empty string for its label
    RadioButton female = new RadioButton("F"); //A radio button with an empty string for its label
    ToggleGroup sexes = new ToggleGroup();
    ChoiceBox CBStyleDeVie = new ChoiceBox(FXCollections.observableArrayList(StyleDeVie.values()));
    public DataView(){
        super();
        initPosition();
    }
    
    public void initPosition()
    {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(5);

        GridPane.setHalignment(lblDonnees, HPos.RIGHT);
        lblDonnees.setUnderline(true);
        this.add(lblDonnees, 0, 0);
        
        GridPane.setHalignment(lblTaille, HPos.RIGHT);
        this.add(lblTaille, 0, 1);
        
        GridPane.setHalignment(lblName, HPos.RIGHT);
        this.add(lblName, 0, 2);
        
        GridPane.setHalignment(lblAge, HPos.RIGHT);
        this.add(lblAge, 0, 3);
        
        GridPane.setHalignment(lblSexe, HPos.RIGHT);
        this.add(lblSexe, 0, 4);
        
        GridPane.setHalignment(lblStyleDeVie, HPos.RIGHT);
        this.add(lblStyleDeVie, 0, 5);
        
        
        tfdTaille.setText("Taille en cm");
        tfdTaille.setPrefColumnCount(20);
        this.add(tfdTaille, 1, 1);
        
        tfdPoids.setText("Poids en kg");
        tfdPoids.setPrefColumnCount(20);
        this.add(tfdPoids, 1, 2);
        
        tfdAge.setText("Âge en années");
        tfdAge.setPrefColumnCount(20);
        this.add(tfdAge, 1, 3);
        
        GridPane.setHalignment(lblSexe, HPos.RIGHT);
        male.setToggleGroup(sexes);
        female.setToggleGroup(sexes);
        HBox HBSexes = new HBox();
        HBSexes.getChildren().addAll(male, female);
        this.add(HBSexes, 1, 4);
        
        GridPane.setHalignment(CBStyleDeVie, HPos.LEFT);
        CBStyleDeVie.setTooltip(new Tooltip("Sélectionnez votre style de vie"));
        CBStyleDeVie.setMaxWidth(Double.POSITIVE_INFINITY);
        this.add(CBStyleDeVie, 1, 5);
    }
    
    public String getTaille(){
        return tfdTaille.getText();
    }

    public TextField getTfdTaille() {
        return tfdTaille;
    }

    public TextField getTfdPoids() {
        return tfdPoids;
    }

    public TextField getTfdAge() {
        return tfdAge;
    }

    public ToggleGroup getSexes() {
        return sexes;
    }

    public ChoiceBox getCBStyleDeVie() {
        return CBStyleDeVie;
    }
}