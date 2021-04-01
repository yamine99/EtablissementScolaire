package eu.ensup.etablissementscolaire;


import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.util.List;
import java.util.Map;

public class NoteEleveService implements INoteEleveService {
    private final INoteEleve noteEleveDao = new NoteEleveDao();
    @Override
    public int addNoteEleve(NoteEleve noteEleve, Etudiant etudiant, Matiere matiere) throws  DaoException {
        return noteEleveDao.addNoteEleve(noteEleve,etudiant, matiere);
    }

    @Override
    public int updateNoteEleve(NoteEleve noteEleve) throws DaoException {
        return noteEleveDao.updateNoteEleve(noteEleve);
    }

    @Override
    public int deleteNoteEleve(int id) throws  DaoException {
        return noteEleveDao.deleteNoteEleve(id);
    }

    @Override
    public NoteEleve getNoteEleve(int id) throws DaoException {
        return noteEleveDao.getNoteEleve(id);
    }

    @Override
    public List<NoteEleve> findAll() throws  DaoException {
        return noteEleveDao.findAll();
    }

    @Override
    public Map<Integer, List<Float>> FindNoteEtudiant() throws DaoException {
        return noteEleveDao.FindNoteEtudiant();
    }

}