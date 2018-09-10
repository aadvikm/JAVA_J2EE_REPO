package com.struts2practice.exception;

public class LocationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LocationException() {
		super();
	}

	public LocationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public LocationException(String message) {
		super(message);
	}

	public LocationException(Throwable cause) {
		super(cause);
	}

}
