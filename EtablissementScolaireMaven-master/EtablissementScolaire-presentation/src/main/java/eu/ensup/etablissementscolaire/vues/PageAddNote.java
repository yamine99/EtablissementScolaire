package eu.ensup.etablissementscolaire.vues;


import eu.ensup.etablissementscolaire.*;
import eu.ensup.etablissementscolaire.exception.NoteFormatException;
import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageAddNote extends Fenetre {
    private JPanel PanelMain;
    private JComboBox comboxListeEtudiant;
    private JComboBox comboBoxMatiere;
    private JLabel labelEtu;
    private JTextField textNote;
    private JButton btn_addNote;
    private JButton retourButton;
    private JLabel error_label;
    private JLabel info_label;
    List<Etudiant> etudiants;
    EtudiantService etudiantService = new EtudiantService();
    List<Matiere> matieres;
    MatiereService matiereService = new MatiereService();

    public static final Pattern VALID_NOTE_REGEX =
            Pattern.compile("^[0-9]{1,2}$", Pattern.CASE_INSENSITIVE);

    /**
     * Instantiates a new Fenetre.
     *
     * @param nomFenetre the nom fenetre
     * @param user       the user
     */
    public PageAddNote(String nomFenetre, Responsable user) {
        super(nomFenetre, user);
    }
    public PageAddNote( Responsable user) {
        super("Ajouter une note", user);
        this.setContentPane(PanelMain);

        _updateListEtudiant();
        _updateListMatiere();

        retourButton.addActionListener(e -> {
            new PagePrincipal(user).setVisible(true);
            PageAddNote.super.setVisible(false);
        });

        btn_addNote.addActionListener(e -> {

            final Etudiant etudiantSelected;
            final Matiere matiereSelected;

            try {
                if (comboxListeEtudiant.getSelectedIndex() == 0 || comboBoxMatiere.getSelectedIndex() == 0 ){
                    error_label.setText("Veuillez sélectionner une valeur dans les deux comboBox.");
                }else{
                    if(textNote.getText().isEmpty()){
                        error_label.setText("Le champs note est vide");
                    }else {
                        if (validate(textNote.getText())) {
                            error_label.setText("");
                            if (Float.parseFloat(textNote.getText()) > 20) {
                                error_label.setText("La note ne peut pas être supérieur à 20");
                            } else if (Float.parseFloat(textNote.getText()) < 0) {
                                error_label.setText("La note ne peut pas être inférieur à 0");
                            } else {
                                etudiantSelected = (Etudiant) comboxListeEtudiant.getSelectedItem();
                                matiereSelected = (Matiere) comboBoxMatiere.getSelectedItem();
                                new NoteEleveService().addNoteEleve(new NoteEleve(1, Float.parseFloat(textNote.getText())), etudiantSelected, matiereSelected);
                                info_label.setText("La note à été ajouté ");
                            }
                        }
                    }
                }
            } catch (NoteFormatException | DaoException ex) {
                error_label.setText(ex.getMessage());;
            }
        });
    }
    private void _updateListEtudiant(){

        comboxListeEtudiant.removeAllItems();
        comboxListeEtudiant.addItem("");
        etudiants = new ArrayList<>();
        try {
            etudiants.addAll(etudiantService.getAll());
            for (Etudiant etudiant: etudiants) {
                comboxListeEtudiant.addItem(etudiant);
            }
        } catch (GetAllEtudiantServiceException getAllEtudiantServiceException) {
            error_label.setText(getAllEtudiantServiceException.getMessage());
        }
    }
    private void _updateListMatiere() {
        comboBoxMatiere.removeAllItems();
        comboBoxMatiere.addItem("");
        matieres = new ArrayList<>();
        try {

            matieres.addAll(matiereService.getAll());
            for (Matiere matiere: matieres) {
                comboBoxMatiere.addItem(matiere);
            }
        } catch (ServiceException e) {
            error_label.setText(e.getMessage());
        }
    }

    public static boolean validate(String note) throws NoteFormatException {
        Matcher matcher = VALID_NOTE_REGEX.matcher(note);
        if(!matcher.find() ) {
            throw new NoteFormatException();
        }
        return true;

    }

}
