package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author leopoldmols
 */
public class MainView extends HBox {
    
    DataView dView = new DataView();
    ResultView rView = new ResultView();
    
    
    public MainView ()
    {
        this.dView = new DataView();
        this.rView = new ResultView();
        
        this.getChildren().addAll(dView, rView);
    }
}
