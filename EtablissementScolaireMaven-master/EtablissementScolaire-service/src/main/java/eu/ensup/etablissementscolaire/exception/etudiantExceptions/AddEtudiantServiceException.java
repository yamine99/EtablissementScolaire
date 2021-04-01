package eu.ensup.etablissementscolaire.exception.etudiantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Add etudiant service exception.
 */
public class AddEtudiantServiceException extends ServiceException {
    /**
     * Instantiates a new Add etudiant service exception.
     */
    public AddEtudiantServiceException() {
        super(BaseService.messageExceptionEtudiantAdd);
        BaseService.logger.info(BaseService.messageExceptionEtudiantAdd);
    }
}
