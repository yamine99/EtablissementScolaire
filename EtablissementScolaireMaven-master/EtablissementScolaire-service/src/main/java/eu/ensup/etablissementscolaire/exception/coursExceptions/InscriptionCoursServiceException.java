package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Inscription cours service exception.
 */
public class InscriptionCoursServiceException extends ServiceException {
    /**
     * Instantiates a new Inscription cours service exception.
     */
    public InscriptionCoursServiceException() {
        super(BaseService.messageExceptionCoursInscription);
        BaseService.logger.info(BaseService.messageExceptionCoursInscription);
    }
}
