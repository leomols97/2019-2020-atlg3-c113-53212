package GuiFx;

import Models.Model;
import Models.Position;


/**
 * This interface is here for the bot
 * @author leopoldmols
 */
public interface Bot
{
    /**
     * This method plays at a position choosen by the bot
     * 
     * @param position the position where to play
     * @param game the game belonging which the bot will play
     */
    void play (Position position, Model game);
}