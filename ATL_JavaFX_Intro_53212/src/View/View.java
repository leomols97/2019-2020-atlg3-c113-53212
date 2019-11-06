package View;

import javafx.scene.layout.VBox;

/**
 *
 * @author leopoldmols
 */
public class View extends VBox {
    
    MainView mView = new MainView();
    
    public View ()
    {
        this.mView = new MainView();
        
        this.getChildren().addAll(mView);
    }
}
