package GuiFx;

import Models.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author leopoldmols
 */

public class ButtonsFX extends HBox implements Observer
{
    private MenuView menu;
    private final Button abandon;
    private final Button pass;
    private final Button restart;
    private final Button historique;
    
    public ButtonsFX(MenuView menuView)
    {
        this.menu = menuView;
        this.restart = new Button("Recommencer");
        this.abandon = new Button("Abandon");
        this.pass = new Button("Pass");
        this.historique = new Button("Historique du jeu");
        
        displayButtons();
    }
    
    public void displayButtons()
    {
        HBox.setMargin(pass, Insets.EMPTY);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        //this.setHover(true);
        //this.setDepthTest(DepthTest.ENABLE);
        //this.setMinSize(100, 25);
        //this.setFillHeight(true);
        
        this.getChildren().addAll(
                abandon, 
                pass, 
                restart, 
                historique
        );
        
        this.historique.setOnMouseClicked(event ->
        {
            
        });
        
        this.abandon.setOnMouseClicked(event ->
        {
            
        });
    }

    public Button getAbandon ()
    {
        return abandon;
    }

    public Button getPass ()
    {
        return pass;
    }

    public Button getRestart ()
    {
        return restart;
    }

    public Button getHistorique ()
    {
        return historique;
    }
    
    public void displayGameHistoric ()
    {
        menu.getMenu().update();
        Label windowTitle = new Label(/*"Historique de jeu"*/);
        Label lblScorePlayer1 = new Label(/*menu.getMenu().tfdPlayer1.getText()*/);
        System.out.println(menu.getMenu().tfdPlayer1.getText());
        windowTitle.setText(menu.getMenu().getTfdPlayer1() + " dfghj ");
        //lblScorePlayer1.setText();
        //displayScore();
        
        StackPane historicWindow = new StackPane();
        historicWindow.getChildren().add(windowTitle);
        historicWindow.getChildren().add(lblScorePlayer1);
        
        Scene gameHisto = new Scene(historicWindow, 300, 300);
        
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Historique de jeu");
        newWindow.setScene(gameHisto);
        
        // Set position of second window, related to primary window.
        //newWindow.setX(primaryStage.getX() + 200);
        //newWindow.setY(primaryStage.getY() + 100);
        
        newWindow.show();
    }
    
    @Override
    public void update()
    {
        displayButtons();
    }
}