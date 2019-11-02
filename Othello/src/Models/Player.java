package Models;

import java.util.Objects;

/**
 *
 * @author leopoldmols
 */
public class Player {

    private final Color color;

    public Player(Color color)
    {
        if (color == null) {
            throw new IllegalArgumentException("La couleur du joueur n'est pas valide (Ni blanche (0), ni noire (1)) ! ");
        }
        this.color = color;
    }
    
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

    @Override
    public String toString()
    {
        return "Le joueur est de couleur "  + color;
    }
}
