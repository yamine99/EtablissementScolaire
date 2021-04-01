package eu.ensup.etablissementscolaire.exception.responsableExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Add responsable service exception.
 */
public class AddResponsableServiceException extends ServiceException {
    /**
     * Instantiates a new Add responsable service exception.
     */
    public AddResponsableServiceException() {
        super(BaseService.messageExceptionResponsableAdd);
        BaseService.logger.info(BaseService.messageExceptionResponsableAdd);
    }
}
