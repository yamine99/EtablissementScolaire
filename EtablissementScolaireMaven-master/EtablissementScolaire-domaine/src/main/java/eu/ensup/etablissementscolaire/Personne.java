package eu.ensup.etablissementscolaire;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Personne.
 */
public class Personne {

    private int id;
    private String nom;
    private String email;
    private String adresse;
    private String telephone;

    /**
     * Instantiates a new Personne.
     */
    public Personne() {
    }

    /**
     * Instantiates a new Personne.
     *
     * @param id        the id
     * @param nom       the nom
     * @param email     the email
     * @param adresse   the adresse
     * @param telephone the telephone
     */
    public Personne(int id,String nom, String email, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    /**
     * Instantiates a new Personne.
     *
     * @param nom       the nom
     * @param email     the email
     * @param adresse   the adresse
     * @param telephone the telephone
     */
    public Personne(String nom, String email, String adresse, String telephone) {
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
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
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets adresse.
     *
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse the adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets telephone.
     *
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets telephone.
     *
     * @param telephone the telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "id=" + id + '\n' +
                "nom=" + nom + '\n' +
                "email=" + email + '\n' +
                "adresse=" + adresse + '\n' +
                "telephone=" + telephone + '\n';
    }


}
