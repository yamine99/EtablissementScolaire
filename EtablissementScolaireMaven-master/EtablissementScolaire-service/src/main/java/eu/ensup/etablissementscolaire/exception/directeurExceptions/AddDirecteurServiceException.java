package eu.ensup.etablissementscolaire.exception.directeurExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Add directeur service exception.
 */
public class AddDirecteurServiceException extends ServiceException {
    /**
     * Instantiates a new Add directeur service exception.
     */
    public AddDirecteurServiceException() {
        super(BaseService.messageExceptionDirecteurAdd);
        BaseService.logger.info(BaseService.messageExceptionDirecteurAdd);
    }
}
