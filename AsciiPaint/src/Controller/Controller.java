package Controller;

import Models.AsciiPaint;
import View.View;
import static java.lang.System.exit;

/**
 *
 * @author leopoldmols
 */
public class Controller {
    
    private AsciiPaint asciiPaint;
    private View view;
    
    public Controller(AsciiPaint asciiPaint, View view) {
        this.asciiPaint = asciiPaint;
        this.view = view;
    }
    
    public boolean addShowExit (String [] t, AsciiPaint asciiPaint)
    {
        boolean keepingOn = true;
        
        switch (t[0].toLowerCase()) {
            
            case "add" :
                if (t.length < 2) {
                    view.error();
                    break;
                }
                newSh !!!!!!!!!!!!!!!!!!!!!!!!!!!
                break;
                
            case "show" :
                System.out.println(asciiPaint.asAscii());
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
                    asciiPaint.newSquare(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
                    break;
                case "rectangle" :
                    if (t.length < 7)
                    {
                        view.errorRectangle();
                    }
                    asciiPaint.newRectangle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), Double.parseDouble(t[5]), t[6].charAt(0));
                    break;
                case "circle" :
                    if (t.length < 6)
                    {
                        view.errorCircle();
                    }
                    asciiPaint.newCircle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
                    break;
                default :
                    view.error();
                    break;
            }
        } catch (Exception e)
        {
            
            this.view.error();
        }
    }
}