package eu.ensup.etablissementscolaire;

/**
 * The type Personne physique.
 */
public class PersonnePhysique extends Personne {

    private String prenom;
    private String motDePasse;
    private String salt;

    /**
     * Instantiates a new Personne physique.
     */
    public PersonnePhysique() {
    }

    /**
     * Instantiates a new Personne physique.
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
    public PersonnePhysique(int id,String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt) {
        super(id,nom, email, adresse, telephone);
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.salt = salt;
    }

    /**
     * Instantiates a new Personne physique.
     *
     * @param nom        the nom
     * @param email      the email
     * @param adresse    the adresse
     * @param telephone  the telephone
     * @param prenom     the prenom
     * @param motDePasse the mot de passe
     * @param salt       the salt
     */
    public PersonnePhysique(String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt) {
        super(nom, email, adresse, telephone);
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.salt = salt;
    }

    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param prenom the prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Gets mot de passe.
     *
     * @return the mot de passe
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Sets mot de passe.
     *
     * @param motDePasse the mot de passe
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Gets salt.
     *
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Sets salt.
     *
     * @param salt the salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {

        return super.toString() + "prenom=" + prenom + '\n' +
                "mot de passe=" + motDePasse + '\n' +
                "salt=" + salt + '\n' ;
    }
}
