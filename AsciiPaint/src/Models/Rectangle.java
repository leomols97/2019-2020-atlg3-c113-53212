package Models;

/**
 *
 * @author leopoldmols
 */
public class Rectangle extends ColoredShape {
    
    Point upperLeft;
    double width;
    double height;

    public Rectangle(Point upperLeft, double width, double height, char color)
    {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void move(double dx, double dy)
    {
        upperLeft = new Point(upperLeft.getX() + dx, upperLeft.getY() + dy);
    }

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
