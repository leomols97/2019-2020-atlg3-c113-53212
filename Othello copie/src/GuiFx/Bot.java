package GuiFx;

import Models.Model;
import Models.Position;

/**
 *
 * @author leopoldmols
 */
public interface Bot
{
    
    /**
     *
     * @param position
     * @param game
     */
    void play (Position position, Model game);
}
