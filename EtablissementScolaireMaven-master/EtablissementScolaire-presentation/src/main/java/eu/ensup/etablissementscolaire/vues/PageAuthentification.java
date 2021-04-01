
package eu.ensup.etablissementscolaire.vues;


import eu.ensup.etablissementscolaire.ResponsableService;
import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.EmailFormatException;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Page authentification.
 */
public class PageAuthentification extends Fenetre {
    private JLabel titre;
    private JPanel panel1;
    private JButton btn_connexion;
    private JPanel panel2;
    private JButton btn_quitter;
    private JTextField input_mail;
    private JPasswordField input_mdp;
    private JPanel panelMain;
    private JLabel erreurLabel;
    /**
     * The constant VALID_EMAIL_ADDRESS_REGEX.
     */
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Gets input mail.
     *
     * @return the input mail
     */
    public JTextField getInput_mail() {
        return input_mail;
    }

    /**
     * Gets input mdp.
     *
     * @return the input mdp
     */
    public JPasswordField getInput_mdp() {
        return input_mdp;
    }

    /**
     * Instantiates a new Page authentification.
     */
    public PageAuthentification( ) {

        super("Authentification",null);

        ResponsableService responsableService = new ResponsableService();

        this.setContentPane(panelMain);

        this.btn_connexion.addActionListener(e -> {

            try {
                validate(input_mail.getText());

                user = responsableService.getCredentialByEmail(input_mail.getText());
                //Vérification du mot de passe et l'adresse mail
                //throw new NoSuchAlgorithmException();
                responsableService.validAuthentification(user, String.valueOf(input_mdp.getPassword())); //input_mail.getText() =="" && input_mdp.getText() ==""
                new PagePrincipal(user).setVisible(true);
                PageAuthentification.super.setVisible(false);

            } catch (EmailFormatException | CredentialException | NoSuchAlgorithmException excep) {
                erreurLabel.setText( excep.getMessage() );
            }
        });

        btn_quitter.addActionListener(e -> {
            PageAuthentification.super.quitter();
            System.exit(0);
        });
    }

    /**
     * Validate.
     *
     * @param emailStr the email str
     * @throws EmailFormatException the email format exception
     */
    public static void validate(String emailStr) throws EmailFormatException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.find() ) {
            throw new EmailFormatException();
        }
    }


}
