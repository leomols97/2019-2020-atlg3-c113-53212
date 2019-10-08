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
     * @returns the color
     */
    public char getColor (Point p)
    {
        return drawing.getShapeAt(p).getColor();
    }
    
    /**
     *
     * @param x
     * @param y
     * @param radius
     * @param color
     */
    public void newCircle (int x, int y, double radius, char color)
    {
        Point p = new Point(x, y);
        Circle c = new Circle(p, radius, color);
        drawing.addShape(c);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public void newRectangle (int x, int y, double width, double height, char color)
    {
        Point p = new Point(x, y);
        Rectangle r = new Rectangle(p, width, height, color);
        drawing.addShape(r);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param side
     * @param color
     */
    public void newSquare (int x, int y, double side, char color)
    {
        Point p = new Point(x, y);
        Rectangle r = new Rectangle(p, x, y, color);
        drawing.addShape(r);
    }
    
    /**
     *
     * @return
     */
    public String asAscii()
    {
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
            System.out.println("\n");
        }
        return display;
    }
}
