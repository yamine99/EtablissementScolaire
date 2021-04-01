package eu.ensup.etablissementscolaire;

import java.util.Set;


import eu.ensup.etablissementscolaire.exceptions.DaoException;
/**
 * The interface Dao.
 *
 * @param <T> the type parameter
 */
public interface IDao<T>
{
    /**
     * Create int.
     *
     * @param entity the entity
     * @return the int
     * @throws DaoException the dao exception
     */
    int create(T entity) throws DaoException;

    /**
     * Update int.
     *
     * @param entity the entity
     * @return the int
     * @throws DaoException the dao exception
     */
    int update(T entity) throws DaoException;

    /**
     * Delete int.
     *
     * @param indice the indice
     * @return the int
     * @throws DaoException the dao exception
     */
    int delete(int indice) throws DaoException;

    /**
     * Get t.
     *
     * @param indice the indice
     * @return the t
     * @throws DaoException the dao exception
     */
    T get(int indice) throws DaoException;

    /**
     * Gets all.
     *
     * @return the all
     * @throws DaoException the dao exception
     */
    Set<T> getAll() throws DaoException;
}
