package View;

import java.util.Scanner;

/**
 *
 * @author leopoldmols
 */
public class View {
    
    private Scanner in;
    
    public View ()
    {
        this.in = new Scanner (System.in);
    }
    
    public void doNext ()
    {
        System.out.println("What do you want to do now ?");
        System.out.println("1 - Add a shape");
        System.out.println("2 - Show the grid");
        System.out.println("3 - Exit");
    }
    
    public void beginning () 
    {
        System.out.println("Hello ! Welcome to AsciiPaint.");
        System.out.println("You're on a 30x30 grid and you can add many shapes as you want.");
    }
    
    public void error ()
    {
        System.out.print("You cannot do that!");
        doNext();
    }
    
    public void errorSquare ()
    {
        System.out.print("You cannot do that!");
        System.out.println("A square must be definied as so : ");
        System.out.println("add square int (upperLeft corner X) int (upperLeft corner Y) double (side length) char (color)");
        doNext();
    }
    
    public void errorRectangle ()
    {
        System.out.print("You cannot do that!");
        System.out.println("A rectangle must be definied as so : ");
        System.out.println("add rectangle int (upperLeft corner X) int (upperLeft corner Y) double (width length) double (height length) char (color)");
        doNext();
    }
    
    public void errorCircle()
    {
        System.out.print("You cannot do that!");
        System.out.println("A circle must be definied as so : ");
        System.out.println("add circle int (center X) int (center Y) double (radius length) char (color)");
        doNext();
    }
}