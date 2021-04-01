package eu.ensup.etablissementscolaire.vues;


import eu.ensup.etablissementscolaire.*;

import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.InscriptionCoursServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Page associer etudiant.
 */
public class PageAssocierEtudiant extends Fenetre {
    private JPanel panelMain;
    private JLabel titrePageAssocier;
    private JComboBox comboBoxCours;
    private JComboBox comboxListeEtudiant;
    private JButton btn_associer;
    private JPanel labelCours;
    private JLabel labelEtu;
    private JLabel titreEnsup;
    private JButton retourButton;
    private JLabel error_label;

    /**
     * The Etudiant service.
     */
    EtudiantService etudiantService = new EtudiantService();
    /**
     * The Cours service.
     */
    CoursService coursService = new CoursService();
    /**
     * The Etudiants.
     */
    List<Etudiant> etudiants;
    /**
     * The Cours.
     */
    List<Cours> cours;

    /**
     * Instantiates a new Page associer etudiant.
     *
     * @param user the user
     * @throws InscriptionCoursServiceException the inscription cours service exception
     * @throws GetAllCoursServiceException      the get all cours service exception
     */
    public PageAssocierEtudiant(Responsable user) throws InscriptionCoursServiceException, GetAllCoursServiceException, GetAllEtudiantServiceException {
        super("Inscrire un étudiant pour un cour",user);

        this.setContentPane(panelMain);

        _updateListEtudiant();
        _updateListCours();

        retourButton.addActionListener(e -> {
            new PagePrincipal(user).setVisible(true);
            PageAssocierEtudiant.super.hide();
        });
        btn_associer.addActionListener(e -> {
            final Etudiant etudiantSelected;
            final Cours coursSelected;
            if(comboxListeEtudiant.getSelectedIndex() == 0 || comboBoxCours.getSelectedIndex() == 0){
                error_label.setText("Veuillez selectionner une valeur dans les deux champs.");
            } else {
                etudiantSelected = (Etudiant) comboxListeEtudiant.getSelectedItem();
                coursSelected = (Cours) comboBoxCours.getSelectedItem();
                int result = 0;
                try {
                    result = coursService.inscription( coursSelected,etudiantSelected);
                } catch (InscriptionCoursServiceException inscriptionCoursServiceException) {
                    error_label.setText(inscriptionCoursServiceException.getMessage());
                }
                if ( result == 1){
                    try {
                        _updateListEtudiant();
                    } catch (GetAllEtudiantServiceException getAllEtudiantServiceException) {
                        getAllEtudiantServiceException.printStackTrace();
                    }
                    try {
                        _updateListCours();
                    } catch (GetAllCoursServiceException getAllCoursServiceException) {
                        error_label.setText(getAllCoursServiceException.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,
                            "L' association a été effectuée avec succès !");
                    error_label.setText("");
                }else if(result == -1){
                    JOptionPane.showMessageDialog(null,
                            "L' association n'a  pas été effectuée car l'étudiant participe déjà au cours!");
                }else{
                    String message ="L' association n' été pas effectuée...veuillez réessayer  !";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Erreur d'assocaition",
                            JOptionPane.ERROR_MESSAGE);
                }
            }


        });
    }

    private void _updateListEtudiant() throws GetAllEtudiantServiceException {

        comboxListeEtudiant.removeAllItems();
        comboxListeEtudiant.addItem("");
        etudiants = new ArrayList<>();
        etudiants.addAll(etudiantService.getAll());
        for (Etudiant etudiant: etudiants) {
            comboxListeEtudiant.addItem(etudiant);
        }
    }
    private void _updateListCours() throws GetAllCoursServiceException {
        comboBoxCours.removeAllItems();
        comboBoxCours.addItem("");
        cours = new ArrayList<>();
        cours.addAll(coursService.getAll());
        for (Cours cour: cours) {
            comboBoxCours.addItem(cour);
        }
    }

}
