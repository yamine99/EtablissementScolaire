package eu.ensup.etablissementscolaire;
import java.util.Set;

import eu.ensup.etablissementscolaire.exceptions.DaoException;


/**
 * The interface Cours dao.
 */
public interface ICoursDao extends IDao<Cours>
{
    /**
     * Inscription int.
     *
     * @param c the c
     * @param e the e
     * @return the int
     * @throws DaoException the dao exception
     */
    int inscription(Cours c, Etudiant e) throws DaoException;

    /**
     * Gets cours etudiant.
     *
     * @param idEtudiant the id etudiant
     * @return the cours etudiant
     * @throws DaoException the dao exception
     */
    Set<Cours> getCoursEtudiant(int idEtudiant) throws DaoException;

}
