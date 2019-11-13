package Models;

/**
 *
 * @author leopoldmols
 */
public class Point {
    
    private  double x;
    private  double y;
    
    /**
     * Constructs a Point
     * @param x the point abscissa
     * @param y the point ordinate
     */
    public Point(double x, double y)
    {
        // System.out.println(" test " );
        this.x = x;
        this.y = y;
    }
    
    // APA : constructeur Point(Point p)
    /**
     * Get the point abscissa
     * @return the asbcissa
     */
    public double getX() { return x; }

    /**
     * Get the point ordinate
     * @return the ordinate
     */
    public double getY() { return y; }
    
    /**
     * Move the pont
     * @param dx the distance to move the x of the center
     * @param dy the distance to move the y of the center
     * @return the new point
     */
    // APA : devrait etre une void
    public Point move(double dx, double dy)
    {
        x += dx;
        y += dy;
        return this;
    }
    
    /**
     * Calculate the abscissa and the ordinate of the new point
     * @param p1 the actual point
     * @return the abscissa and ordinate new point
     */
    public double distanceTo (Point p1)
    {
        double lengthX = this.getX() - p1.getX();
        double lengthY = this.getY() - p1.getY();
        return Math.sqrt(Math.pow(lengthX, 2) + Math.pow(lengthY, 2));
    }
    
    @Override
    public String toString()
    {
        return "("+x+", "+y+")";
    }
}
