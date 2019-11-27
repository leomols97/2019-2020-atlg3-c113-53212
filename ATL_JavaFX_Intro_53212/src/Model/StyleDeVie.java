package Model;

/**
 *
 * @author leopoldmols
 */
public enum StyleDeVie {
    SEM1 ("Sédentaire", 1.2),
    SEM2 ("Peu actif", 1.375),
    SEM3 ("Actif", 1.55),
    SEM4 ("Fort actif", 1.725),
    SEM5 ("Extrêmement actif", 1.9);
    
    private String style;
    private double facteur;
    private StyleDeVie (String style, double facteur)
    {
        this.style = style;
        this.facteur = facteur;
    }
    
    public String getStyleDeVie ()
    {
        return this.style;
    }

    public double getFacteur() {
        return facteur;
    }

    @Override
    public String toString() {
        return style;
    }
}