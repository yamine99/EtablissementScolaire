package eu.ensup.etablissementscolaire;



import eu.ensup.etablissementscolaire.vues.PageAuthentification;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



/**
 * The type Lanceur.
 */
public class Lanceur {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            // TODO Auto-generated method stub
            // Instancier une fenetre
            PageAuthentification f1 = new PageAuthentification();

            //Afficher la JFrame
            f1.setVisible(true);
        } catch (UnsupportedLookAndFeelException e) {

        }
    }

}
