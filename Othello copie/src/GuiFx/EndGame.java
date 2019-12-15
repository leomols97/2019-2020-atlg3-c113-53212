package GuiFx;

import javafx.scene.control.Label;

/**
 *
 * @author leopoldmols
 */
public class EndGame
{
    private Menu menu;
    private final ViewFX view;
    private Label lblPlayer1;
    private Label lblPlayer2;
    private final Label lblScorePlayer1;
    private final Label lblScorePlayer2;

    public EndGame(ViewFX view, Label lblScorePlayer1, Label lblScorePlayer2)
    {
        this.view = view;
          
        //this.lblPlayer1.setLabelFor(view.getMenuView().getMenu().getTfdPlayer1());
        //this.lblPlayer2.setLabelFor(view.getMenuView().getMenu().getTfdPlayer2());
        this.lblScorePlayer1 = lblScorePlayer1;
        this.lblScorePlayer2 = lblScorePlayer2;
    }
}