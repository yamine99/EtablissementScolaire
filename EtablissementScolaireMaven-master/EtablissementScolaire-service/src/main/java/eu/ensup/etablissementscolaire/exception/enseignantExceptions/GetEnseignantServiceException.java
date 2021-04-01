package eu.ensup.etablissementscolaire.exception.enseignantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get enseignant service exception.
 */
public class GetEnseignantServiceException extends ServiceException {
    /**
     * Instantiates a new Get enseignant service exception.
     */
    public GetEnseignantServiceException() {
        super(BaseService.messageExceptionEnseignantGet);
        BaseService.logger.info(BaseService.messageExceptionEnseignantGet);
    }
}
