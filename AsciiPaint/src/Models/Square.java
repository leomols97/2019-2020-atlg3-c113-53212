package Models;

/**
 *
 * @author leopoldmols
 */
public class Square extends Rectangle {
    
    /**
     * Constructs a Square
     * @param upperLeft the Square upperleft corner point
     * @param side the length of the square side
     * @param color the color of the square
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }
}