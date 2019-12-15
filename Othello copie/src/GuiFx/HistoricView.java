package GuiFx;

import Models.Model;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author leopoldmols
 */

public class HistoricView extends VBox
{
    private Model game;
    private GridPane GPHisto; // Pour la partie gauche de l'écran
    private Historic historic;
    
    public HistoricView (Model game)
    {
        this.game = game;
        this.historic = new Historic(this.game);
        
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
    
    public Historic getHistoric ()
    {
        return historic;
    }
}