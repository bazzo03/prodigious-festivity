package com.prodigious.festivity.exception;

/**
 * @author Daniel Bernal Bazzani
 * @version 0.0.1
 * @since 0.0.1
 *
 *        Own exception to handle errors
 */
public class ProdigiousException extends Exception {

	/** Generated serial version */
	private static final long serialVersionUID = 488574175180154869L;

	/**
	 * Constructor to handle Exception
	 */
	public ProdigiousException() {
		super();
	}

	/**
	 * Constructor to handle Exception
	 * 
	 * @param message
	 *            related to the error
	 */
	public ProdigiousException(String message) {
		super(message);
	}

	/**
	 * Constructor to handle Exception
	 * 
	 * @param message
	 *            related to the error
	 * @param cause
	 *            of the failure
	 */
	public ProdigiousException(String message, Throwable cause) {
		super(message, cause);
	}
}
