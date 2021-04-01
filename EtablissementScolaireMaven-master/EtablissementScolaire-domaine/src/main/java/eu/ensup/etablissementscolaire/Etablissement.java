package eu.ensup.etablissementscolaire;

/**
 * The type Etablissement.
 */
public class Etablissement extends Personne {

    /**
     * The Directeur.
     */
    Directeur directeur;

    /**
     * Instantiates a new Etablissement.
     */
    public Etablissement() {
    }


    /**
     * Gets directeur.
     *
     * @return the directeur
     */
    public Directeur getDirecteur() {
        return directeur;
    }

    /**
     * Sets directeur.
     *
     * @param directeur the directeur
     */
    public void setDirecteur(Directeur directeur) {
        this.directeur = directeur;
    }
}
