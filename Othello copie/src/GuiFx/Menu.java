package GuiFx;

import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 *
 * @author leopoldmols
 */
public class Menu extends GridPane
{
    
    private Label lblPlayer1;
    private Label lblPlayer2;
    private Label lblTypePlayer1;;
    private Label lblTypePlayer2;;
    private TextField tfdPlayer1;
    private TextField tfdPlayer2;
    private ChoiceBox CBPlayer1;
    private ChoiceBox CBPlayer2;
    
    public Menu ()
    {
        this.lblPlayer1 = new Label("Joueur 1 : ");
        this.lblPlayer2 = new Label("Joueur 2 : ");
        this.lblTypePlayer1 = new Label("Sélectionnez le type du joueur 1 ->");
        this.lblTypePlayer2 = new Label("Sélectionnez le type du joueur 2 ->");
        this.tfdPlayer1 = new TextField();
        this.tfdPlayer2 = new TextField();
        this.CBPlayer1 = new ChoiceBox(FXCollections.observableArrayList(PlayerFX.values()));
        this.CBPlayer2 = new ChoiceBox(FXCollections.observableArrayList(PlayerFX.values()));
        
        initMenu();
    }
    
    public void initMenu ()
    {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(5);
        
        GridPane.setHalignment(lblTypePlayer1, HPos.RIGHT);
        this.add(lblTypePlayer1, 0, 0);
        
        GridPane.setHalignment(lblTypePlayer2, HPos.RIGHT);
        this.add(lblTypePlayer2, 0, 1);
        
        GridPane.setHalignment(CBPlayer1, HPos.LEFT);
        CBPlayer1.setMaxWidth(Double.POSITIVE_INFINITY);
        CBPlayer1.setValue(PlayerFX.HUMAN);
        this.add(CBPlayer1, 1, 0);
        
        GridPane.setHalignment(CBPlayer2, HPos.LEFT);
        CBPlayer2.setMaxWidth(Double.POSITIVE_INFINITY);
        CBPlayer2.setValue(PlayerFX.HUMAN);
        this.add(CBPlayer2, 1, 1);
        
        GridPane.setHalignment(lblPlayer1, HPos.RIGHT);
        lblPlayer1.setUnderline(true);
        this.add(lblPlayer1, 2, 0);
        
        GridPane.setHalignment(lblPlayer2, HPos.RIGHT);
        lblPlayer2.setUnderline(true);
        this.add(lblPlayer2, 2, 1);
        
        
        tfdPlayer1.setText("Pseudo du joueur 1");
        tfdPlayer1.setPrefColumnCount(20);
        this.add(tfdPlayer1, 3, 0);
        
        tfdPlayer2.setText("Pseudo du joueur 2");
        tfdPlayer2.setPrefColumnCount(20);
        this.add(tfdPlayer2, 3, 1);
    }
    
    public void setRegistered ()
    {
        tfdPlayer1.setDisable(true);
        tfdPlayer2.setDisable(true);
        CBPlayer1.setDisable(true);
        CBPlayer2.setDisable(true);
    }
    
    public TextField getTfdPlayer1()
    {
        return tfdPlayer1;
    }

    public TextField getTfdPlayer2()
    {
        return tfdPlayer2;
    }

    public PlayerFX getCBPlayer1()
    {
        return (PlayerFX) CBPlayer1.getValue();
    }

    public PlayerFX getCBPlayer2()
    {
        return (PlayerFX) CBPlayer2.getValue();
    }
}