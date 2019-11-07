package View;

import javafx.scene.layout.HBox;

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
