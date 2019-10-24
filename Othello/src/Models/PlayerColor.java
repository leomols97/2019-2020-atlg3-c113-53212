package Models;

/**
 *
 * @author leopoldmols
 */
public enum PlayerColor {
    WHITE (0),
    BLACK (1);
    
    private final int color;

    private PlayerColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
