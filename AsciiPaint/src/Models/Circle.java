package Models;
import asciipaint.Point;

/**
 *
 * @author leopoldmols
 */
public class Circle implements Shape {
    
    @Override
    public Point move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    @Override
    public boolean isInside(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColoredShape getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}