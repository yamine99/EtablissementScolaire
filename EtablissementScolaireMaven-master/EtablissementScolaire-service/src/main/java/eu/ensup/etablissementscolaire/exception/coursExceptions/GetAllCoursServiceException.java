package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get all cours service exception.
 */
public class GetAllCoursServiceException extends ServiceException {
    /**
     * Instantiates a new Get all cours service exception.
     */
    public GetAllCoursServiceException() {
        super(BaseService.messageExceptionCoursGetAll);
        BaseService.logger.info(BaseService.messageExceptionCoursGetAll);
    }
}
