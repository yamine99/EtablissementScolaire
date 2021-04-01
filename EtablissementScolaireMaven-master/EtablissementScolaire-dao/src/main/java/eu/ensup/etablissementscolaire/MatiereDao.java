package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exceptions.CRUDException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


/**
 * The type matiere dao.
 */
public class MatiereDao extends BaseDao implements IMatiereDao
{

	@Override
	public int create(Matiere entity) throws DaoException {
		return 0;
	}

	@Override
	public int update(Matiere entity) throws DaoException {
		return 0;
	}
	
	@Override
	public int delete(int indice) throws DaoException {
		return 0;
	}

	@Override
	public Matiere get(int indice) throws DaoException {
		connexion();
		String sql;
		try {
			sql = "Select * from matiere where id_matiere = ?";
			BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
			BaseDao.getPs().setInt(1, indice);
			BaseDao.setRs(BaseDao.getPs().executeQuery());
			while (getRs().next()) {
				return new Matiere(getRs().getInt("id_matiere"), getRs().getString("libelle"));
			}
		} catch (SQLException e) {
			throw new CRUDException(e, Matiere.class.getName(), "Get");
		}
		disconnect();
		return null;
	}

	@Override
	public Set<Matiere> getAll() throws DaoException {
		connexion();

		String sql;
		Set<Matiere> matiere = new HashSet<>();
		try {
			sql = "SELECT * FROM matiere ";
			BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
			BaseDao.setRs(BaseDao.getPs().executeQuery());
			while (BaseDao.getRs().next()) {
				matiere.add(new Matiere(BaseDao.getRs().getInt("id_matiere"), BaseDao.getRs().getString("libelle")));
			}
		} catch (SQLException e) {
			throw new CRUDException(e, Matiere.class.getName(), "GetAll");
		}
		disconnect();
		return matiere;
	}


}
