package eu.ensup.etablissementscolaire.exception.responsableExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get responsable service exception.
 */
public class GetResponsableServiceException extends ServiceException {
    /**
     * Instantiates a new Get responsable service exception.
     */
    public GetResponsableServiceException() {
        super(BaseService.messageExceptionResponsableGet);
        BaseService.logger.info(BaseService.messageExceptionResponsableGet);
    }
}
