package eu.ensup.etablissementscolaire;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Directeur.
 */
public class Directeur extends Responsable {

    private List<Etablissement> etablissements = new ArrayList<>();

    /**
     * Instantiates a new Directeur.
     */
    public Directeur() {
    }

    /**
     * Instantiates a new Directeur.
     *
     * @param id             the id
     * @param nom            the nom
     * @param email          the email
     * @param adresse        the adresse
     * @param telephone      the telephone
     * @param prenom         the prenom
     * @param motDePasse     the mot de passe
     * @param salt           the salt
     * @param etablissements the etablissements
     */
    public Directeur(int id, String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt, List<Etablissement> etablissements) {
        super(id, nom, email, adresse, telephone, prenom, motDePasse, salt);
        this.etablissements = etablissements;
    }

    /**
     * Gets etablissements.
     *
     * @return the etablissements
     */
    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    /**
     * Sets etablissements.
     *
     * @param etablissements the etablissements
     */
    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }


    @Override
    public String toString() {
        return super.toString() + "etablissements=" + etablissements + '\n';
    }
}
