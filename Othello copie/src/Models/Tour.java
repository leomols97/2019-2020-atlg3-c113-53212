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
 
   public Tour(int id, String name, Action action, int row, int column, int nbPrises)
   {
       this.id = id;
       this.name = name;
       this.action = action;
       this.row = row;
       this.column = column;
       this.nbPrises = nbPrises;
   }
 
   public int getId()
   {
       return id;
   }
 
   /*public void setId(int id)
   {
       this.id = id;
   }*/
 
   public String getName()
   {
       return name;
   }
 
   public void setName(String name)
   {
       this.name = name;
   }
 
   public Action getAction()
   {
       return action;
   }
 
   public void setAction(Action action)
   {
       this.action = action;
   }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getNbPrises()
    {
        return nbPrises;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setNbPrises(int nbPrises)
    {
        this.nbPrises = nbPrises;
    }
}