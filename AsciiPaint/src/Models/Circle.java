package Models;

/**
 *
 * @author leopoldmols
 */
public class Circle extends ColoredShape {
    
    private Point center;
    private double radius;

    /**
     * Constructs a Circle
     * @param center the center of the circle
     * @param radius the radius of the circle
     * @param color the color of the circle
     */
    public Circle(Point center, double radius, char color)
    {
        super(color);
        this.center = center; // APA : Copie défensive
        this.radius = radius;
        
    }
    
    /**
     * Move the center of a circle
     * @param dx the distance to move the x of the center
     * @param dy the distance to move the y of the center
     */
    public void move(double dx, double dy)
    {
        // APA : Pourquoi créer un nouveau point
        //center.move(dx,dy);
        center = new Point(center.getX() + dx, center.getY() + dy);
    }

    /**
     * Verifies if a point is in the center of the circle
     * @param p the point that should be inside the circle
     * @return true if the point is in the circle and false else
     */
    @Override
    public boolean isInside(Point p)
    {
        // APA : radius >= center distanceTo(p)
        return radius <= center.distanceTo(p);
    }

//    public char getColor() {
//        return this.getColor();
//    }
}