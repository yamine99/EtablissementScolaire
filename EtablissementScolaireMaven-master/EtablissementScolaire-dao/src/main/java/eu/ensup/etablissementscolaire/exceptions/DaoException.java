package eu.ensup.etablissementscolaire.exceptions;

/**
 * The type Dao exception.
 */
public class DaoException extends Exception
{
	private String nameObject; //Nom de l'object dans la base de donnée
	private String typeAction; //Action crud
	private String initialException; //Nom de la class d'Exception d'origine

	/**
	 * Instantiates a new Dao exception.
	 *
	 * @param nameObject       the name object
	 * @param typeAction       the type action
	 * @param initialException the initial exception
	 */
	public DaoException(String nameObject, String typeAction, String initialException)
	{
		super();
		this.nameObject       = nameObject;
		this.typeAction       = typeAction;
		this.initialException = initialException;
	}

	/**
	 * Instantiates a new Dao exception.
	 *
	 * @param message          the message
	 * @param nameObject       the name object
	 * @param typeAction       the type action
	 * @param initialException the initial exception
	 */
	public DaoException(String message, String nameObject, String typeAction, String initialException)
	{
		super(message);
		this.nameObject       = nameObject;
		this.typeAction       = typeAction;
		this.initialException = initialException;
	}

	/**
	 * Instantiates a new Dao exception.
	 *
	 * @param message          the message
	 * @param cause            the cause
	 * @param nameObject       the name object
	 * @param typeAction       the type action
	 * @param initialException the initial exception
	 */
	public DaoException(String message, Throwable cause, String nameObject, String typeAction, String initialException)
	{
		super(message, cause);
		this.nameObject       = nameObject;
		this.typeAction       = typeAction;
		this.initialException = initialException;
	}

	/**
	 * Instantiates a new Dao exception.
	 *
	 * @param cause            the cause
	 * @param nameObject       the name object
	 * @param typeAction       the type action
	 * @param initialException the initial exception
	 */
	public DaoException(Throwable cause, String nameObject, String typeAction, String initialException)
	{
		super(cause);
		this.nameObject       = nameObject;
		this.typeAction       = typeAction;
		this.initialException = initialException;
	}

	/**
	 * Gets name object.
	 *
	 * @return the name object
	 */
	public String getNameObject() {
		return nameObject;
	}

	/**
	 * Gets type action.
	 *
	 * @return the type action
	 */
	public String getTypeAction() {
		return typeAction;
	}

	/**
	 * Gets initial exception.
	 *
	 * @return the initial exception
	 */
	public String getInitialException() {
		return initialException;
	}
}