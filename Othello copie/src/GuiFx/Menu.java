package GuiFx;

import Models.Observer;
import Models.Player;
import com.sun.prism.paint.Color;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


/**
 * This class creates the beginning view to register all the members
 * to be able to begin a game properly
 * 
 * @author leopoldmols
 */
public class Menu extends GridPane implements Observer
{
    private final Label lblPlayer1;
    private final Label lblPlayer2;
    private final Label lblTypePlayer1;
    private final Label lblTypePlayer2;
    // Where the player1 will put his name
    private final TextField tfdPlayer1;
    // Where the player2 will put his name
    private final TextField tfdPlayer2;
    // The choice that will define if the player1 is either a human or a bot
    private final ChoiceBox CBPlayer1;
    // The choice that will define if the player1 is either a human or a bot
    private final ChoiceBox CBPlayer2;
    private boolean isBot;
    
    
    /**
     * Constructs all the menu with the different objects needed
     * to properly begin a game
     */
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
        this.isBot = false;
        
        initMenu();
    }
    
    
    /**
     * Initialises the menu with all the needed values
     */
    public void initMenu ()
    {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(5);
        
        
        tfdPlayer1.setPromptText("Pseudo du joueur blanc");
        tfdPlayer1.setPrefColumnCount(20);
        this.add(tfdPlayer1, 3, 0);
        
        tfdPlayer2.setPromptText("Pseudo du joueur noir");
        tfdPlayer2.setPrefColumnCount(20);
        this.add(tfdPlayer2, 3, 1);
        
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
    }
    
    
    /**
     * Sets the menu at visible or not 
     * wether the game has begun or not
     * 
     * @param no if the menu doesn't have to be disabled
     */
    public void setGameVisible (boolean no)
    {
        lblPlayer1.setDisable(no);
        lblPlayer2.setDisable(no);
        lblTypePlayer1.setDisable(no);
        lblTypePlayer2.setDisable(no);
        tfdPlayer1.setDisable(no);
        tfdPlayer2.setDisable(no);
        CBPlayer1.setDisable(no);
        CBPlayer2.setDisable(no);
    }
    
    
    /**
     * Gets the name of the player1
     * 
     * @return the name entered by the player1
     */
    public String getTfdPlayer1()
    {
        return tfdPlayer1.getText();
    }
    
    
    /**
     * Gets the name of the player2
     * 
     * @return the name entered by the player2
     */
    public String getTfdPlayer2()
    {
        return tfdPlayer2.getText();
    }

    /**
     * Gets the type of the player1
     * 
     * @return the type of the player1
     */
    public PlayerFX getCBPlayer1()
    {
        return (PlayerFX) CBPlayer1.getValue();
    }

    /**
     * Gets the type of the player2
     * 
     * @return the type of the player2
     */
    public PlayerFX getCBPlayer2()
    {
        return (PlayerFX) CBPlayer2.getValue();
    }
    
    
    /**
     * Verifies if a player is a bot or not
     * 
     * @return true if he is and false else
     */
    public boolean checkBot (Player player)
    {
        if (player.getColor().equals(Color.BLACK))
        {
            isBot = true;
        }
        else if (player.getColor().equals(Color.WHITE))
        {
            isBot = true;
        }
        return isBot;
    }

    
    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update() 
    {
        initMenu();
    }
}