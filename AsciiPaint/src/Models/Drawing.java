package Models;

import java.util.List;

/**
 *
 * @author leopoldmols
 */
public class Drawing {
    
    private  List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Construct a drawing of 30 x 30 points
     */
    public Drawing()
    {
        this.height = 30;
        this.width = 30;
    }

    /**
     * Construct a drawing of "height" height and "width" width
     * @param height the height of the drawing
     * @param width the width of the drawing
     */
    public Drawing(int height, int width)
    {
        this.height = height;
        this.width = width;
    }
    
    /**
     * Adds a shape to the drawing
     * @param shape the shape to add
     */
    public void addShape(Shape shape)
    {
        this.shapes.add(shape);
    }
    
    /**
     * Returns the shape that contains the point recevied as aprameters
     * @param p the point contained in the shape that has to be returned
     * @return the shape
     */
    public Shape getShapeAt (Point p)
    {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Get The height of the drawing
     * @returns the height of the shape
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get The width of the drawing
     * @returns the width of the shape
     */
    public int getWidth() {
        return width;
    }
}
