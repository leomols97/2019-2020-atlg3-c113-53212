package esi.atl.oo_base;

/**
 *
 * @author leopoldmols
 */
public final class ImmutableCircle2 {
    
    private final ImmutablePoint center;
    private final double radius;
    
    public ImmutableCircle2(ImmutablePoint center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    public void move (double dx, double dy) {
        center.move(dx, dy);
    }
    
    public double area () {
        return Math.PI*radius*radius;
    }
    
    public ImmutablePoint getCenter () {
        return center;
    }
}

class TestCircle2 {
    
    public static void main(String args[]) {
        System.out.println("TestCircle2");
        Point p = new Point();
        Circle c = new Circle(p, 5);
        System.out.println(c);
        c.move(2, 5);
        System.out.println(c);
        c.scale(2);
        System.out.println(c);
    }
}

class TestDefensiveCopyImmutableCircle2 {
    
    public static void main(String args[]) {
        System.out.println("TestDefensiveCopyImmutableCircle2");
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
