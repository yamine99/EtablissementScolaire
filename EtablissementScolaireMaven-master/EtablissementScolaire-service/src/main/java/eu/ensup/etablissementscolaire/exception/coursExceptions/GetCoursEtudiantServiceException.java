package eu.ensup.etablissementscolaire.exception.coursExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get cours etudiant service exception.
 */
public class GetCoursEtudiantServiceException extends ServiceException {
    /**
     * Instantiates a new Get cours etudiant service exception.
     */
    public GetCoursEtudiantServiceException() {
        super(BaseService.messageExceptionCoursEtudiant);
        BaseService.logger.info(BaseService.messageExceptionCoursGet);
    }
}
