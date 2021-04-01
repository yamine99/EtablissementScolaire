package eu.ensup.etablissementscolaire;

import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;



import eu.ensup.etablissementscolaire.exceptions.CRUDException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

/**
 * The type Etudiant dao.
 */
public class EtudiantDao extends BaseDao implements IEtudiantDao {
	@Override
	public int create(Etudiant etudiant) throws DaoException {
		connexion();
		String sql;
		try {
			sql = "{CALL insertEtudiant(?,?,?,?,?,?,?,?,?,?) } ";
			setCs(getCn().prepareCall(sql));
			getCs().setString(1, etudiant.getNom());
			getCs().setString(2, etudiant.getPrenom());
			getCs().setString(3, etudiant.getEmail());
			getCs().setString(4, etudiant.getAdresse());
			getCs().setString(5, etudiant.getTelephone());
			getCs().setString(6, etudiant.getMotDePasse());
			getCs().setString(7, etudiant.getSalt());
			getCs().setString(8, "etudiant");
			getCs().setDate(9,etudiant.getDateNaissance());
			getCs().registerOutParameter(10, Types.INTEGER);
			setRs(getCs().executeQuery());
			setResult(getCs().getInt(10));
			logger.info("l'étudiant " + etudiant + " a été créé.");
		} catch (SQLException e) {
			throw new CRUDException(e, Etudiant.class.getName(), "Create");
		}
		disconnect();
		return getResult();
	}

	@Override
	public int update(Etudiant etudiant) throws DaoException {
		connexion();

		String sql;
		try {
			sql = "{CALL updateEtudiant(?,?,?,?,?,?,?,?,?,?,?) } ";
			setCs(getCn().prepareCall(sql));
			getCs().setInt(1, etudiant.getId());
			getCs().setString(2, etudiant.getNom());
			getCs().setString(3, etudiant.getPrenom());
			getCs().setString(4, etudiant.getEmail());
			getCs().setString(5, etudiant.getAdresse());
			getCs().setString(6, etudiant.getTelephone());
			getCs().setString(7, etudiant.getMotDePasse());
			getCs().setString(8, etudiant.getSalt());
			getCs().setString(9, "etudiant");
			getCs().setDate(10,etudiant.getDateNaissance());
			getCs().registerOutParameter(11, Types.INTEGER);
			setRs(getCs().executeQuery());
			setResult(getCs().getInt(11));
			logger.info("l'étudiant " + etudiant + " a été modifié.");

		} catch (SQLException e) {
			throw new CRUDException(e, Etudiant.class.getName(), "Update");
		}
		disconnect();
		return getResult();
	}

	@Override
	public int delete(int id) throws DaoException {
		connexion();
		String sql;
		try {
			sql = "{CALL deleteEtudiant(?,?) } ";
			setCs(getCn().prepareCall(sql));
			getCs().setInt(1, id);
			getCs().registerOutParameter(2, Types.INTEGER);
			setRs(getCs().executeQuery());
			setResult(getCs().getInt(2));
			logger.info("l'étudiant a été supprimé.");

		} catch (SQLException e) {
			throw new CRUDException(e, Etudiant.class.getName(), "Delete");
		}
		disconnect();
		return getResult();

	}

	@Override
	public Etudiant get(int id) throws DaoException{
		connexion();
		String sql;
		Etudiant etudiant = new Etudiant();
		try {
			sql = "select id_personne,date_naissance,nom,prenom,email,adresse,telephone,mdp,salt,id_role from personne a join  personne_phys b on a.id_personne = b.id_phys join etudiant c on b.id_phys = c.id_etudiant WHERE id_personne = ?";
			setPs(getCn().prepareStatement(sql));
			getPs().setInt(1, id);
			setRs(getPs().executeQuery());
			while (getRs().next()) {
				etudiant.setDateNaissance(getRs().getDate("date_naissance"));
				etudiant.setNom(getRs().getString("nom"));
				etudiant.setPrenom(getRs().getString("prenom"));
				etudiant.setEmail(getRs().getString("email"));
				etudiant.setAdresse(getRs().getString("adresse"));
				etudiant.setTelephone(getRs().getString("telephone"));
				etudiant.setMotDePasse(getRs().getString("mdp"));
				etudiant.setSalt(getRs().getString("salt"));
			}
		} catch (SQLException e) {
			throw new CRUDException(e, Etudiant.class.getName(), "Get");
		}
		disconnect();
		return etudiant;
	}

	@Override
	public Set<Etudiant> getAll() throws DaoException {

		String sql;
		Set<Etudiant> etudiantList = new HashSet<>();
		try {
			connexion();
			sql = "SELECT * FROM personne_phys as pp , personne as p , etudiant as e WHERE pp.id_phys = p.id_personne AND p.id_personne = e.id_etudiant ";
			setPs(getCn().prepareStatement(sql));
			setRs(getPs().executeQuery());
			while (getRs().next()) {
				etudiantList.add(new Etudiant(getRs().getInt("id_personne"), getRs().getString("nom"), getRs().getString("email"), getRs().getString("adresse"),
						getRs().getString("telephone"), getRs().getString("prenom"), getRs().getString("mdp"), getRs().getString("salt"), getRs().getDate("date_naissance")));
			}
		}
		catch (SQLException e){
			throw new CRUDException(e, Etudiant.class.getName(), "GetAll");
		}
		disconnect();
		return etudiantList;
	}
}
