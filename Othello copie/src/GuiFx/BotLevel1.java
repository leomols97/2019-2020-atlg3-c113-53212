package GuiFx;

import Models.*;

/**
 *
 * @author leopoldmols
 */
public class BotLevel1 extends Player implements Bot
{
    
    public BotLevel1(Color color)
    {
        super(color);
    }
    
    @Override
    public void play(Position position, Model game)
    {
        int random = (int) (Math.random() * game.possiblePositions(position).size());
        System.out.println(random);
        Position pos = game.possiblePositions(position).get(random);
        game.play(pos);
    }
}