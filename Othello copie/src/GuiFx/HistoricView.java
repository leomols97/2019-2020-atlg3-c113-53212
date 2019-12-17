package GuiFx;

import Models.Model;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


/**
 * This class construct the historic tableView
 * @author leopoldmols
 */
public class HistoricView extends VBox
{
    private Model game; //The game belonging which the historic will be built
    private Historic historic; // The information that it will contain
    
    
    /**
     * Construct the object Historic View that is a VBox
     * 
     * @param game the game belonging which the historicView will be built
     */
    public HistoricView (Model game)
    {
        this.game = game;
        this.historic = new Historic(this.game);
        
        intitHistoricView();
    }

    
    /**
     * Initialises the historicView by setting 
     * the insets, 
     * the height 
     * and the alignement
     * 
     * This method adds the historicView in the Box
     */
    private void intitHistoricView ()
    {
        this.setPadding(new Insets(10));
        this.setHeight(40);
        
        GridPane.setHalignment(historic, HPos.LEFT);
        this.getChildren().addAll(historic);
    }
    
    /**
     * Gets the historic that composes the historixView
     * 
     * @return the historic that composes the historicView
     */
    public Historic getHistoric ()
    {
        return historic;
    }
}