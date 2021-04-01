package eu.ensup.etablissementscolaire;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Etudiant.
 */
public class Etudiant extends PersonnePhysique{

    private java.sql.Date dateNaissance;
    private List<Cours> cours = new ArrayList<Cours>();

    /**
     * Instantiates a new Etudiant.
     *
     * @param id            the id
     * @param nom           the nom
     * @param email         the email
     * @param adresse       the adresse
     * @param telephone     the telephone
     * @param prenom        the prenom
     * @param motDePasse    the mot de passe
     * @param salt          the salt
     * @param dateNaissance the date naissance
     */
    public Etudiant(int id,String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt, java.sql.Date dateNaissance) {
        super(id, nom, email, adresse, telephone, prenom, motDePasse, salt);

        this.dateNaissance = dateNaissance;
    }

    /**
     * Instantiates a new Etudiant.
     *
     * @param nom           the nom
     * @param email         the email
     * @param adresse       the adresse
     * @param telephone     the telephone
     * @param prenom        the prenom
     * @param motDePasse    the mot de passe
     * @param salt          the salt
     * @param dateNaissance the date naissance
     */
    public Etudiant(String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt, java.sql.Date dateNaissance) {
        super( nom, email, adresse, telephone, prenom, motDePasse, salt);

        this.dateNaissance = dateNaissance;
    }


    /**
     * Instantiates a new Etudiant.
     */
    public Etudiant() {
    }


    /**
     * Gets date naissance.
     *
     * @return the date naissance
     */
    public java.sql.Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Sets date naissance.
     *
     * @param dateNaissance the date naissance
     */
    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Gets cours.
     *
     * @return the cours
     */
    public List<Cours> getCours() {
        return cours;
    }

    /**
     * Sets cours.
     *
     * @param cours the cours
     */
    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }


    @Override
    public String toString() {
        String res = super.toString() + "Etudiant{" +
                "dateNaissance=" + dateNaissance +
                ", cours=" + cours +
                '}';

        return this.getNom()+" "+this.getPrenom() ;


    }

}
