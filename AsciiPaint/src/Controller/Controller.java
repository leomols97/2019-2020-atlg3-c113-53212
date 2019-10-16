package Controller;

import Models.AsciiPaint;
import View.View;
import java.util.Arrays;

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
    
//    /**
//     * Begins a game and purpose a table example
//     */
//    public void beginning ()
//    {
//        view.beginning();
//        String[] t = {"add", "square", "10", "10", "5", "y"};
//        addShowExit(t, asciiPaint);       
//    }
    
//    /**
//     * Asks the user what he wants to do next
//     * @return a number that will correspond to what the user wants the program to do next
//     */
//    public int doNext ()
//    {
//        String ans = "";
//        int ansInt;
//        boolean correctAns = false;
//        
//        System.out.println("What do you want to do now ?\n");
//        while (!correctAns)
//        {
//            System.out.println("1 - Add a shape (STYLE :\n"
//                    + "SQUARE : \"add square int (upperLeft corner X) int (upperLeft corner Y) double (side length) char (color)\"\n"
//                    + "RECTANGLE : \"add rectangle int (upperLeft corner X) int (upperLeft corner Y) double (width length) double (height length) char (color)\"\n"
//                    + "CIRCLE : \"add circle int (center X) int (center Y) double (radius length) char (color)\")\n");
//            System.out.println("2 - Show the grid : \n"
//                    + "show\n");
//            System.out.println("3 - Exit : \n"
//                    + "exit\n");
//            System.out.print("Your answer : ");
//            try
//            {
//                ans = in.nextLine();
//                ansInt = Integer.parseInt(ans);
//                switch (ansInt)
//                {
//                    case 1 :
//                    case 2 :
//                    case 3 :
//                        correctAns = true;
//                        return ansInt;
//                    default :
//                        System.out.println("You cannot do that ! (default doNext())");
//                        correctAns = false;
//                        break;
//                }
//            } catch (Exception e)
//            {
//                System.out.println("You cannot do that ! (VIEW catch doNext())");
//            }
//        }
//        return 0;
//    }
    
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
                System.out.println("CONTROLLER addShowExit default error");
                view.error();
                break;
        }
        return keepingOn;
    }
    
    
    public void readSquareCom (String [] t, AsciiPaint paint)
    {
        paint.newSquare(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
    
    public void readRectangleCom (String [] t, AsciiPaint paint)
    {
        paint.newRectangle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), Double.parseDouble(t[5]), t[6].charAt(0));
    }
    
    public void readCircleCom (String [] t, AsciiPaint paint)
    {
        paint.newCircle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
    
    /**
     * Constructs a shape belonging the second argument of the table t
     * @param t a table of String
     * @param paint
     */
    public void newShape (String [] t, AsciiPaint paint)
    {
        try
        {         
            System.out.println(paint);
            switch (t[1].toLowerCase())
            {
                case "square" :
                    if (t.length < 6)
                    {
                        view.errorSquare();
                    }
                    //if (view.doNext() == 1) {
                    readSquareCom(t, paint);
//                    drawSquare(t);
                    //}
                    break;
                case "rectangle" :
                    if (t.length < 7)
                    {
                        view.errorRectangle();
                    }
                    //if (view.doNext() == 1) {
                    readRectangleCom(t, paint);
//                    drawRectangle(t);
                    //}
                    break;
                case "circle" :
                    if (t.length < 6)
                    {
                        view.errorCircle();
                    }
                    //if (view.doNext() == 1) {
                    readCircleCom(t, paint);
//                    drawCircle(t);
                    //}
                    break;
                default :
                    System.out.println("CONTROLLER newShape viewError()");
                    view.error();
                    break;
            }
        }catch (Exception e)
        {
            System.out.println(e);
            System.out.println("CONTROLLER newShape()");
            this.view.error();
            view.doNext();
        }
    }
    
    /**
     * Draw a square with the rest of the parameters
     * @param t the arguments needed for the parameters of the Square
     */
    public void drawSquare (String [] t)
    {
        this.asciiPaint.newSquare(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
    
    /**
     * Draw a square with the rest of the parameters
     * @param t the arguments needed for the parameters of the Rectangle
     */
    public void drawRectangle (String [] t)
    {
        this.asciiPaint.newRectangle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), Double.parseDouble(t[5]), t[6].charAt(0));
    }
    
    /**
     * Draw a square with the rest of the parameters
     * @param t the arguments needed for the parameters of the Circle
     */
    public void drawCircle (String [] t)
    {
        this.asciiPaint.newCircle(Integer.parseInt(t[2]), Integer.parseInt(t[3]), Double.parseDouble(t[4]), t[5].charAt(0));
    }
}