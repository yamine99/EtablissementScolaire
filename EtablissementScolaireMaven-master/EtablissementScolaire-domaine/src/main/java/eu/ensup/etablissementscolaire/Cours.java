package eu.ensup.etablissementscolaire;


import java.util.ArrayList;
import java.util.List;
import eu.ensup.etablissementscolaire.Etudiant;

/**
 * The type Cours.
 */
public class Cours {

    private int id;
    private int nbHeures;

    private String theme;
    private List<Etudiant> etudiants = new ArrayList<Etudiant>();

    /**
     * Instantiates a new Cours.
     *
     * @param theme    the theme
     * @param nbHeures the nb heures
     */
    public Cours(String theme, int nbHeures) {

        this.nbHeures = nbHeures;
        this.theme = theme;
    }


    /**
     * Instantiates a new Cours.
     *
     * @param id       the id
     * @param theme    the theme
     * @param nbHeures the nb heures
     */
    public Cours(int id,String theme, int nbHeures) {
        this.id = id;
        this.nbHeures = nbHeures;
        this.theme = theme;
    }

    /**
     * Instantiates a new Cours.
     */
    public Cours() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets nb heures.
     *
     * @return the nb heures
     */
    public int getNbHeures() {
        return nbHeures;
    }

    /**
     * Sets nb heures.
     *
     * @param nbHeures the nb heures
     */
    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    /**
     * Gets etudiants.
     *
     * @return the etudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * Sets etudiants.
     *
     * @param etudiants the etudiants
     */
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }


    /**
     * Gets theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets theme.
     *
     * @param theme the theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return this.theme + " pendant " + this.nbHeures + " heures";
    }
}
