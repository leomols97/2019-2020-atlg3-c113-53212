package Controller;

import Models.AsciiPaint;
import View.View;

/**
 *
 * @author leopoldmols
 */
public class Application {
    
    private static AsciiPaint paint;
    private static View v = new View();
    
    /**
     * Starts the game by creating a new controller and beginning it
     */
    public static void start(){
        Controller c = new Controller(paint, v);
        c.beginning();
    }
    
    /**
     * Implements the start() method
     * @param args
     */
    public static void main(String[] args) {
        start();
    }
}
