package Models;

/**
 *
 * @author leopoldmols
 */
public class Point {
    
    private  double x;
    private  double y;
    
    public Point(double x, double y)
    {
        // System.out.println(" test " );
        this.x = x;
        this.y = y;
    }
    
    public double getX() { return x; }
    public double getY() { return y; }
    
    public Point move(double dx, double dy)
    {
        x += dx;
        y += dy;
        return this;
    }
    
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
