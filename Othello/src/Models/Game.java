package Models;

/**
 *
 * @author leopoldmols
 */
public class Game {
    
    private Board board;
    private Player current;
    private Player oponent;
    private Position selected;
    
    public Game()
    {
        current = new Player(Color.WHITE);
        oponent = new Player(Color.BLACK);
    }
    
    public void initialize()
    {
        this.board = new Board ();
        
        Piece p1 = new Piece(current.getColor());
        Piece p2 = new Piece(current.getColor());
        Piece p3 = new Piece(current.getColor());
        Piece p4 = new Piece(current.getColor());
        
        Position posp1 = new Position(5, 5);
        Position posp2 = new Position(5, 6);
        Position posp3 = new Position(6, 5);
        Position posp4 = new Position(6, 6);
        
        
    }
    
}
