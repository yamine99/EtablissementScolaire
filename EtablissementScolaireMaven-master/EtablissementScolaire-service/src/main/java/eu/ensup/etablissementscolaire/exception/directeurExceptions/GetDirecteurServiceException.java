package eu.ensup.etablissementscolaire.exception.directeurExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get directeur service exception.
 */
public class GetDirecteurServiceException extends ServiceException {
    /**
     * Instantiates a new Get directeur service exception.
     */
    public GetDirecteurServiceException() {
        super(BaseService.messageExceptionDirecteurGet);
        BaseService.logger.info(BaseService.messageExceptionDirecteurGet);
    }
}
