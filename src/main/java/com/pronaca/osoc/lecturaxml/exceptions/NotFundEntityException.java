package com.pronaca.osoc.lecturaxml.exceptions;

public class NotFundEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2679799019261872170L;

	public NotFundEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NotFundEntityException(final String message) {
		super(message);
	}

	public NotFundEntityException(final Throwable cause) {
		super(cause);
	}

}
