package eu.ensup.etablissementscolaire;

import java.util.Set;


import eu.ensup.etablissementscolaire.exception.coursExceptions.*;
import eu.ensup.etablissementscolaire.exceptions.DaoException;


/**
 * The type Cours service.
 */
public class CoursService implements ICoursService {
    private final ICoursDao coursDao = new CoursDao();
    @Override
    public int create(Cours cours) throws AddCoursServiceException {
        try{
            return coursDao.create(cours) ;
        }catch (DaoException e) {
            throw new AddCoursServiceException();
        }

    }

    @Override
    public int update(Cours cours) throws UpdateCoursServiceException {
        try{
            return coursDao.update(cours) ;
        }catch (DaoException e) {
            throw new UpdateCoursServiceException();
        }
    }

    @Override
    public int delete(int id) throws DeleteCoursServiceException {
        try{
            return coursDao.delete(id) ;
        }catch (DaoException e) {
            throw new DeleteCoursServiceException();
        }
    }

    @Override
    public Cours get(int id) throws GetCoursServiceException {
        try{
            return coursDao.get(id) ;
        }catch (DaoException e) {
            throw new GetCoursServiceException();
        }
    }

    @Override
    public Set<Cours> getAll() throws GetAllCoursServiceException {
        try{
            return coursDao.getAll() ;
        }catch (DaoException e) {
            throw new GetAllCoursServiceException();
        }
    }

    @Override
    public int inscription(Cours c, Etudiant e) throws InscriptionCoursServiceException {
        try{
            return coursDao.inscription(c, e);
        }catch (DaoException data) {
            throw new InscriptionCoursServiceException();
        }
    }

    @Override
    public Set<Cours> getCoursEtudiant(int idEtudiant) throws GetCoursEtudiantServiceException {
        try{
            return coursDao.getCoursEtudiant(idEtudiant);
        }catch (DaoException e) {
            throw new GetCoursEtudiantServiceException();
        }
    }

}
