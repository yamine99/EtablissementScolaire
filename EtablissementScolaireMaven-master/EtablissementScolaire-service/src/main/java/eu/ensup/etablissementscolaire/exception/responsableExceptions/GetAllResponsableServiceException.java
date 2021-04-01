package eu.ensup.etablissementscolaire.exception.responsableExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get all responsable service exception.
 */
public class GetAllResponsableServiceException extends ServiceException {
    /**
     * Instantiates a new Get all responsable service exception.
     */
    public GetAllResponsableServiceException() {
        super(BaseService.messageExceptionResponsableGetAll);
        BaseService.logger.info(BaseService.messageExceptionResponsableGetAll);
    }
}
