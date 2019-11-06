package Model;

/**
 *
 * @author leopoldmols
 */
public class Female extends Person{
    
    public Female(int taille, int poids, int age, Sexe sexe, String styleDeVie) {
        super(taille, poids, age, sexe, styleDeVie);
        sexe = Sexe.FEMALE;
    }
}