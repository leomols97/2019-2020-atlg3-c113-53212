package esi.atl.oo_base;

/**
 *
 * @author leopoldmols
 */
public final class ImmutableCircle1 {
    
    private final double radius;
    private final Point center;

    public ImmutableCircle1(double radius, Point center) {
        if (radius <= 0) {
            System.out.println("Radius must be positive. Received : " + radius);
        }
        this.radius = radius;
        this.center = center;
    }
    
    public void move (double dx, double dy) {
        center.move(dx, dy);
    }
    
    public double area () {
        return Math.PI*radius*radius;
    }
    
    public Point getCenter () {
        return center;
    }
}

class TestCircle1 {

    public static void main(String args[]) {
        System.out.println("TestCircle1");
        Point p = new Point();
        Circle c = new Circle(p, 5);
        System.out.println(c);
        c.move(2, 5);
        System.out.println(c);
        c.scale(2);
        System.out.println(c);
    }
}

class TestDefensiveCopyImmutableCircle1 {

    public static void main(String args[]) {
        System.out.println("TestDefensiveCopyImmutableCircle1");
        Point p = new Point();
        Circle c = new Circle(p, 5);
        System.out.println(c);
        p.move(2, 5); //on bouge le point et non pas le cercle.
        System.out.println(c);
        Point p2 = c.getCenter();
        p2.move(-2, -5);
        System.out.println(c);
    }
}