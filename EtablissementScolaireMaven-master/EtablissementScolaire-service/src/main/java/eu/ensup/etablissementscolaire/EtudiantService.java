package eu.ensup.etablissementscolaire;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;


import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.*;
import eu.ensup.etablissementscolaire.exceptions.DaoException;


/**
 * The type Etudiant service.
 */
public class EtudiantService implements IEtudiantService{

    private final IEtudiantDao etudiantDao;
    private final PersonnePhysiqueService personnePhysiqueService = new PersonnePhysiqueService();

    public EtudiantService(IEtudiantDao etudiantdao) {
        this.etudiantDao=etudiantdao;
    }

    public EtudiantService() {
        this.etudiantDao=new EtudiantDao();
    }

    @Override
    public int create(Etudiant etudiant) throws AddEtudiantServiceException, CredentialException {
        byte[] salt = personnePhysiqueService.createSalt();
        String hash = null;
        try {
            hash = personnePhysiqueService.generateHashPassword(etudiant.getMotDePasse(),salt);
        } catch (NoSuchAlgorithmException e) {
            throw new CredentialException();
        }

        etudiant.setSalt(Base64.getEncoder().encodeToString(salt));
        etudiant.setMotDePasse(hash);
        try {
            return etudiantDao.create(etudiant);
        }
        catch (DaoException e) {
            throw new AddEtudiantServiceException();
        }

    }

    @Override
    public int update(Etudiant etudiant) throws UpdateEtudiantServiceException {
        try {
            return etudiantDao.update(etudiant);
        }
        catch (DaoException e) {
            throw new UpdateEtudiantServiceException();
        }
    }

    @Override
    public int delete(int id) throws DeleteEtudiantServiceException {
        try {
            return etudiantDao.delete(id);
        }
        catch (DaoException e) {
            throw new DeleteEtudiantServiceException();
        }

    }

    @Override
    public Etudiant get(int id) throws GetEtudiantServiceException {
        try {
            return etudiantDao.get(id);
        }
        catch (DaoException e) {
            throw new GetEtudiantServiceException();
        }

    }

    @Override
    public Set<Etudiant> getAll() throws GetAllEtudiantServiceException {
        try {
            return etudiantDao.getAll();
        }
        catch (DaoException e) {
            throw new GetAllEtudiantServiceException();
        }
    }
    @Override
    public int[] niveauEleve(int[] repartition, List<Float> notes) {

        OptionalDouble average = notes.stream().mapToDouble(a -> a).average();
        if (average.isPresent()) {
            double realAverage = average.getAsDouble();
            if (realAverage < 8) {
                repartition[0]++;
            } else if (realAverage >= 8 && realAverage < 12) {
                repartition[1]++;
            } else if (realAverage >= 12 && realAverage < 17) {
                repartition[2]++;
            } else {
                repartition[3]++;
            }
        }
        return repartition;
    }
}
