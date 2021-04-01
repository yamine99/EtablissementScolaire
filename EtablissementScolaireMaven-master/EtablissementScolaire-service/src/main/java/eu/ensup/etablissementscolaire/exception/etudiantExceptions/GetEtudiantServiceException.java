package eu.ensup.etablissementscolaire.exception.etudiantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get etudiant service exception.
 */
public class GetEtudiantServiceException extends ServiceException {
    /**
     * Instantiates a new Get etudiant service exception.
     */
    public GetEtudiantServiceException() {
        super(BaseService.messageExceptionEtudiantGet);
        BaseService.logger.info(BaseService.messageExceptionEtudiantGet);
    }
}
