package Model;

/**
 *
 * @author leopoldmols
 */
class Person {
    
    private int taille;
    private int poids;
    private int age;
    private Sexe sexe;
    private String styleDeVie;

    public Person(int taille, int poids, int age, Sexe sexe, String styleDeVie) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.sexe = sexe;
        this.styleDeVie = styleDeVie;
    }

    public int getTaille() {
        return taille;
    }

    public int getPoids() {
        return poids;
    }

    public int getAge() {
        return age;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getStyleDeVie() {
        return styleDeVie;
    }
    
    
}
