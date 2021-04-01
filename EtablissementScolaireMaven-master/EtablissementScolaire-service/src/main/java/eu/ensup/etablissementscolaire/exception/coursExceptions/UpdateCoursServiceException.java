package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Update cours service exception.
 */
public class UpdateCoursServiceException extends ServiceException {
    /**
     * Instantiates a new Update cours service exception.
     */
    public UpdateCoursServiceException() {
        super(BaseService.messageExceptionCoursUpdate);
        BaseService.logger.info(BaseService.messageExceptionCoursUpdate);
    }
}
