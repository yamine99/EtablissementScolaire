package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.EmailFormatException;
import eu.ensup.etablissementscolaire.exception.ServiceException;


import java.security.NoSuchAlgorithmException;





/**
 * The interface Responsable service.
 */
public interface IResponsableService extends IService<Responsable>
{
    /**
     * Valid responsable authentification int.
     *
     * @param r        the r
     * @param password the password
     * @return the int
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    int validResponsableAuthentification(Responsable r, String password) throws NoSuchAlgorithmException;

    /**
     * Gets credential by email.
     *
     * @param email the email
     * @return the credential by email
     */
    Responsable getCredentialByEmail(String email) throws ServiceException;

    /**
     * Valid authentification int.
     *
     * @param r        the r
     * @param password the password
     * @return the int
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    int validAuthentification(Responsable r, String password) throws NoSuchAlgorithmException, CredentialException, EmailFormatException;

}
