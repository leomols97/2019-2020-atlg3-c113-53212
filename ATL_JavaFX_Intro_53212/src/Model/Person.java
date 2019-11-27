package Model;

import java.util.Observable;

/**
 * Creates an object "Person" and processes his BMR and his daily needs in calories
 *
 * @author leopoldmols
 */
public class Person extends Observable{
    
    /**
     * All the data needed to process the BMR and the daily needs in calories
     */
    private double taille;
    private double poids;
    private int age;
    private Sexe sexe;
    private StyleDeVie styleDeVie;
    
    /**
     * Initializes the object "Person"
     * 
     * @param taille the height of the person
     * @param poids the weight of the person
     * @param age the age of the person
     * @param sexe the genre of the person
     * @param styleDeVie the lifeStyle of the person
     */
    public Person(double taille, double poids, int age, Sexe sexe, StyleDeVie styleDeVie) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.sexe = sexe;
        this.styleDeVie = styleDeVie;
    }
    
    public double getTaille() {
        return taille;
    }
    
    public double getPoids() {
        return poids;
    }
    
    public int getAge() {
        return age;
    }
    
    public Sexe getSexe() {
        return sexe;
    }
    
    public StyleDeVie getStyleDeVie() {
        return styleDeVie;
    }
    
    public void setTaille(double taille) {
        this.taille = taille;
    }
    
    public void setPoids(double poids) {
        this.poids = poids;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    
    public void setStyleDeVie(StyleDeVie styleDeVie) {
        this.styleDeVie = styleDeVie;
    }
    
    public void setAll (double taille, double poids, int age, Sexe sexe, StyleDeVie styleDeVie) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.sexe = sexe;
        this.styleDeVie = styleDeVie;
    }
    
    public double getBMR () {
        if (sexe == Sexe.MALE) {
            return 13.7 * poids + 5 * taille - 6.8 * age + 66;
        } else {
            return 9.6 * poids + 1.8 * taille - 4.7 * age + 655;
        }
    }
    
    public double getCalories () {
        return getBMR() * styleDeVie.getFacteur();
    }
}