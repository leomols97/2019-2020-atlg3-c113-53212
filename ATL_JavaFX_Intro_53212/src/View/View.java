package View;

import Model.*;
import static java.lang.Double.MAX_VALUE;
import javafx.geometry.HPos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author leopoldmols
 */
public class View extends VBox
{
    
    private MainView mView;
    private final Button button;
    
    public View ()
    {
        this.mView = new MainView();
        this.button = new Button("Calcul du BMR");
        button.setMaxWidth(MAX_VALUE);
        GridPane.setHalignment(button, HPos.CENTER);
        this.button.setOnAction((event) ->
        {
            BMRView(mView.dView.getTfdTaille(), mView.dView.getTfdPoids(), mView.dView.getTfdAge(), mView.dView.getSexes(), mView.dView.getCBStyleDeVie());
        });
        this.getChildren().addAll(mView, button);
    }
    public void BMRView (double taille, double poids, int age, Sexe sexe, StyleDeVie style)
    {
        Person pers = new Person(taille, poids, age, sexe, style);
        mView.rView.tfdBMR.setText(String.valueOf(pers.getBMR()));
        mView.rView.tfdCal.setText(String.valueOf(pers.getCalories()));
    }
}
