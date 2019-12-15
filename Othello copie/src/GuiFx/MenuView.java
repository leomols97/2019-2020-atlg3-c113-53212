package GuiFx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;


/**
 *
 * @author leopoldmols
 */

public class MenuView extends VBox
{
    private Menu menu;
    
    /**
     *
     */
    public MenuView ()
    {
        this.menu = new Menu();
        
        menu.setAlignment(Pos.CENTER);
        
        initMenuView();
    }
    
    /**
     *
     */
    public void initMenuView ()
    {
        this.setPadding(new Insets(10));
        this.setHeight(40);
        
        this.getChildren().addAll(menu);
    }
    
    /**
     *
     */
    public void clickOnPlayButton ()
    {
        menu.setGameVisible(true);
    }
    
    /**
     *
     */
    public void clickOnRestartButton ()
    {
        menu.setGameVisible(false);
    }
    
    /**
     *
     * @return
     */
    public Menu getMenu()
    {
        return menu;
    }
}