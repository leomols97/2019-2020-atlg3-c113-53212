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
    
    public static void start(){
        Controller c = new Controller(paint, v);
        c.beginning();
    }
    
    public static void main(String[] args) {
        start();
    }
}
