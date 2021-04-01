package eu.ensup.etablissementscolaire;

/**
 * The type Responsable.
 */
public class Responsable extends PersonnePhysique{

    /**
     * Instantiates a new Responsable.
     */
    public Responsable() {
    }

    /**
     * Instantiates a new Responsable.
     *
     * @param id         the id
     * @param nom        the nom
     * @param email      the email
     * @param adresse    the adresse
     * @param telephone  the telephone
     * @param prenom     the prenom
     * @param motDePasse the mot de passe
     * @param salt       the salt
     */
    public Responsable(int id, String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt) {
        super(id,nom, email, adresse, telephone, prenom, motDePasse, salt);
    }
}
