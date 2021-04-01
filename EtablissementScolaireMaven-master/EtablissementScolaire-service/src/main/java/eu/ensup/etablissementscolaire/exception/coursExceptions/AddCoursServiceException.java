package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Add cours service exception.
 */
public class AddCoursServiceException extends ServiceException {
    /**
     * Instantiates a new Add cours service exception.
     */
    public AddCoursServiceException() {
        super(BaseService.messageExceptionCoursAdd);
        BaseService.logger.info(BaseService.messageExceptionCoursAdd);
    }
}
