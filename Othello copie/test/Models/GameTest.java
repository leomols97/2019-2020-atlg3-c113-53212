package Models;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldmols
 */
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of initialize method, of class Game.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Game g = new Game();
        Piece[][] expResult = new Piece[8][8];
        Piece[][] result = g.getBoard();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getCurrent method, of class Game.
     */
    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        Game instance = new Game();
        Player expResult = null;
        Player result = instance.getCurrent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePlayer method, of class Game.
     */
    @Test
    public void testChangePlayer() {
        System.out.println("changePlayer");
        Game instance = new Game();
        instance.changePlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canPlaceSmw method, of class Game.
     */
    @Test
    public void testCanPlaceSmw() {
        System.out.println("canPlaceSmw");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.canPlaceSmw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class Game.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Color color = null;
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getScore(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Position position = new Position(5, 7);
        Game game = new Game();
        game.initialize();
        game.play(position);
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Game instance = null;
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPiece method, of class Game.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Position pos = null;
        Game instance = null;
        Piece expResult = null;
        Piece result = instance.getPiece(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFree method, of class Game.
     */
    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Position pos = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.isFree(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canPlay method, of class Game.
     */
    @Test
    public void testCanPlay() {
        System.out.println("canPlay");
        Position position = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.canPlay(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of possiblePositions method, of class Game.
     */
    @Test
    public void testPossiblePositions() {
        System.out.println("possiblePositions");
        Position position = null;
        Game instance = null;
        List<Position> expResult = null;
        List<Position> result = instance.possiblePositions(position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class Game.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        Observer obs = null;
        Game instance = null;
        instance.registerObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class Game.
     */
    @Test
    public void testRemoveObserver() {
        System.out.println("removeObserver");
        Observer obs = null;
        Game instance = null;
        instance.removeObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class Game.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        Game instance = null;
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbWhites method, of class Game.
     */
    @Test
    public void testGetNbWhites() {
        System.out.println("getNbWhites");
        Game instance = null;
        int expResult = 0;
        int result = instance.getNbWhites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbPieces method, of class Game.
     */
    @Test
    public void testGetNbPieces() {
        System.out.println("getNbPieces");
        Game instance = null;
        double expResult = 0.0;
        double result = instance.getNbPieces();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbCases method, of class Game.
     */
    @Test
    public void testGetNbCases() {
        System.out.println("getNbCases");
        Game instance = null;
        double expResult = 0.0;
        double result = instance.getNbCases();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasStrikes method, of class Game.
     */
    @Test
    public void testHasStrikes() {
        System.out.println("hasStrikes");
        Color color = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.hasStrikes(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onlyOneColor method, of class Game.
     */
    @Test
    public void testOnlyOneColor() {
        System.out.println("onlyOneColor");
        Color color = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.onlyOneColor(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTours method, of class Game.
     */
    @Test
    public void testGetTours() {
        System.out.println("getTours");
        Game instance = null;
        List<Tour> expResult = null;
        List<Tour> result = instance.getTours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placePieceRowTable method, of class Game.
     */
    @Test
    public void testPlacePieceRowTable() {
        System.out.println("placePieceRowTable");
        Game instance = null;
        instance.placePieceRowTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passRowTable method, of class Game.
     */
    @Test
    public void testPassRowTable() {
        System.out.println("passRowTable");
        Game instance = null;
        instance.passRowTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOponent method, of class Game.
     */
    @Test
    public void testGetOponent() {
        System.out.println("getOponent");
        Game instance = null;
        Player expResult = null;
        Player result = instance.getOponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbPiecesGot method, of class Game.
     */
    @Test
    public void testNbPiecesGot() {
        System.out.println("nbPiecesGot");
        Position position = null;
        Color color = null;
        Game instance = null;
        int expResult = 0;
        int result = instance.nbPiecesGot(position, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
