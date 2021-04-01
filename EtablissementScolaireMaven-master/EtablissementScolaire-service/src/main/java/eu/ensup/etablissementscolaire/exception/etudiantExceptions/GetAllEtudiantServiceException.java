package eu.ensup.etablissementscolaire.exception.etudiantExceptions;


import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get all etudiant service exception.
 */
public class GetAllEtudiantServiceException extends ServiceException {
    /**
     * Instantiates a new Get all etudiant service exception.
     */
    public GetAllEtudiantServiceException() {
        super(BaseService.messageExceptionEtudiantGetAll);
        BaseService.logger.info(BaseService.messageExceptionEtudiantGetAll);
    }
}
