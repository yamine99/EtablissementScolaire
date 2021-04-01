package eu.ensup.etablissementscolaire.exception.directeurExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Delete directeur service exception.
 */
public class DeleteDirecteurServiceException extends ServiceException {
    /**
     * Instantiates a new Delete directeur service exception.
     */
    public DeleteDirecteurServiceException() {
        super(BaseService.messageExceptionDirecteurDelete);
        BaseService.logger.info(BaseService.messageExceptionDirecteurDelete);
    }
}
