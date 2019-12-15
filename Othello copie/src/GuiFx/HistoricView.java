package GuiFx;

import Models.Model;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


/**
 *
 * @author leopoldmols
 */

public class HistoricView extends VBox
{
    private Model game;
    private GridPane GPHisto; // Pour la partie gauche de l'écran
    private Historic historic;
    private MenuView menuView;
    
    /**
     *
     * @param game
     * @param menuView
     */
    public HistoricView (Model game, MenuView menuView)
    {
        this.game = game;
        this.menuView = menuView;
        this.historic = new Historic(this.game, this.menuView);
        
        intitHistoricView();
        
        this.getChildren().add(GPHisto);
    }

    private void intitHistoricView ()
    {
        this.setPadding(new Insets(10));
        this.setHeight(40);
        
        GridPane.setHalignment(historic, HPos.LEFT);
        this.getChildren().addAll(historic);
    }
    
    /**
     *
     * @return
     */
    public Historic getHistoric ()
    {
        return historic;
    }
}