package eu.ensup.etablissementscolaire;

import java.sql.SQLException;
import java.util.Set;

import eu.ensup.etablissementscolaire.exceptions.DaoException;


/**
 * The interface Responsable dao.
 */
public interface IResponsableDao extends IDao<Responsable>
{
	/**
	 * Gets credential by email.
	 *
	 * @param email the email
	 * @return the credential by email
	 * @throws DaoException the dao exception
	 */
	Responsable getCredentialByEmail(String email) throws DaoException;

}