package Models;

/**
 *
 * @author leopoldmols
 */
public enum Action
{
    NOUVELLE_PARTIE ("Nouvelle partie"),
    PLACE_PIECE ("Place une pièce"),
    PASSE_TOUR ("Passe son tour");

    private String libelle;

    private Action(String libelle)
    {
        this.libelle = libelle;
    }
    
    public static Action getNOUVELLE_PARTIE()
    {
        return NOUVELLE_PARTIE;
    }

    public static Action getPLACE_PIECE()
    {
        return PLACE_PIECE;
    }

    public static Action getPASSE_TOUR()
    {
        return PASSE_TOUR;
    }
}