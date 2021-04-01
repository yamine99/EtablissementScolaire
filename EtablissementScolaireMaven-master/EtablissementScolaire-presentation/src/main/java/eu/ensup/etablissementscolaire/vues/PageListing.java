package eu.ensup.etablissementscolaire.vues;


import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Page listing.
 */
public class PageListing extends Fenetre
{
    private JButton Btn_retour;
    private JTable tab_etudiants;
    private JPanel panelMain;
    private JLabel label_count;
    private JScrollPane scrollPane;

    /**
     * Instantiates a new Page listing.
     *
     * @param user the user
     * @throws GetAllEtudiantServiceException the get all etudiant service exception
     */
    public PageListing(Responsable user) throws GetAllEtudiantServiceException {
        super("Listing",user);
        this.setContentPane(panelMain);

        SimpleDateFormat sdf = new SimpleDateFormat(
                "dd-MM-yyyy");
        EtudiantService etudiantService = new EtudiantService();
        List<Etudiant> etudiants = new ArrayList<Etudiant>(etudiantService.getAll());

        int nbEtudiants = etudiants.size();
        label_count.setText("Il y a "+ nbEtudiants +" étudiants");

        TableModel dataModel = new
                AbstractTableModel() {
                    public int getColumnCount() {
                        return 5;
                    }

                    public int getRowCount() {
                        return nbEtudiants;
                    }

                    public Object getValueAt(int row, int col) {
                        Object value = null;
                        Etudiant etudiant = etudiants.get(row);
                        switch(col){
                            case 0:
                                value = etudiant.getPrenom();
                                break;
                            case 1:
                                value = etudiant.getNom();
                                break;
                            case 2:
                                value = sdf.format(etudiant.getDateNaissance());
                                break;
                            case 3:
                                value = etudiant.getEmail();
                                break;
                            case 4:
                                value = etudiant.getAdresse();
                                break;
                            default:
                                break;
                        }
                        return value;
                    }
                };
        tab_etudiants.setModel(dataModel);
        tab_etudiants.getColumnModel().getColumn(0).setHeaderValue("Prenom");
        tab_etudiants.getColumnModel().getColumn(1).setHeaderValue("Nom");
        tab_etudiants.getColumnModel().getColumn(2).setHeaderValue("Date de naissance");
        tab_etudiants.getColumnModel().getColumn(3).setHeaderValue("Email");
        tab_etudiants.getColumnModel().getColumn(4).setHeaderValue("Adresse");
        tab_etudiants.repaint();

        Btn_retour.addActionListener(e -> {
            new PagePrincipal(user).setVisible(true);
            PageListing.super.setVisible(false);

        });

    }




}

