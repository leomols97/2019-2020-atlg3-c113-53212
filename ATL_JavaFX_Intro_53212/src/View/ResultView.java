package View;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author leopoldmols
 */
public class ResultView extends GridPane {
    
    Label lblResults = new Label("Résultats");
    Label BMR = new Label("BMR");
    Label Calories = new Label("Calories");
    TextField tfdBMR = new TextField();
    TextField tfdCal = new TextField();
    
    public ResultView(){
        super();
        initPosition();
    }
    
    public void initPosition()
    {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(5);
        
        
        GridPane.setHalignment(lblResults, HPos.RIGHT);
        lblResults.setUnderline(true);
        this.add(lblResults, 2, 0);
        
        GridPane.setHalignment(BMR, HPos.RIGHT);
        this.add(BMR, 2, 1);
        
        GridPane.setHalignment(Calories, HPos.RIGHT);
        this.add(Calories, 2, 2);
        
        
        tfdBMR.setText("Résultat du BMR");
        tfdBMR.setPrefColumnCount(20);
        this.add(tfdBMR, 3, 1);
        
        tfdCal.setText("Dépense en calories");
        tfdCal.setPrefColumnCount(20);
        this.add(tfdCal, 3, 2);
    }

    public void setTfdBMR(TextField tfdBMR) {
        this.tfdBMR = tfdBMR;
    }

    public void setTfdCal(TextField tfdCal) {
        this.tfdCal = tfdCal;
    }

    public void setBMR(Label BMR) {
        this.BMR = BMR;
    }

    public void setCalories(Label Calories) {
        this.Calories = Calories;
    }
}
