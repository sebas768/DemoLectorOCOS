package com.pronaca.osoc.lecturaxml.exceptions;

public class ValidaEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2679799019261872170L;

	public ValidaEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ValidaEntityException(final String message) {
		super(message);
	}

	public ValidaEntityException(final Throwable cause) {
		super(cause);
	}
}
