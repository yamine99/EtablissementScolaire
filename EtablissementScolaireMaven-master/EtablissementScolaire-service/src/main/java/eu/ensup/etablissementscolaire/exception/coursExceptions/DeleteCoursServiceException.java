package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Delete cours service exception.
 */
public class DeleteCoursServiceException extends ServiceException {
    /**
     * Instantiates a new Delete cours service exception.
     */
    public DeleteCoursServiceException() {
        super(BaseService.messageExceptionCoursDelete);
        BaseService.logger.info(BaseService.messageExceptionCoursDelete);
    }
}
