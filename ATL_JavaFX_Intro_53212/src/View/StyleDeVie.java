package View;

/**
 *
 * @author leopoldmols
 */
public enum StyleDeVie {
    SEM1 ("1 fois par semaine"),
    SEM2 ("2 fois par semaine"),
    SEM3 ("3 fois par semaine"),
    SEM4 ("4 fois par semaine"),
    SEM5 ("5 fois par semaine"),
    SEM6 ("6 fois par semaine"),
    SEM7 ("7 fois par semaine");
    
    private String style;
    private StyleDeVie (String style)
    {
        this.style = style;
    }
    
    public String getStyleDeVie ()
    {
        return this.style;
    }
    
    @Override
    public String toString() 
    {
        return this.style;
    }
}