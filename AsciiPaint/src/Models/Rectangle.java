package Models;

/**
 *
 * @author leopoldmols
 */
public class Rectangle extends ColoredShape {
    
    Point upperLeft;
    double width;
    double height;

    /**
     * Constructs a Rectangle
     * @param upperLeft the rectangle upperleft corner point
     * @param width the rectangle width
     * @param height the rectangle height
     * @param color the rectangle color
     */
    public Rectangle(Point upperLeft, double width, double height, char color)
    {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Move the rectangle upperleft corner
     * @param dx the distance to move the x of the center
     * @param dy the distance to move the y of the center
     */
    @Override
    public void move(double dx, double dy)
    {
        upperLeft = new Point(upperLeft.getX() + dx, upperLeft.getY() + dy);
    }

    /**
     * Verifies if a point is in the Rectangle
     * @param p the point that should be inside the Rectangle
     * @return true if the point is in the rectangle and false else
     */
    @Override
    public boolean isInside(Point p)
    {
        if (p.getX() - upperLeft.getX() < height && p.getY() - upperLeft.getY() < width)
        {
            return true;
        }
        return false;
    }

//    public char getColor() {
//        return this.getColor();
//    }
}
