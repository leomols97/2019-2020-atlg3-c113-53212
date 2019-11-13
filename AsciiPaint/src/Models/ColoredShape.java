package Models;

/**
 *
 * @author leopoldmols
 */
public abstract class ColoredShape implements Shape {
    
    private char color;

    /**
     * Constructs the color of the shape
     * @param color the color of the shape
     */
    public ColoredShape(char color)
    {
        this.color = color;
    }

    /**
     * Getter of the color
     * @return the color of shape
     */
    @Override
    public char getColor()
    {
        return color;
    }

    /**
     * Set a new color for a shape
     * @param color the new color
     */
    public void setColor(char color)
    {
        this.color = color;
    }
}
