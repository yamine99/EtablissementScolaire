package eu.ensup.etablissementscolaire;



import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * The interface Etudiant service.
 */
public interface IEtudiantService extends IService<Etudiant>
{
    int[] niveauEleve(int[] repartition, List<Float> notes);
}
