package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


/**
 *
 * @author leopoldmols
 */

public class ButtonsFX extends HBox implements Observer
{
    private final Button abandon;
    private final Button pass;
    private final Button restart;
    
    public ButtonsFX()
    {
        this.restart = new Button("Recommencer");
        this.abandon = new Button("Abandon");
        this.pass = new Button("Pass");
        displayButtons();
    }
    
    public void displayButtons()
    {
        HBox.setMargin(pass, Insets.EMPTY);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        //this.setHover(true);
        //this.setDepthTest(DepthTest.ENABLE);
        //this.setMinSize(100, 25);
        //this.setFillHeight(true);
        
        this.getChildren().addAll(abandon, pass, restart);
        
        abandon.setOnMouseClicked(event ->
        {
            
        });
    }
    
    @Override
    public void update()
    {
        displayButtons();
    }
}