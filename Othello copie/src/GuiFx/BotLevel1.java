package GuiFx;

import Models.*;

/**
 *
 * @author leopoldmols
 */
public class BotLevel1 extends Player implements Bot
{
    
    /**
     *
     * @param color
     */
    public BotLevel1(Color color)
    {
        super(color);
    }
    
    /**
     *
     * @param position
     * @param game
     */
    @Override
    public void play(Position position, Model game)
    {
        int random = (int) (Math.random() * game.possiblePositions(position).size());
        System.out.println(random);
        for (int i = 0; i < game.possiblePositions(position).size(); i++)
        {
            System.out.println(game.possiblePositions(position).get(i));
        }
        Position pos = game.possiblePositions(position).get(random);
        game.play(pos);
    }
}