package eu.ensup.etablissementscolaire.exception.enseignantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Delete enseignant service exception.
 */
public class DeleteEnseignantServiceException extends ServiceException {
    /**
     * Instantiates a new Delete enseignant service exception.
     */
    public DeleteEnseignantServiceException() {
        super(BaseService.messageExceptionEnseignantDelete);
        BaseService.logger.info(BaseService.messageExceptionEnseignantDelete);
    }
}
