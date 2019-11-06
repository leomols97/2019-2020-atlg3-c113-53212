package Model;

/**
 *
 * @author leopoldmols
 */
public class Male extends Person {

    public Male(int taille, int poids, int age, Sexe sexe, String styleDeVie) {
        super(taille, poids, age, sexe, styleDeVie);
        sexe = Sexe.MALE;
    }
}