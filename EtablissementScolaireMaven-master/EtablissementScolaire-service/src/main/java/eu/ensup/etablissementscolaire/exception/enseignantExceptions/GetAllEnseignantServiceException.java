package eu.ensup.etablissementscolaire.exception.enseignantExceptions;



import eu.ensup.etablissementscolaire.BaseService;
import eu.ensup.etablissementscolaire.exception.ServiceException;

/**
 * The type Get all enseignant service exception.
 */
public class GetAllEnseignantServiceException extends ServiceException {
    /**
     * Instantiates a new Get all enseignant service exception.
     */
    public GetAllEnseignantServiceException() {
        super(BaseService.messageExceptionEnseignantGetAll);
        BaseService.logger.info(BaseService.messageExceptionEnseignantGetAll);
    }
}
