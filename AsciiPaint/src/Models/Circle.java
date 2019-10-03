package Models;
import asciipaint.Point;

/**
 *
 * @author leopoldmols
 */
public class Circle extends ColoredShape {
    
    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color)
    {
        super(color);
        this.center = center;
        this.radius = radius;
        
    }
    
    public void move(double dx, double dy)
    {
        center = new Point(center.getX() + dx, center.getY() + dy);
    }

    @Override
    public boolean isInside(Point p)
    {
        return radius <= center.distance(p);
    }

//    public char getColor() {
//        return this.getColor();
//    }
}