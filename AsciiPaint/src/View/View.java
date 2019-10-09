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
    
    public int doNext ()
    {
        String ans = "";
        int ansInt;
        boolean correctAns = false;
        
        System.out.println("What do you want to do now ?");
        while (!correctAns)
        {
            System.out.println("1 - Add a shape");
            System.out.println("2 - Show the grid");
            System.out.println("3 - Exit");
            System.out.print("Your answer : ");
            try
            {
                ans = in.nextLine();
                ansInt = Integer.parseInt(ans);
                switch (ansInt)
                {
                    case 1 :
                        correctAns = true;
                        return 1;
                    case 2 :
                        correctAns = true;
                        return 2;
                    case 3 :
                        correctAns = true;
                        return 3;
                    default :
                        System.out.println("You cannot do that !");
                        correctAns = false;
                        break;
                }
            } catch (NumberFormatException e)
            {
                System.out.println("You cannot do that !");
            }
        }
        return 0;
    }
    
    public void beginning ()
    {
        System.out.println("Hello ! Welcome to AsciiPaint.");
        System.out.println("You're on a 30x30 grid and you can add many shapes as you want.");
        doNext();
    }
    
    public void error ()
    {
        System.out.println("You cannot do that!");
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