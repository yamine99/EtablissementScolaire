package eu.ensup.etablissementscolaire;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

/**
 * The interface Personne physique service.
 */
public interface IPersonnePhysiqueService {


    /**
     * Generate hash password string.
     *
     * @param password the password
     * @param salt     the salt
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    String generateHashPassword(String password,byte[] salt) throws NoSuchAlgorithmException;

    /**
     * Create salt byte [ ].
     *
     * @return the byte [ ]
     */
    byte[] createSalt();
}
