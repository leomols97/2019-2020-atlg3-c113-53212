package View;

import Model.Sexe;
import javafx.scene.control.TextField;

/**
 *
 * @author leopoldmols
 */
public class BMRView extends TextField {
    
    public BMRView(int taille, int poids, int age, Sexe sexe, StyleDeVie style)
    {
        double BMR = 0;
        String result;
        if (sexe == Sexe.MALE)
        {
            BMR = 13.7 * poids + 5 * taille - 6.8 * age + 66;
            result = String.valueOf(BMR);
            setText(result);
        } else
        {
            BMR = 9.6 * poids + 1.8 * taille - 4.7 * age + 655;
            result = String.valueOf(BMR);
            setText(result);
        }
    }
}