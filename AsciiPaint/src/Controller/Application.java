package Controller;

import Models.AsciiPaint;
import View.View;

/**
 *
 * @author leopoldmols
 */
public class Application {
    
    private AsciiPaint paint;
    private View v = new View();
    private Controller c = new Controller(paint, v);
    
    /**
     * Starts the game by creating a new controller and beginning it
     */
    public void start(){
//        Controller c = new Controller(paint, v);
//        c.beginning();
        String command;
        String [] t;
        boolean continuing = true;
        v.beginning();
        
        while (continuing) {            
            command = v.doNext();
            t = command.split(" ");
            continuing = c.addShowExit(t, this.paint);
        }
    }
    
    /**
     * Implements the start() method
     * @param args
     */
    public static void main(String[] args)
    {
        Application app = new Application();
        app.start();
    }
}