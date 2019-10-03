package Models;
import asciipaint.Point;

/**
 *
 * @author leopoldmols
 */
public interface Shape {
    
    public void move (double dx, double dy);
    public boolean isInside (Point p);
    public char getColor();
}
