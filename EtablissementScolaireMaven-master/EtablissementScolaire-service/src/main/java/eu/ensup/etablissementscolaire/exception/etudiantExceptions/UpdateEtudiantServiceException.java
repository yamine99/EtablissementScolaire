package eu.ensup.etablissementscolaire.exception.etudiantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Update etudiant service exception.
 */
public class UpdateEtudiantServiceException extends ServiceException {
    /**
     * Instantiates a new Update etudiant service exception.
     */
    public UpdateEtudiantServiceException() {
        super(BaseService.messageExceptionEtudiantUpdate);
        BaseService.logger.info(BaseService.messageExceptionEtudiantUpdate);
    }
}
