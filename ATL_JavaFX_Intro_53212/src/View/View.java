package View;

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
        button.setMinWidth(700);
        GridPane.setHalignment(button, HPos.RIGHT);
        this.getChildren().addAll(mView, button);
    }
}
