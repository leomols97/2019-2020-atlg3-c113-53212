package View;

import Model.Sexe;
import javafx.geometry.HPos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author leopoldmols
 */
public class View extends VBox {
    
    MainView mView;
    Button button;
    
    public View ()
    {
        this.mView = new MainView();
        this.button = new Button("Calcul du BMR");
        button.setMinWidth(750);
        GridPane.setHalignment(button, HPos.CENTER);
        Integer savedPoids = Integer.parseInt(mView.dView.getTfdPoids().getText());
        this.button.setOnAction((event) ->
        {
            BMRView(Integer.parseInt(mView.dView.getTaille()), savedPoids, mView.dView.getTfdAge(), mView.dView.getSexes(), mView.dView.getCBStyleDeVie());
        });
        this.getChildren().addAll(mView, button);
    }
    public void BMRView (int taille, int poids, int age, Sexe sexe, StyleDeVie style)
    {
        double BMR = 0;
        String result;
        if (sexe == Sexe.MALE)
        {
            BMR = 13.7 * poids + 5 * taille - 6.8 * age + 66;
            result = String.valueOf(BMR);
            // setText(result);
            mView.rView.tfdBMR.setText(result);
        } else
        {
            BMR = 9.6 * poids + 1.8 * taille - 4.7 * age + 655;
            result = String.valueOf(BMR);
            System.out.println(result);
            // setText(result);
            mView.rView.tfdBMR.setText(result);
        }
    }
}
