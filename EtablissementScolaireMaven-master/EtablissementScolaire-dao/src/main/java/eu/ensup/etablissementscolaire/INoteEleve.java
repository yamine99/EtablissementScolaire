package eu.ensup.etablissementscolaire;



import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.util.List;
import java.util.Map;

/**
 * The interface Note elève dao.
 */
public interface INoteEleve {

    /**
     * add note eleve int
     *
     * @param noteEleve the cours
     * @return int int
     */
    int addNoteEleve(NoteEleve noteEleve, Etudiant etudiant, Matiere matiere) throws DaoException;;

    /**
     * Update cours int.
     *
     * @param noteEleve the cours
     * @return int int
     */
    int updateNoteEleve(NoteEleve noteEleve) throws  DaoException;;

    /**
     * Delete Note eleve int
     *
     * @param id the cours
     * @return int int
     */
    int deleteNoteEleve(int id) throws  DaoException;;

    /**
     * get Note eleve
     *
     * @param id the id
     * @return NoteEleve noteEleve
     */
    NoteEleve getNoteEleve(int id) throws  DaoException;;

    /**
     * Find all list.
     *
     * @return list list
     */
    List<NoteEleve> findAll() throws  DaoException;

    List<Float> findNoteByEleve(int id) throws  DaoException;

    Map<Integer, List<Float>> FindNoteEtudiant() throws DaoException;

}
