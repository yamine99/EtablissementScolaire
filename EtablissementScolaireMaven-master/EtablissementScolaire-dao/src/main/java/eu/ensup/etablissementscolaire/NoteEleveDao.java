package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.*;
import eu.ensup.etablissementscolaire.exceptions.CRUDException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

public class NoteEleveDao extends BaseDao implements INoteEleve {

    private EtudiantDao etudiantDao = new EtudiantDao();

    @Override
    public int addNoteEleve(NoteEleve noteEleve, Etudiant etudiant, Matiere matiere) throws DaoException {
        String sql;
        try {
            connexion();
            sql = "{CALL InsertNote(?,?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, etudiant.getId());
            getCs().setInt(2, matiere.getId());
            getCs().setFloat(3, noteEleve.getNote());
            getCs().setFloat(4, noteEleve.getCoeff());
            getCs().registerOutParameter(5, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(5));
            logger.info("la note de l'eléve " + etudiant.getPrenom() +" "+ etudiant.getNom() + " a été créé.");
        } catch (SQLException e) {
            throw new CRUDException(e, NoteEleve.class.getName(), "Create");

        }
        disconnect();
        return getResult();
    }

    @Override
    public int updateNoteEleve(NoteEleve noteEleve) throws DaoException {
        String sql;
        try {
            connexion();
            sql = "{CALL updateNote(?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, noteEleve.getCours().getId());
            getCs().setInt(2, noteEleve.getEtudiant().getId());
            getCs().setFloat(3, noteEleve.getNote());
            getCs().setFloat(4, noteEleve.getCoeff());
            getCs().registerOutParameter(11, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(11));
            logger.info("la note de l'eléve " + noteEleve.getEtudiant().getPrenom() +" "+ noteEleve.getEtudiant().getNom() + " a été modifié.");

        } catch (SQLException e) {
            throw new CRUDException(e, NoteEleve.class.getName(), "Update");

        }
        disconnect();
        return getResult();
    }

    @Override
    public int deleteNoteEleve(int id) throws  DaoException {
        String sql;
        try {
            connexion();
            sql = "{CALL deleteNote(?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, id);
            getCs().registerOutParameter(2, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(2));
            logger.info("la note de l'eléve a été supprimé.");

        } catch (SQLException | DaoException e) {
            throw new CRUDException(e, NoteEleve.class.getName(), "Delete");

        }
        disconnect();
        return getResult();
    }

    @Override
    public NoteEleve getNoteEleve(int id) throws  DaoException {
        String sql;
        NoteEleve noteEleve = new NoteEleve();
        try {
            connexion();
            sql = "Select * from notes where id_note=?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, id);
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (getRs().next()) {
                return new NoteEleve(getRs().getInt("id_note"), getRs().getFloat("note"), getRs().getFloat("coeif"));
            }
        } catch (SQLException e) {
            throw new CRUDException(e, NoteEleve.class.getName(), "getOnce");
        }
        disconnect();
        return null;
    }
    public List<Float> findNoteByEleve(int id) throws  DaoException {
        String sql;
        NoteEleve noteEleve = new NoteEleve();
        List<Float> listNotes = new ArrayList<>();
        try {
            connexion();
            sql = "Select * from notes where id_etudiant =?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, id);
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (getRs().next()) {
                listNotes.add(getRs().getFloat("note"));
            }
        } catch (SQLException e) {
            throw new CRUDException(e, NoteEleve.class.getName(), "getOnce");
        }
        disconnect();
        return listNotes;
    }
    @Override
    public List<NoteEleve> findAll() throws  DaoException {
        connexion();
        String sql;

        List<NoteEleve> noteEleves = new ArrayList<NoteEleve>();

        sql = "SELECT * FROM notes ";
        try {
            setPs(getCn().prepareStatement(sql));

        setRs(getPs().executeQuery());
        while (getRs().next()) {
            noteEleves.add(new NoteEleve(getRs().getInt("id_note"),getRs().getFloat("note"),getRs().getFloat("coeif")));
        }
        } catch (SQLException e) {
            throw new CRUDException(e, Responsable.class.getName(), "Get all");
        }
        disconnect();
        return noteEleves;
    }

    @Override
    public Map<Integer, List<Float>> FindNoteEtudiant() throws DaoException {
        Map<Integer, List<Float>> mapEtud = new HashMap<>();
        Set<Etudiant> listEtudiant = etudiantDao.getAll();
        for (Etudiant etu: listEtudiant) {
            mapEtud.put( etu.getId(), findNoteByEleve(etu.getId()));
        }
        return mapEtud;
    }
}