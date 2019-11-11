package Models;

/**
 * Initializes a player
 * 
 * @author leopoldmols
 */
public class Player
{
    /**
     * The color of the player
     */
    private Color color;
    
    /**
     * Constructs a player
     * 
     * @param color the color of the Player
     */
    public Player(Color color)
    {
        this.color = color;
    }
    
    /**
     * Inverts the current player by inverting the color of the current player
     */
    public void invert ()
    {
        if (this.color == Color.BLACK)
        {
            this.color = Color.WHITE;
        } else
        if (this.color == Color.WHITE)
        {
            this.color = Color.BLACK;
        }
    }

    /**
     * Gets the color of the player
     * 
     * @return the color of the player
     */
    public Color getColor()
    {
        return color;
    }
}