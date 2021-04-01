package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.jupiter.api.*;

import java.sql.Date;
import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestDao {

    private BaseDao cn = new BaseDao();
    private EtudiantDao etudiant = new EtudiantDao();

    @BeforeEach
    @Test
    void conection() throws DaoException {
        cn.connexion();
        //assumeFalse(cn.equals(null));
        //verifier si la cnx est null hamcrest
        assertThat(cn, notNullValue());

    }
    @Test
    void etudiantsIsNull() throws DaoException {
        Set<Etudiant> listeEtudiants = etudiant.getAll();
        for (Etudiant e: listeEtudiants ){
            //assumeTrue(e!=null);
            assertThat(e,notNullValue());

        }
    }
    @Test
     void deleteEtudiant () throws DaoException {
           int id = etudiant.delete(10);
        Assertions.assertEquals(1,id);
        }
     @Test
     void etudiantIsEtudiant() throws DaoException {
        Etudiant e = etudiant.get(10);
       // assumeTrue(e instanceof Etudiant);
     }
     @Test
     void EtudiantIsCreate() throws DaoException {
      Etudiant e = new Etudiant(10,"SALEM","yamine@gmail.com", "adresse",
              "1234", "yamine", "motdepasse", "salt", new Date(new java.util.Date().getTime()));

      int i= etudiant.create(e);
      Assertions.assertEquals(1,i);
    }


}

