package Models;

import java.util.List;

/**
 *
 * @author leopoldmols
 */
public class Game implements Model{
    
    private Board board;
    private Player current;
    private Player oponent;
    private Position selected;
    
    public Game()
    {
        current = new Player(Color.WHITE);
        oponent = new Player(Color.BLACK);
    }
    
    @Override
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
    
    /**
     * This methods overrides the methods "start()" received from the class Model and verifies if the playing board exists and
     * if any piece is over any other piece via the following method in this class
     *
     * This method throws a IllegalStateException("Le plateau de jeu n'a pas été initialisé !") if the board doesn't exist
     * This method throws a IllegalArgumentException("La partie est terminée !") if the game is finished
     */
    @Override
    public void start() {
        if (board == null) {
            throw new IllegalStateException("Le plateau de jeu n'a pas été initialisé !");
        }
        if (isOver() == true) {
            throw new IllegalArgumentException("La partie est terminée !");
        }
    }

    @Override
    public boolean isOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Square[][] getBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void select(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Piece getSelected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player getCurrent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Player> getWinners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Player> getLoosers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}