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
    private final Label lblPlayer1;
    private final Label lblPlayer2;
    private final Label lblTypePlayer1;
    private final Label lblTypePlayer2;
    private final TextField tfdPlayer1;
    private final TextField tfdPlayer2;
    private final ChoiceBox CBPlayer1;
    private final ChoiceBox CBPlayer2;
    
    public Menu ()
    {
        this.lblPlayer1 = new Label("Joueur blanc : ");
        this.lblPlayer2 = new Label("Joueur noir : ");
        this.lblTypePlayer1 = new Label("Sélectionnez le type du joueur blanc ->");
        this.lblTypePlayer2 = new Label("Sélectionnez le type du joueur noir ->");
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
        
        
        tfdPlayer1.setText("Pseudo du joueur blanc");
        tfdPlayer1.setPrefColumnCount(20);
        this.add(tfdPlayer1, 3, 0);
        
        tfdPlayer2.setText("Pseudo du joueur noir");
        tfdPlayer2.setPrefColumnCount(20);
        this.add(tfdPlayer2, 3, 1);
    }
    
    public void setRegistered ()
    {
        lblPlayer1.setDisable(true);
        lblPlayer2.setDisable(true);
        lblTypePlayer1.setDisable(true);
        lblTypePlayer2.setDisable(true);
        tfdPlayer1.setDisable(true);
        tfdPlayer2.setDisable(true);
        CBPlayer1.setDisable(true);
        CBPlayer2.setDisable(true);
    }
    
    public String getTfdPlayer1()
    {
        return tfdPlayer1.getText();
    }

    public String getTfdPlayer2()
    {
        return tfdPlayer2.getText();
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