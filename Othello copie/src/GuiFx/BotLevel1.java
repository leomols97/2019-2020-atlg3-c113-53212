package GuiFx;

import Models.*;


/**
 * This creates a bot that has the first level.
 * The first level hasnt any AI. It simply choose
 * randomly between some valid positions
 * 
 * @author leopoldmols
 */
public class BotLevel1 extends Player implements Bot
{
    /**
     * This constructs the bot as a player
     * 
     * @param color the oclor of the player bot
     */
    public BotLevel1(Color color)
    {
        super(color);
    }
    
    
    /**
     * This method makes the bot play at a certain position
     * 
     * @param position the position where the bot would play
     * @param game the game belonging which the bot will play
     */
    @Override
    public void play(Position position, Model game)
    {
        // if the bot can play or not. He cannot play if hasn't possible strike
        if (!game.hasStrikes(game.getCurrent().getColor()))
        {
            game.changePlayer();
        }
        else
        {
            // choose randomly between a list of positions
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
}