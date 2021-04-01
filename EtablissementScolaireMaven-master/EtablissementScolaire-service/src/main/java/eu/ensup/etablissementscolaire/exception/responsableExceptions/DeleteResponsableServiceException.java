package eu.ensup.etablissementscolaire.exception.responsableExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Delete responsable service exception.
 */
public class DeleteResponsableServiceException extends ServiceException {
    /**
     * Instantiates a new Delete responsable service exception.
     */
    public DeleteResponsableServiceException() {
        super(BaseService.messageExceptionResponsableDelete);
        BaseService.logger.info(BaseService.messageExceptionResponsableDelete);
    }
}
