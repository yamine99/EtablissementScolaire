package eu.ensup.etablissementscolaire;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;

/**
 * The type Personne physique service.
 */
public class PersonnePhysiqueService implements IPersonnePhysiqueService{

    private static final String  algo = "SHA-256";

    /**
     * Valid personne physique int.
     *
     * @param p1       the p 1
     * @param password the password
     * @return the int
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public int validPersonnePhysique(PersonnePhysique p1, String password) throws NoSuchAlgorithmException {
        byte[] salt = Base64.getDecoder().decode(p1.getSalt());
        String hash = generateHashPassword(password,salt);
        return hash.equals(p1.getMotDePasse()) ? 1 : 0;
    }


    /**
     * Constante de l'algorithme utilisé pour le hashage des mots de passes.
     */

    @Override
    public String generateHashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algo);
        digest.reset();
        digest.update(salt);
       return Base64.getEncoder().encodeToString(digest.digest(password.getBytes()));
    }

    public  byte[] createSalt(){
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }


}
