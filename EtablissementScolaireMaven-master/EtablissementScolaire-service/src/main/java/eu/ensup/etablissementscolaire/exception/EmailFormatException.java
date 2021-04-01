package eu.ensup.etablissementscolaire.exception;

/**
 * The type Email format exception.
 */
public class EmailFormatException extends Exception {
    /**
     * Instantiates a new Email format exception.
     */
    public EmailFormatException() {
        super("L'email doit être au format xxx@xxx.xx ");
    }
}
