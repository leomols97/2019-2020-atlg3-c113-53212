package Model;

/**
 * Creates an object "Male"
 * 
 * @author leopoldmols
 */
public class Male extends Person {

    public Male(int taille, int poids, int age, Sexe sexe, StyleDeVie styleDeVie) {
        super(taille, poids, age, sexe, styleDeVie);
        sexe = Sexe.MALE;
    }
}