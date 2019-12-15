package GuiFx;

import Models.*;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


/**
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
    private final Circle color;
    
    /**
     * Constructs an object BlackPlayerInfos
     * to display the infos about the black player
     * 
     * @param game the game belonging which it has
     * to show the infos of the black player
     * @param menuView the menuView belonging which 
     * the name of the player will be shown
     */
    public BlackPlayerInfos (Model game, MenuView menuView)
    {
        this.game = game;
        this.menuView = menuView;
        this.score = new Label();
        this.name = new Label(menuView.getMenu().getTfdPlayer1());
        this.color = new Circle(10, Paint.valueOf("#FFFFFF"));
        this.infos = new Rectangle(100, 20);
        this.infos.setFill(Paint.valueOf("#098765"));
        this.lblScore = new Label("Score");
        this.lblPion = new Label("Couleur");
        this.lblName = new Label("Nom");
        
        initPlayerInfos();
    }
    
    /**
     * Initializes the rectangle that will contains the infos about the player
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
                      "-fx-border-color: yellow;");
        this.score.setText("" + this.game.getScore(Color.BLACK));
        //this.name.setText("" + this.menuView.getMenu().getTfdPlayer1());
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
     * Updates the infos about the player at every strike
     */
    public void updateInfos ()
    {
        score.setText(String.valueOf(this.game.getScore(Color.BLACK)));
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