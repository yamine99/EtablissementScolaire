package eu.ensup.etablissementscolaire.vues;


import com.toedter.calendar.JDateChooser;
import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.DeleteEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.UpdateEtudiantServiceException;


import javax.swing.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Page editer.
 */
public class PageEditer extends Fenetre {
    private JButton btn_supprimer;
    private JLabel titre2;
    private JPanel panel1;
    private JPanel panelMain;
    private JComboBox comboBox;
    private JButton modifierButton;
    private JButton btn_retour;
    private JTextField input_nom;
    private JTextField input_prenom;
    private JTextField input_mail;
    private JTextField input_adresse;
    private JTextField input_tel;
    private JPanel input_dateNaissance;
    private JLabel error_label;
    private Calendar cld;
    private JDateChooser dateChooser;

    /**
     * Instantiates a new Page editer.
     *
     * @param user the user
     */
    public PageEditer(Responsable user) {
        super("Editer", user);

        // Initilialisation les variables de creation du Calendrier
        cld= Calendar.getInstance();
        dateChooser= new JDateChooser(cld.getTime());
        input_dateNaissance.add(dateChooser);
        dateChooser.setDateFormatString("dd/MM/yyyy");
        this.setContentPane(panelMain);


        final Etudiant[] etudiantSelected = new Etudiant[1];
        _clearForm();
        EtudiantService etudiantService = new EtudiantService();
        _updateListEtudiant();

        comboBox.addActionListener(e -> {

            if (comboBox.getSelectedIndex() != 0) {
                etudiantSelected[0] = (Etudiant) comboBox.getSelectedItem();
                if(etudiantSelected[0] != null){
                    input_nom.setText(etudiantSelected[0].getNom());
                    input_prenom.setText(etudiantSelected[0].getPrenom());
                    input_mail.setText(etudiantSelected[0].getEmail());
                    input_adresse.setText(etudiantSelected[0].getAdresse());
                    input_tel.setText(etudiantSelected[0].getTelephone());
                    dateChooser.setDate(etudiantSelected[0].getDateNaissance());
                }
            }


        });

        btn_retour.addActionListener(e -> {
            new PagePrincipal(user).setVisible(true);
            PageEditer.super.setVisible(false);
        });

        modifierButton.addActionListener(e -> {
            //l'envoi de la requette de modification
            /**if(comboBox.getSelectedIndex() == 0){
                error_label.setText("Veuillez sélectionner un étudiant");
            } else if (input_nom.getText().trim().isEmpty() || input_adresse.getText().trim().isEmpty() || input_mail.getText().trim().isEmpty() || input_nom.getText().trim().isEmpty() || input_prenom.getText().isEmpty() || input_tel.getText().isEmpty()) {
                error_label.setText("Tous les champs doivent être remplis");
            } else {**/
                try {
                    java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
                    if(etudiantSelected[0] != null) {
                        int ret = etudiantService.update(new Etudiant(etudiantSelected[0].getId(), input_nom.getText(), input_mail.getText(), input_adresse.getText(), input_tel.getText(), input_prenom.getText(), "", "", sqldate));

                        String message = "";
                        String title = "";
                        int typeMessage = 1;

                        if (ret == 0) {
                            message = "La modification de l'éléve " + etudiantSelected[0].getNom() + " à été faite !";
                            title = "Modification de l'éléve";
                            typeMessage = JOptionPane.INFORMATION_MESSAGE;
                            _clearForm();
                            _updateListEtudiant();
                        } else if (ret == -1) {
                            message = "Erreur SQL veuillez contacter votre administrateur !";
                            title = "Création de l'éléve";
                            typeMessage = JOptionPane.ERROR_MESSAGE;
                        }
                        JOptionPane.showMessageDialog(new JFrame(), message, title, typeMessage);
                    }

                    } catch (UpdateEtudiantServiceException etudiantServiceException) {
                        error_label.setText(etudiantServiceException.getMessage());
                }
            //}
        });

        btn_supprimer.addActionListener(e -> {

            //l'envoi de la requette de suppression
            if(comboBox.getSelectedIndex()==0){
                error_label.setText("Veuillez sélectionner un étudiant");
            } else {

                int retour = JOptionPane.showConfirmDialog(new JFrame(),
                        "Vous-voulez vraiment supprimer cette élève ?", "Suppression d'un élève !",
                        JOptionPane.OK_CANCEL_OPTION);

                if (retour == 0) {
                    try {
                        if(etudiantSelected[0] != null){
                            etudiantService.delete(etudiantSelected[0].getId());
                        }
                        _clearForm();
                        _updateListEtudiant();


                    } catch (DeleteEtudiantServiceException deleteEtudiantServiceException) {
                        error_label.setText(deleteEtudiantServiceException.getMessage());
                    }
                    JOptionPane.showMessageDialog(null,
                            " Etudiant Supprimer avec succée ! ");
                }
            }


        });
    }

    private void _updateListEtudiant() {
        EtudiantService etudiantService = new EtudiantService();
        comboBox.removeAllItems();
        comboBox.addItem("");
        try {
            for (Etudiant etudiant : etudiantService.getAll()) {
                comboBox.addItem(etudiant);
            }
        } catch (GetAllEtudiantServiceException getAllEtudiantServiceException) {
            error_label.setText(getAllEtudiantServiceException.getMessage());
        }
    }



    private void _clearForm() {
        input_nom.setText("");
        input_prenom.setText("");
        input_mail.setText("");
        input_adresse.setText("");
        input_tel.setText("");
        error_label.setText("");
        dateChooser.setDate(new Date());
    }


}
