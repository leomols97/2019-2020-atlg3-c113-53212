package Models;

/**
 *
 * @author leopoldmols
 */
public enum Color {
    WHITE (0),
    BLACK (1);
    
    private final int color;

    private Color(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
