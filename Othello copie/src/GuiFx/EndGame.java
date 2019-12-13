package GuiFx;

import javafx.scene.control.Label;

/**
 *
 * @author leopoldmols
 */
public class EndGame
{
    Menu menu;
    ViewFX view;
    private Label lblPlayer1;
    private Label lblPlayer2;
    private Label lblScorePlayer1;
    private Label lblScorePlayer2;

    public EndGame(ViewFX view, Label lblScorePlayer1, Label lblScorePlayer2)
    {
        this.view = view;
        
        lblPlayer1.setLabelFor(view.getMenuView().getMenu().getTfdPlayer1());
        lblPlayer2.setLabelFor(view.getMenuView().getMenu().getTfdPlayer2());
        this.lblScorePlayer1 = lblScorePlayer1;
        this.lblScorePlayer2 = lblScorePlayer2;
    }
    
}