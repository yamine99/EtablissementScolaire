package eu.ensup.etablissementscolaire.vues;


import eu.ensup.etablissementscolaire.Responsable;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * The type Fenetre.
 */
public class Fenetre extends JFrame {

	/**
	 * The User.
	 */
	protected Responsable user;

	/**
	 * Instantiates a new Fenetre.
	 *
	 * @param nomFenetre the nom fenetre
	 * @param user       the user
	 */
	public Fenetre (String nomFenetre,Responsable user){

		// Modifier le nom
					this.setTitle(nomFenetre);
					this.user = user;
					
					//Taille non modifiable par l'utlisateur
					this.setSize(1000,600);
					
					//La fermeture de la fen�tre
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					// Centrer la fen�tre par rappot � l'�cran
					this.setLocationRelativeTo(null);
		
		
	
	}

	/**
	 * Quitter.
	 */
	public void quitter() {
		this.setVisible(false);
		this.dispose();
	}

	//Afficher la JFrame
	//fenetre.setVisible(true);
	
	}
