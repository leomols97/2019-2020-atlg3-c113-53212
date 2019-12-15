package Models;


/**
 * This class defines the different actions possible by a player.
 * It is here only to display the name of the action
 * 
 * @author leopoldmols
 */

public enum Action
{
    /**
     * The different values of the enumeration
     */
    
    NOUVELLE_PARTIE ("Nouvelle partie"),
    PLACE_PIECE ("Place une pièce"),
    PASSE_TOUR ("Passe son tour");

    private String libelle;

    
    /**
     * Constructs the action belonging the parameter
     * 
     * @param libelle the String that defines the action
     */
    private Action(String libelle)
    {
        this.libelle = libelle;
    }
    
    /**
     * Gets the action NOUVELLE_PARTIE
     * 
     * @return NOUVELLE_PARTIE
     */
    public static Action getNOUVELLE_PARTIE()
    {
        return NOUVELLE_PARTIE;
    }

    /**
     * Gets the action PLACE_PIECE
     * 
     * @return PLACE_PIECE
     */
    public static Action getPLACE_PIECE()
    {
        return PLACE_PIECE;
    }

    /**
     * Gets the action PASSE_TOUR
     * 
     * @return PASSE_TOUR
     */
    public static Action getPASSE_TOUR()
    {
        return PASSE_TOUR;
    }
}