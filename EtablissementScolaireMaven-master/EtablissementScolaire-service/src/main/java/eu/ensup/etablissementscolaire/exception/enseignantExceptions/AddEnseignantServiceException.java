package eu.ensup.etablissementscolaire.exception.enseignantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Add enseignant service exception.
 */
public class AddEnseignantServiceException extends ServiceException {
    /**
     * Instantiates a new Add enseignant service exception.
     */
    public AddEnseignantServiceException() {
        super(BaseService.messageExceptionEnseignantAdd);
        BaseService.logger.info(BaseService.messageExceptionEnseignantAdd);
    }
}
