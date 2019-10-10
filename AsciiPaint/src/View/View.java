package View;

import java.util.Scanner;

/**
 *
 * @author leopoldmols
 */
public class View {
    
    private Scanner in;
    
    /**
     * Constructs a new scanner
     */
    public View ()
    {
        this.in = new Scanner (System.in);
    }
    
    /**
     * Asks the user what he wants to do next
     * @return the String that will correspond to what the user wants the program to do next
     */
    public String doNext ()
    {
//        String ans = "";
//        int ansInt;
//        boolean correctAns = false;

        System.out.println("What do you want to do now ?\n");
//        while (!correctAns)
//        {
        System.out.println("1 - Add a shape (STYLE :\n");
//                    + "SQUARE : \"add square int (upperLeft corner X) int (upperLeft corner Y) double (side length) char (color)\"\n"
//                    + "RECTANGLE : \"add rectangle int (upperLeft corner X) int (upperLeft corner Y) double (width length) double (height length) char (color)\"\n"
//                    + "CIRCLE : \"add circle int (center X) int (center Y) double (radius length) char (color)\")\n");
        System.out.println("2 - Show the grid : \n");
//                    + "show\n");
        System.out.println("3 - Exit : \n");
//                    + "exit\n");
        System.out.print("Your answer : ");
        
        return in.nextLine();
    }       
    /**
     *shows a beginning message and ask the user what he wants to do
     */
    public void beginning ()
    {
        System.out.println("Hello ! Welcome to AsciiPaint.");
        System.out.println("You're on a 30x30 grid and you can add many shapes as you want.");
        //doNext();
    }
    
    /**
     * shows an error message
     */
    public void error ()
    {
        System.out.println("You cannot do that ! (VIEW error())");
        //doNext();
    }
    
    /**
     * shows an error message if the addSquare command is wrongly added and shows how it should be written
     */
    public void errorSquare ()
    {
        System.out.print("You cannot do that ! (VIEW errorSquare)");
        System.out.println("A square must be definied as so : ");
        System.out.println("add square int (upperLeft corner X) int (upperLeft corner Y) double (side length) char (color)");
        //doNext();
    }
    
    /**
     * shows an error message if the addRectangle command is wrongly added and shows how it should be written
     */
    public void errorRectangle ()
    {
        System.out.print("You cannot do that ! (VIEW errorRectangle)");
        System.out.println("A rectangle must be definied as so : ");
        System.out.println("add rectangle int (upperLeft corner X) int (upperLeft corner Y) double (width length) double (height length) char (color)");
        //doNext();
    }
    
    /**
     * shows an error message if the addCircle command is wrongly added and shows how it should be written
     */
    public void errorCircle()
    {
        System.out.print("You cannot do that ! (VIEW errorCircle())");
        System.out.println("A circle must be definied as so : ");
        System.out.println("add circle int (center X) int (center Y) double (radius length) char (color)");
        //doNext();
    }
}