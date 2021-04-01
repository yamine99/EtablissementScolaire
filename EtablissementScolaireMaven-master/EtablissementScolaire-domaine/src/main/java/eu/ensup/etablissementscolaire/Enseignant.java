package eu.ensup.etablissementscolaire;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Enseignant.
 */
public class Enseignant extends PersonnePhysique {

    //TODO
    private String matiereEnseigne ;
    private List<Cours>cours= new ArrayList<>();


    /**
     * Instantiates a new Enseignant.
     */
    public Enseignant() {

    }

    /**
     * Instantiates a new Enseignant.
     *
     * @param matiereEnseigne the matiere enseigne
     */
    public Enseignant(String matiereEnseigne) {
        this.matiereEnseigne = matiereEnseigne;
    }

    /**
     * Instantiates a new Enseignant.
     *
     * @param id              the id
     * @param nom             the nom
     * @param email           the email
     * @param adresse         the adresse
     * @param telephone       the telephone
     * @param prenom          the prenom
     * @param motDePasse      the mot de passe
     * @param salt            the salt
     * @param matiereEnseigne the matiere enseigne
     */
    public Enseignant(int id, String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt, String matiereEnseigne) {
        super(id, nom, email, adresse, telephone, prenom, motDePasse, salt);
        this.matiereEnseigne = matiereEnseigne;
    }

    /**
     * Instantiates a new Enseignant.
     *
     * @param nom             the nom
     * @param email           the email
     * @param adresse         the adresse
     * @param telephone       the telephone
     * @param prenom          the prenom
     * @param motDePasse      the mot de passe
     * @param salt            the salt
     * @param matiereEnseigne the matiere enseigne
     */
    public Enseignant( String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt, String matiereEnseigne) {
        super(nom, email, adresse, telephone, prenom, motDePasse, salt);
        this.matiereEnseigne = matiereEnseigne;
    }

    /**
     * Gets matiere enseigne.
     *
     * @return the matiere enseigne
     */
    public String getMatiereEnseigne() {
        return matiereEnseigne;
    }

    /**
     * Sets matiere enseigne.
     *
     * @param matiereEnseigne the matiere enseigne
     */
    public void setMatiereEnseigne(String matiereEnseigne) {
        this.matiereEnseigne = matiereEnseigne;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id='" + this.getId()    + '\'' +
                "nom='" + this.getNom() + '\'' +
                " matiere='" + this.getMatiereEnseigne() + '\'' +
                '}';
    }
}
