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
    
    public Controller(AsciiPaint asciiPaint, View view) {
        this.asciiPaint = asciiPaint;
        this.view = view;
    }
    
    public void beginning ()
    {
        view.beginning();
        String[] t = {"add", "square", "10", "10", "5", "y"};
        addShowExit(t, asciiPaint);
    }
    
    public boolean addShowExit (String [] t, AsciiPaint paint)
    {
        boolean keepingOn = true;
        
        switch (t[0].toLowerCase()) {
            
            case "add" :
                if (t.length < 2) {
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
                view.error();;
                break;
        }
        return keepingOn;
    }
    
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
                    view.error();
                    break;
            }
        } catch (Exception e)
        {
            this.view.error();
            view.doNext();
        }
    }
    
    public void drawSquare (String [] t, AsciiPaint paint)
    {
        paint.newSquare(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
    
    public void drawRectangle (String [] t, AsciiPaint paint)
    {
        paint.newRectangle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), Double.parseDouble(t[5]), t[6].charAt(0));
    }
    
    public void drawCircle (String [] t, AsciiPaint paint)
    {
        paint.newCircle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
}