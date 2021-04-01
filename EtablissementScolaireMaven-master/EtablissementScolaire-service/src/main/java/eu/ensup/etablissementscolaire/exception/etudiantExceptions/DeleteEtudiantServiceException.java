package eu.ensup.etablissementscolaire.exception.etudiantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Delete etudiant service exception.
 */
public class DeleteEtudiantServiceException extends ServiceException {
    /**
     * Instantiates a new Delete etudiant service exception.
     */
    public DeleteEtudiantServiceException() {
        super(BaseService.messageExceptionEtudiantDelete);
        BaseService.logger.info(BaseService.messageExceptionEtudiantDelete);
    }
}
