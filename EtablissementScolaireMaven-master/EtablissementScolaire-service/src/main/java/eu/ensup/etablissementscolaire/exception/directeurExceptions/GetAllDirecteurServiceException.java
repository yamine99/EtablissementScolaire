package eu.ensup.etablissementscolaire.exception.directeurExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get all directeur service exception.
 */
public class GetAllDirecteurServiceException extends ServiceException {
    /**
     * Instantiates a new Get all directeur service exception.
     */
    public GetAllDirecteurServiceException() {
        super(BaseService.messageExceptionDirecteurGetAll);
        BaseService.logger.info(BaseService.messageExceptionDirecteurGetAll);
    }
}
