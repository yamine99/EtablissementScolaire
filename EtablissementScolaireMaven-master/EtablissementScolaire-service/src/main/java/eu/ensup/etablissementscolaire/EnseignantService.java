package eu.ensup.etablissementscolaire;

import java.util.Set;


import eu.ensup.etablissementscolaire.exception.enseignantExceptions.*;
import eu.ensup.etablissementscolaire.exceptions.DaoException;


/**
 * The type Enseignant service.
 */
public class EnseignantService implements IEnseignantService{
    private final IEnseignantDao enseignantDao = new EnseignantDao();

    @Override
    public int create(Enseignant enseignant) throws AddEnseignantServiceException {
        try {
            return enseignantDao.create(enseignant);
        }catch (DaoException e){
            throw new AddEnseignantServiceException();
        }

    }

    @Override
    public int update(Enseignant enseignant) throws UpdateEnseignantServiceException {
        try {
            return enseignantDao.update(enseignant);
        }catch (DaoException e){
            throw new UpdateEnseignantServiceException();
        }
    }

    @Override
    public int delete(int id) throws DeleteEnseignantServiceException {
        try {
            return enseignantDao.delete(id);
        }catch (DaoException e) {
            throw new DeleteEnseignantServiceException();
        }
    }

    @Override
    public Enseignant get(int id) throws GetEnseignantServiceException {
        try {
            return enseignantDao.get(id);
        }catch (DaoException e){
            throw new GetEnseignantServiceException();
        }
    }

    @Override
    public Set<Enseignant> getAll() throws GetAllEnseignantServiceException {
        try {
            return enseignantDao.getAll();
        }catch (DaoException e) {
            throw new GetAllEnseignantServiceException();
        }

    }
}
