package Models;


/**
 * This class creates a new Tour 
 * to let it enter in the tableView with the right parameters
 * 
 * @author leopoldmols
 */
public class Tour
{
    private int id; // The id of the row
    private String name; // the name of the player that plays this turn
    private Action action; // The action the player played
    private int row; // The row at which the player placed a piece
    private int column; // The column at which the player placed a piece
    // The number of pieces that the player took from the other one
    private int nbPrises;

    
    /**
     * Constructs a row of the tableView with all those parameters
     * 
     * @param id the id of the row of the tableView
     * @param name the name of the row of the tableView
     * @param action the action of the row of the tableView
     * @param row the row of the row of the tableView
     * @param column the column of the row of the tableView
     * @param nbPrises the nbPrises of the row of the tableView
     */
    public Tour(int id,
            String name,
            Action action,
            int row,
            int column,
            int nbPrises)
    {
        this.id =  id;
        this.name = name;
        this.action = action;
        this.row = row;
        this.column = column;
        this.nbPrises = nbPrises;
    }
    

    /**
     * Gets the id of the row of the tableView
     * 
     * @return the id
     */
    public int getId()
    {
        return id;
    }
    
    
    /**
     * Gets the name of the row of the tableView
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    
    /**
     * Gets the action of the row of the tableView
     * 
     * @return the action
     */
    public Action getAction()
    {
        /*if (id == 0)
        {
            return action.NOUVELLE_PARTIE;
        }*/
        return action;
    }

    
    /**
     * Gets the row of the row of the tableView
     * 
     * @return the row
     */
    public int getRow()
    {
        return row;
    }

    
    /**
     * Gets the column of the row of the tableView
     * 
     * @return the column
     */
    public int getColumn()
    {
        return column;
    }

    /**
     * Gets the number of flipped pieces of the row of the tableView
     * 
     * @return the number of flipped pieces
     */
    public int getNbPrises()
    {
        return nbPrises;
    }
}