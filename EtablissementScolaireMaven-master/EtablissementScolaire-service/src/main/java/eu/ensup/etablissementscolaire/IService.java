package eu.ensup.etablissementscolaire;

import java.util.Set;

import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.*;
import eu.ensup.etablissementscolaire.exception.directeurExceptions.*;
import eu.ensup.etablissementscolaire.exception.enseignantExceptions.*;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.*;

/**
 * The interface Service.
 *
 * @param <T> the type parameter
 */
public interface IService<T>
{
	/**
	 * Create int.
	 *
	 * @param entity the entity
	 * @return the int
	 * @throws ServiceException the service exception
	 */
	int create(T entity) throws ServiceException, CredentialException, AddCoursServiceException, CredentialException, AddDirecteurServiceException, AddEnseignantServiceException, AddEtudiantServiceException;

	/**
	 * Update int.
	 *
	 * @param entity the entity
	 * @return the int
	 * @throws ServiceException the service exception
	 */
	int update(T entity) throws ServiceException, UpdateCoursServiceException, UpdateDirecteurServiceException, UpdateDirecteurServiceException, UpdateEnseignantServiceException, UpdateEtudiantServiceException;

	/**
	 * Delete int.
	 *
	 * @param indice the indice
	 * @return the int
	 * @throws ServiceException the service exception
	 */
	int delete(int indice) throws ServiceException, DeleteCoursServiceException, DeleteDirecteurServiceException, DeleteDirecteurServiceException, DeleteEnseignantServiceException, DeleteEtudiantServiceException;

	/**
	 * Get t.
	 *
	 * @param indice the indice
	 * @return the t
	 * @throws ServiceException the service exception
	 */
	T get(int indice) throws ServiceException, GetCoursServiceException, GetDirecteurServiceException, GetDirecteurServiceException, GetEnseignantServiceException, GetEtudiantServiceException;

	/**
	 * Gets all.
	 *
	 * @return the all
	 * @throws ServiceException the service exception
	 */
	Set<T> getAll() throws ServiceException, GetAllCoursServiceException, GetAllDirecteurServiceException, GetAllDirecteurServiceException, GetAllEnseignantServiceException, GetAllEtudiantServiceException;
}
