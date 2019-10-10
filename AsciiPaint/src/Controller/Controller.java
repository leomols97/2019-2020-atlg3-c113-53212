package Controller;

import Models.AsciiPaint;
import View.View;

/**
 *
 * @author leopoldmols
 */
public class Controller {
    
    private final AsciiPaint asciiPaint;
    private final View view;
    
    /**
     * Constructs the controller
     * @param asciiPaint of AsciiPaint type
     * @param view of view type
     */
    public Controller(AsciiPaint asciiPaint, View view) {
        this.asciiPaint = asciiPaint;
        this.view = view;
    }
    
    /**
     * Begins a game and purpose a table example
     */
    public void beginning ()
    {
        view.beginning();
        String[] t = {"add", "square", "10", "10", "5", "y"};
        addShowExit(t, asciiPaint);
//        view.doNext();
    }
    
    /**
     * Analyses the first part of the command entered by the user
     * @param t a table of String
     * @param paint of AsciiPaint type
     * @return true if the command isn't "exit"
     */
    public boolean addShowExit (String [] t, AsciiPaint paint)
    {
        boolean keepingOn = true;
        
        switch (t[0].toLowerCase()) {
            case "add" :
                if (t.length < 2) {
                    System.out.println("CONTROLLER addshowexit add error");
                    view.error();
                    break;
                }
                newShape(t, paint);
                break;
            case "show" :
                System.out.println(paint.asAscii());
                break;
            case "exit" :
                keepingOn = false;
                break;
            default :
                System.out.println("CONTROLLER addshowexit default error");
                view.error();;
                break;
        }
        return keepingOn;
    }
    
    /**
     * Constructs a shape belonging the second argument of the table t
     * @param t a table of String
     * @param asciiPaint of AsciiPaint type
     */
    public void newShape (String [] t, AsciiPaint asciiPaint)
    {
        try
        {
            switch (t[1].toLowerCase())
            {
                case "square" :
                    if (t.length < 6)
                    {
                        view.errorSquare();
                    }
                    //if (view.doNext() == 1) {
                    drawSquare(t, asciiPaint);
                    //}
                    break;
                case "rectangle" :
                    if (t.length < 7)
                    {
                        view.errorRectangle();
                    }
                    //if (view.doNext() == 1) {
                    drawRectangle(t, asciiPaint);
                    //}
                    break;
                case "circle" :
                    if (t.length < 6)
                    {
                        view.errorCircle();
                    }
                    //if (view.doNext() == 1) {
                    drawCircle(t, asciiPaint);
                    //}
                    break;
                default :
                    System.out.println("CONTROLLER newShape viewError()");
                    view.error();
                    break;
            }
        } catch (Exception e)
        {
            System.out.println("CONTROLLER newShape()");
            this.view.error();
            view.doNext();
        }
    }
    
    /**
     * Draw a square with the rest of the parameters
     * @param t the arguments needed for the parameters of the Square
     * @param paint of AsciiPaint
     */
    public void drawSquare (String [] t, AsciiPaint paint)
    {
        paint.newSquare(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
    
    /**
     * Draw a square with the rest of the parameters
     * @param t the arguments needed for the parameters of the Rectangle
     * @param paint of AsciiPaint
     */
    public void drawRectangle (String [] t, AsciiPaint paint)
    {
        paint.newRectangle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), Double.parseDouble(t[5]), t[6].charAt(0));
    }
    
    /**
     * Draw a square with the rest of the parameters
     * @param t the arguments needed for the parameters of the Circle
     * @param paint of AsciiPaint
     */
    public void drawCircle (String [] t, AsciiPaint paint)
    {
        paint.newCircle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
}