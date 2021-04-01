package eu.ensup.etablissementscolaire.exception.directeurExceptions;



import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Update directeur service exception.
 */
public class UpdateDirecteurServiceException extends ServiceException {
    /**
     * Instantiates a new Update directeur service exception.
     */
    public UpdateDirecteurServiceException() {
        super(BaseService.messageExceptionDirecteurUpdate);
        BaseService.logger.info(BaseService.messageExceptionDirecteurUpdate);
    }
}
