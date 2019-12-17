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
    private final Menu menu; // The menu that will define the MenuView
    
    
    /**
     * Constructs the object menuView that will contain the menu
     */
    public MenuView ()
    {
        this.menu = new Menu();
        
        menu.setAlignment(Pos.CENTER);
        
        initMenuView();
    }
    
    
    /**
     * Initialises the menuView
     */
    public void initMenuView ()
    {
        this.setPadding(new Insets(10));
        this.setHeight(40);
        
        this.getChildren().addAll(menu);
    }
    
    
    /**
     * Sets the menuView at Disable by calling the method 
     * "setGameVisible()" of the class "Menu"
     */
    public void clickOnPlayButton ()
    {
        menu.setGameVisible(true);
    }
    
    
    /**
     * Sets the menuView at not Disable by calling the method 
     * "setGameVisible()" of the class "Menu"
     */
    public void clickOnRestartButton ()
    {
        menu.setGameVisible(false);
    }
    
    
    /**
     * Gets the menu 
     * 
     * @return the menu contained by the menuView
     */
    public Menu getMenu()
    {
        return menu;
    }
}