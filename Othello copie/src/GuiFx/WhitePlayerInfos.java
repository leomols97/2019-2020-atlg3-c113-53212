package GuiFx;

import Models.Game;
import Models.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author leopoldmols
 */
public class WhitePlayerInfos extends GridPane implements Observer
{
    
    //private ViewFX view;
    //private Game game;
    private Rectangle infos;
    private Label lblName;
    private Label lblPion;
    private Label lblScore;
    private Label score;
    private Label name;
    private Circle color;

    public WhitePlayerInfos ()
    {
        //this.view = new ViewFX(game);
        //this.game = this.view.getGameFX().getGame();
        this.score = new Label();
        this.name = new Label();
        this.color = new Circle(10, Color.WHITE);
        this.infos = new Rectangle(100, 20);
        this.lblScore = new Label("Score");
        this.lblPion = new Label("Couleur");
        this.lblName = new Label("Nom");
    }
    
    public void initWhitePlayerInfos ()
    {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(5);
        
        this.infos.setFill(Color.WHITE);
        this.infos.setStroke(Color.DARKGREEN);
        this.infos.setStrokeWidth(5);
        this.infos.setArcHeight(30);
        this.infos.setArcWidth(30);
        this.add(infos, 0, 0);
        
        this.color.setStroke(Color.BLACK);
        this.color.setStrokeWidth(2);
        
        this.getChildren().addAll(lblName, lblPion, lblScore, name, color, score);
    }
    
    public void updateScore ()
    {
        
    }
    
    @Override
    public void update ()
    {
        updateScore();
    }
}