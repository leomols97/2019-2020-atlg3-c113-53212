package Models;

/**
 *
 * @author leopoldmols
 */
public interface Shape {
    
   /**
     * Move the shape
     * @param dx the distance to move the x of the point that the shape is made from
     * @param dy the distance to move the y of the point that the shape is made from
     */
    public void move (double dx, double dy);

    /**
     * Verifies if a point is inside a shpe
     * @param p the point that should be inside the shape
     * @return true if the point is in the shape and false else
     */
    public boolean isInside (Point p);

    /**
     * Gets the color of the shape
     * @return the shape color
     */
    public char getColor();
}
