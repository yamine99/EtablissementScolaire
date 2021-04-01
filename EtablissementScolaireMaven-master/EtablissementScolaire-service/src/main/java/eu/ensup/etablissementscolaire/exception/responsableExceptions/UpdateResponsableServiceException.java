package eu.ensup.etablissementscolaire.exception.responsableExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Update responsable service exception.
 */
public class UpdateResponsableServiceException extends ServiceException {
    /**
     * Instantiates a new Update responsable service exception.
     */
    public UpdateResponsableServiceException() {
        super(BaseService.messageExceptionResponsableUpdate);
        BaseService.logger.info(BaseService.messageExceptionResponsableUpdate);
    }
}
