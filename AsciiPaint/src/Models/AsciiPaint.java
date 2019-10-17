package Models;

/**
 *
 * @author leopoldmols
 */
public class AsciiPaint {
    
    private Drawing drawing;

    /**
     * Initializes a new drawing
     */
    public AsciiPaint()
    {
        drawing = new Drawing();
    }
    
    /**
     * Initializes a new drawing
     * @param width the width of the initialized drawing
     * @param height the heght of the initialized drawing
     */
    public AsciiPaint(int width, int height)
    {
        drawing = new Drawing(height, width);
    }

    /**
     * Looks for the color of the shape that stands on the point p
     * @param p the shape at this point
     * @return 
     * @returns the color
     */
    public char getColor (Point p)
    {
        return drawing.getShapeAt(p).getColor();
    }
    
    /**
     * Creates a new Circle
     * @param x the abscissa of the circle center
     * @param y the ordered of the circle center
     * @param radius the circle radius
     * @param color the circle color
     */
    public void newCircle (int x, int y, double radius, char color)
    {
        Point p = new Point(x, y);
        Circle c = new Circle(p, radius, color);
        drawing.addShape(c);
    }
    
    /**
     * Creates a new Rectangle
     * @param x the abscissa of the upper left rectangle corner
     * @param y the ordered of the upper left rectangle corner
     * @param width the rectangle width
     * @param height the rectangle height
     * @param color the rectangle color
     */
    public void newRectangle (int x, int y, double width, double height, char color)
    {
        Point p = new Point(x, y);
        Rectangle r = new Rectangle(p, width, height, color);
        drawing.addShape(r);
    }
    
    /**
     * Creates a new Square
     * @param x the abscissa of the upper left square corner
     * @param y the ordered of the upper left square corner
     * @param side the square side length
     * @param color the square color
     */
    public void newSquare (int x, int y, double side, char color)
    {
        Point p = new Point(x, y);
        Square s = new Square(p, side, color);
        drawing.addShape(s);
    }
    
    /**
     * Shwos the paint
     * @return a String that shows correctly all the different shapes
     */
    public String asAscii()
    {
        // APA : StringBuilder/StringBuffer
        String display = "";
        for (int i = 0; i < drawing.getWidth(); i++) {
            for (int j = 0; j < drawing.getHeight(); j++) {
                Point p = new Point(i, j);
                Shape s = drawing.getShapeAt(p);
                if (s == null) {
                    display += " ";
                } else {
                    display += s.getColor();
                }
            }
            // APA 
                            display+="\n";

        }
        return display;
    }
}
