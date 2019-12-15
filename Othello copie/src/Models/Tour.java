package Models;

/**
 *
 * @author leopoldmols
 */
public class Tour
{
 
   private int id;
   private String name;
   private Action action;
   private int row;
   private int column;
   private int nbPrises;
 
    /**
     *
     * @param id
     * @param name
     * @param action
     * @param row
     * @param column
     * @param nbPrises
     */
    public Tour(int id, String name, Action action, int row, int column, int nbPrises)
   {
       this.id = id;
       this.name = name;
       this.action = action;
       this.row = row;
       this.column = column;
       this.nbPrises = nbPrises;
   }
 
    /**
     *
     * @return
     */
    public int getId()
   {
       return id;
   }
 
   /*public void setId(int id)
   {
       this.id = id;
   }*/

    /**
     *
     * @return
     */

 
   public String getName()
   {
       return name;
   }
 
    /**
     *
     * @param name
     */
    public void setName(String name)
   {
       this.name = name;
   }
 
    /**
     *
     * @return
     */
    public Action getAction()
   {
       return action;
   }
 
    /**
     *
     * @param action
     */
    public void setAction(Action action)
   {
       this.action = action;
   }

    /**
     *
     * @return
     */
    public int getRow()
    {
        return row;
    }

    /**
     *
     * @return
     */
    public int getColumn()
    {
        return column;
    }

    /**
     *
     * @param row
     */
    public void setRow(int row)
    {
        this.row = row;
    }

    /**
     *
     * @param column
     */
    public void setColumn(int column)
    {
        this.column = column;
    }

    /**
     *
     * @return
     */
    public int getNbPrises()
    {
        return nbPrises;
    }

    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     *
     * @param nbPrises
     */
    public void setNbPrises(int nbPrises)
    {
        this.nbPrises = nbPrises;
    }
}