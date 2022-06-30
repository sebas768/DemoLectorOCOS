package com.pronaca.osoc.lecturaxml.exceptions;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2679799019261872170L;

	public DAOException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DAOException(final String message) {
		super(message);
	}

	public DAOException(final Throwable cause) {
		super(cause);
	}

}
