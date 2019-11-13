package View;

/**
 *
 * @author leopoldmols
 */
public enum StyleDeVie {
    SEM1 ("Sédentaire"),
    SEM2 ("Peu actif"),
    SEM3 ("Actif"),
    SEM4 ("Fort actif"),
    SEM5 ("Extrêmement actif");
    
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