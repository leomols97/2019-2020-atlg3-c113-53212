package GuiFx;

import Models.Observer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


/**
 *
 * @author leopoldmols
 */

public class MenuView extends VBox implements Observer
{
    private Menu menu;
    
    public MenuView ()
    {
        this.menu = new Menu();
        
        initMenuView();
    }
    
    public void initMenuView ()
    {
        this.setPadding(new Insets(10));
        this.setHeight(40);
        
        GridPane.setHalignment(menu, HPos.LEFT);
        this.getChildren().addAll(menu);
    }
    
    public void clickOnPlayButton ()
    {
        menu.setRegistered();
    }
    
    public Menu getMenu()
    {
        return menu;
    }

    @Override
    public void update()
    {
        menu.update();
    }
}