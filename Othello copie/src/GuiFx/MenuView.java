package GuiFx;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author leopoldmols
 */
public class MenuView extends GridPane
{
    
    private Menu menu;
    private final Button play;
    
    public MenuView ()
    {
        this.menu = new Menu();
        this.play = new Button("Jouer");
        play.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHalignment(menu, HPos.LEFT);
        GridPane.setHalignment(play, HPos.CENTER);
        this.play.setOnAction((event) ->
        {
            
        });
        this.getChildren().addAll(menu, play);
    }
    
    public void MenuViewFX ()
    {
        
    }
}
