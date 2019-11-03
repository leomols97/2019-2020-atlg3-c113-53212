package Models;

import java.util.Objects;

/**
 * Initializes a new object called "Player"
 * 
 * @author leopoldmols
 */
public class Player {

    /**
     * color of the new object "player"
     */
    private final Color color;

    /**
     * This constructs the object Player with the parameters "color" and "listPieces" received as class parameters
     * @param color The color received as parameters to give a color to the object Player
     * 
     * Throws a NullPointerException("La couleur du joueur n'est pas valide (Ni blanche (0), ni noire (1)) ! ") if the color is neither 0 neither 1
     */
    public Player(Color color)
    {
        if (color == null) {
            throw new IllegalArgumentException("La couleur du joueur n'est pas valide (Ni blanche (0), ni noire (1)) ! ");
        }
        this.color = color;
    }
    
    /**
     * Allows the other classes to know the color of the player
     * @return the color of the player
     */
    public Color getColor()
    {
        return color;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Player other = (Player) obj;
        if (this.color != other.color)
        {
            return false;
        }
        return true;
    }

    /**
     * Overrides the method "toString()" from Java API
     * @return the color and the listPieces of the current Player with a sentence
     */
    @Override
    public String toString()
    {
        return "Le joueur est de couleur "  + color;
    }
}
