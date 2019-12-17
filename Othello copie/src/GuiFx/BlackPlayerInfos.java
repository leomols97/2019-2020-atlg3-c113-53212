package GuiFx;

import Models.*;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


/**
 * This class creates the rectangle that contains all the informations about the black player
 * 
 * @author leopoldmols
 */
public class BlackPlayerInfos extends GridPane implements Observer
{
    private final Model game;
    private final MenuView menuView;
    // The background color of the rectangle that contains all the infos about the player
    private final Rectangle infos;
    private final Label lblName;
    private final Label lblPion;
    private final Label lblScore;
    private final Label score;
    private final Label name;
    private final Circle color; // To display the color of the player
    
    
    /**
     * Constructs the object BlackPlayerInfos that will contain 3 labels and the 
     * correspondant info (name, color, score)
     * 
     * @param game the game belonging which it has to display the information of the player
     * @param menuView the manu thanks to which the name of the player will be taken
     */
    public BlackPlayerInfos (Model game, MenuView menuView)
    {
        this.game = game;
        this.menuView = menuView;
        this.score = new Label();
        this.name = new Label();
        this.color = new Circle(10, Paint.valueOf("#000000"));
        this.infos = new Rectangle(100, 20);
        this.infos.setFill(Paint.valueOf("#000000"));
        this.lblScore = new Label("Score");
        this.lblPion = new Label("Couleur");
        this.lblName = new Label("Nom");
        
        initPlayerInfos();
    }
    
    
    /**
     * Initializes the informations about the player.
     * It shows rightly all the informations
     */
    public void initPlayerInfos ()
    {
        this.setHgap(98);
        
        // Set a CSS for the GridPane
        this.setStyle("-fx-padding: 10;" + 
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-width: 2;" +
                      "-fx-border-insets: 5;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: blue;");
        int scoreBlack = (this.game.getScoreBLACK(Color.BLACK) + this.game.getScoreBLACK(Color.BONUSBLACK));
        this.score.setText("" + scoreBlack);
        //this.name.setText("" + menuView.getMenu().getTfdPlayer1());
        this.name.setText(String.valueOf(menuView.getMenu().getTfdPlayer1()));
        //this.game.getCurrent().setName(menuView.getMenu().getTfdPlayer1());
        System.out.println(menuView.getMenu().getTfdPlayer1());
        this.lblName.setStyle("-fx-font-weight: bold");
        
        GridPane.setHalignment(lblName, HPos.CENTER);
        this.add(lblName, 0, 0);
        
        GridPane.setHalignment(lblPion, HPos.CENTER);
        this.add(lblPion, 1, 0);
        
        GridPane.setHalignment(lblScore, HPos.CENTER);
        this.add(lblScore, 2, 0);
        
        GridPane.setHalignment(name, HPos.CENTER);
        this.add(name, 0, 1);
        
        GridPane.setHalignment(color, HPos.CENTER);
        this.add(color, 1, 1);
        
        GridPane.setHalignment(score, HPos.CENTER);
        this.add(score, 2, 1);
    }

    
    /**
     * Updates the informations about the player.
     * Actually, it is only needed to update the score
     */
    public void updateInfos ()
    {
        int scoreBlack = (this.game.getScoreBLACK(Color.BLACK) + this.game.getScoreBLACK(Color.BONUSBLACK));
        score.setText(String.valueOf(scoreBlack));
        //name.setText(String.valueOf(menuView.getMenu().getTfdPlayer1()));
    }
    
    
    /**
     * Sets the score to 0 because the button "restart has been pushed"
     * 
     * @param game the game belonging which it has to show the score of the player
     */
    public void reInit (Game game) // to restart a game
    {
        int scoreBlack = (this.game.getScoreBLACK(Color.BLACK) + this.game.getScoreBLACK(Color.BONUSBLACK));
        this.score.setText("" + scoreBlack);
    }

    
    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update()
    {
        updateInfos();
    }
}