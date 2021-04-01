package eu.ensup.etablissementscolaire.vues;


import com.toedter.calendar.JDateChooser;

import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.AddEtudiantServiceException;


import javax.swing.*;
import java.sql.Date;
import java.util.Calendar;

/**
 * The type Page formulaire.
 */
public class PageFormulaire extends  Fenetre {
    private JPanel panelMain;
    private JButton enregistrerButton;
    private JButton retourButton;
    private JTextField input_nom;
    private JTextField input_prenom;
    private JTextField input_adresse;
    private JTextField input_tel;
    private JPanel panelCalendrier;
    private JPanel panel2;
    private JTextField input_mail;
    private JLabel error_label;

    private final JDateChooser dateChooser;

    /**
     * Instantiates a new Page formulaire.
     *
     * @param user the user
     */
    public PageFormulaire(Responsable user) {
        super("Formulaire d'enregistrement", user);
        Calendar cld = Calendar.getInstance();
        dateChooser = new JDateChooser(cld.getTime());

        //calendrier
        dateChooser.setDateFormatString("dd/MM/yyyy");
        panelCalendrier.add(dateChooser);
        EtudiantService etudiantService = new EtudiantService();
        this.setContentPane(panelMain);
        retourButton.addActionListener(e -> {
            new PagePrincipal(user).setVisible(true);
            PageFormulaire.super.setVisible(false);
        });


        enregistrerButton.addActionListener(e -> {
            /**if (input_nom.getText().trim().isEmpty() || input_adresse.getText().trim().isEmpty() || input_mail.getText().trim().isEmpty() || input_nom.getText().trim().isEmpty() || input_prenom.getText().isEmpty() || input_tel.getText().isEmpty()) {
                error_label.setText("Tous les champs doivent être remplis");
            } else {**/

                Date sqldate = new Date(dateChooser.getDate().getTime());
                Etudiant etudiant = new Etudiant(input_nom.getText(), input_mail.getText(), input_adresse.getText(), input_tel.getText(), input_prenom.getText(), "", "", sqldate);
                try {
                    etudiantService.create(etudiant);
                    String message = "";
                    String title = "";
                    int typeMessage = 1;
                    /***
                    if (ret == 0) {
                        message = "La création de l'éléve " + etudiant.getNom() + " à été effectuée !";
                        title = "Création de l'éléve";
                        typeMessage = JOptionPane.INFORMATION_MESSAGE;
                    } else if (ret == -1) {
                        message = "Erreur SQL veuillez contacter votre administrateur !";
                        title = "Création de l'éléve";
                        typeMessage = JOptionPane.ERROR_MESSAGE;
                    } else if (ret == -2) {
                        message = "La création de l'éléve " + etudiant.getNom() + " n'as pas été réalisée car il existe déjà!";
                        title = "Création de l'éléve";
                        typeMessage = JOptionPane.INFORMATION_MESSAGE;
                    }
                    JOptionPane.showMessageDialog(new JFrame(), message, title, typeMessage);
                    _clearForm();***/
                } catch (AddEtudiantServiceException | CredentialException etudiantServiceException) {
                     error_label.setText(etudiantServiceException.getMessage());
                }
            //}
        });
    }

    private void _clearForm() {
        input_nom.setText("");
        input_adresse.setText("");
        input_mail.setText("");
        input_prenom.setText("");
        input_tel.setText("");
        error_label.setText("");
        dateChooser.setDate(new java.util.Date());
    }
}
