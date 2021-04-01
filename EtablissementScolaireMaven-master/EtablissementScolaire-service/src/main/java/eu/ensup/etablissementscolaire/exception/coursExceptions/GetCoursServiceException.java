package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get cours service exception.
 */
public class GetCoursServiceException extends ServiceException {
    /**
     * Instantiates a new Get cours service exception.
     */
    public GetCoursServiceException() {
        super(BaseService.messageExceptionCoursGet);
        BaseService.logger.info("Une erreur à empêcher l'accès au cours");
    }
}
