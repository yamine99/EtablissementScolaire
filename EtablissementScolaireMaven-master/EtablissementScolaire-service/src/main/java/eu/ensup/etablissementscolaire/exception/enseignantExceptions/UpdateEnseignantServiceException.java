package eu.ensup.etablissementscolaire.exception.enseignantExceptions;

import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Update enseignant service exception.
 */
public class UpdateEnseignantServiceException extends ServiceException {
    /**
     * Instantiates a new Update enseignant service exception.
     */
    public UpdateEnseignantServiceException() {
        super(BaseService.messageExceptionEnseignantUpdate);
        BaseService.logger.info(BaseService.messageExceptionEnseignantUpdate);
    }
}
