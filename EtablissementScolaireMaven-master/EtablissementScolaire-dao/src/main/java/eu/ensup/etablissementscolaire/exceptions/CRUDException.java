package eu.ensup.etablissementscolaire.exceptions;

import java.sql.SQLException;

/**
 * The type Crud exception.
 */
public class CRUDException extends DaoException
{
	private String codesErreurs;

	/**
	 * Instantiates a new Crud exception.
	 *
	 * @param cause      the cause
	 * @param nomObjet   the nom objet
	 * @param nomMethode the nom methode
	 */
	public CRUDException(Throwable cause, String nomObjet, String nomMethode)
	{
		super(cause,nomObjet,nomMethode,cause.getClass().toString());
		this.codesErreurs = "";
		
		SQLException sqle = ((SQLException)cause);
		do
		{
			if( this.codesErreurs != "" )
				this.codesErreurs += ", ";
			
			this.codesErreurs += sqle.getErrorCode();
			
		}while( sqle.getNextException() != null );
	}
	
	public String getMessage()
	{
		return "Problème pour "+super.getTypeAction()+" l'objet "+super.getNameObject()+". Type sql exception: "+this.codesErreurs;
	}
}
