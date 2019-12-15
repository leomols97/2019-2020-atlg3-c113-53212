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
    //private final Menu menu;
    private final MenuView menuView;
    // The background color of the rectangle that contains all the infos about the player
    private final Rectangle infos;
    private final Label lblName;
    private final Label lblPion;
    private final Label lblScore;
    private final Label score;
    private final Label name;
    private final Circle color;
    
    public BlackPlayerInfos (Model game, MenuView menuView)
    {
        this.game = game;
        //this.menu = menu;
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
    
    public void initPlayerInfos ()
    {
        this.setHgap(5);
        
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
        
        /*this.lblName.setAlignment(Pos.TOP_LEFT);
        this.lblPion.setAlignment(Pos.TOP_CENTER);
        this.lblScore.setAlignment(Pos.TOP_RIGHT);
        this.name.setAlignment(Pos.BOTTOM_LEFT);
        this.score.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().addAll(
                score,
                name,
                color,
                infos,
                lblScore,
                lblPion,
                lblName
        )*/
    }
    
    public void updateInfos ()
    {
        score.setText(String.valueOf(this.game.getScore(Color.BLACK)));
    }

    @Override
    public void update()
    {
        updateInfos();
    }
}