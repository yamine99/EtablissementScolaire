package eu.ensup.etablissementscolaire;




import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.DeleteCoursServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.util.Set;


public class MatiereService implements IMatiereService {

    private  IMatiereDao matiereDao = new MatiereDao();
    @Override
    public int create(Matiere entity) throws ServiceException {
        return 0;
    }

    @Override
    public int update(Matiere entity) throws ServiceException {
        return 0;
    }

    @Override
    public int delete(int indice) throws ServiceException {
        return 0;
    }

    @Override
    public Matiere get(int indice) throws ServiceException {
        try {
            return matiereDao.get(indice);
        } catch (DaoException e) {
            throw new DeleteCoursServiceException();
        }
    }

    @Override
    public Set<Matiere> getAll() throws ServiceException {
        try {
            return matiereDao.getAll();
        } catch (DaoException e) {
            throw new DeleteCoursServiceException();
        }
    }
}
