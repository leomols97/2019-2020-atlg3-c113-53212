package GuiFx;

import Models.Game;
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
    private Game game;
    private GridPane GPHisto; // Pour la partie gauche de l'écran
    private Historic historic;
    private final Stage stage; // Only to have the inital stage
    
    public HistoricView (Game game, Stage stage)
    {
        this.game = game;
        this.stage = stage;
        this.historic = new Historic(this.game, stage);
        
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