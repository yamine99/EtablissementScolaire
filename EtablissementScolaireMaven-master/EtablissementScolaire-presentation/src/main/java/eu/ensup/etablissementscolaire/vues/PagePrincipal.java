package eu.ensup.etablissementscolaire.vues;


import eu.ensup.etablissementscolaire.Directeur;
import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.InscriptionCoursServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.vues.PageAssocierEtudiant;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * The type Page principal.
 */
public class PagePrincipal  extends Fenetre{
    private JPanel panelMain;
    private JButton retourButton;
    private JButton btn_lister;
    private JButton btn_creer;
    private JButton btn_editer;
    private JButton btn_associer;
    private JButton btn_statistic;
    private JButton btn_addNote;
    //  private JButton btn_supprimer;


    /**
     * Instantiates a new Page principal.
     *
     * @param user the user
     */
    public PagePrincipal(Responsable user) {
        super("Accueil",user);
        this.setContentPane(panelMain);

        if (!(PagePrincipal.super.user instanceof Directeur)){
            this.btn_lister.setVisible(false);
        }


        btn_addNote.addActionListener(e -> {
            new PageAddNote(user).setVisible(true);
            PagePrincipal.super.setVisible(false);
        });
        btn_creer.addActionListener(e -> {

            new PageFormulaire(user).setVisible(true);
            PagePrincipal.super.setVisible(false);
        });

        btn_editer.addActionListener(e -> {
            new PageEditer(user).setVisible(true);
            PagePrincipal.super.setVisible(false);
        });

        btn_lister.addActionListener(e -> {
            try {
                new PageListing(user).setVisible(true);
            } catch (GetAllEtudiantServiceException etudiantServiceException) {
                String message = etudiantServiceException.getMessage();
                String title = "Liste des éléves";
                int typeMessage = JOptionPane.ERROR_MESSAGE;
                JOptionPane.showMessageDialog(new JFrame(), message, title, typeMessage);
            }
            PagePrincipal.super.setVisible(false);
        });

        retourButton.addActionListener(e -> {
            new PageAuthentification().setVisible(true);
            PagePrincipal.super.setVisible(false);
        });
        btn_associer.addActionListener(e -> {
            try {
                //todo
                new PageAssocierEtudiant(user).setVisible(true);
            } catch (GetAllCoursServiceException getAllCoursServiceException) {
                getAllCoursServiceException.printStackTrace();
            } catch (InscriptionCoursServiceException inscriptionCoursServiceException) {
                inscriptionCoursServiceException.printStackTrace();
            } catch (GetAllEtudiantServiceException getAllEtudiantServiceException) {
                getAllEtudiantServiceException.printStackTrace();
            }
            PagePrincipal.super.setVisible(false);
        });

        btn_statistic.addActionListener(
                e-> {
                    new PageStats(user).setVisible(true);
                    PagePrincipal.super.hide();
                }
        );
    }
}
