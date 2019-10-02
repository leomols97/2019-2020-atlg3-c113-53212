package Models;
import asciipaint.Point;

/**
 *
 * @author leopoldmols
 */
public interface Shape {
    
    public Point move (double dx, double dy);
    public boolean isInside (Point p);
    public ColoredShape getColor();
}
