package eu.ensup.etablissementscolaire.exception;

/**
 * The type Email format exception.
 */
public class NoteFormatException extends Exception {
    /**
     * Instantiates a new NOTE format exception.
     */
    public NoteFormatException() {
        super("La note doit être des chiffres ");
    }
}
