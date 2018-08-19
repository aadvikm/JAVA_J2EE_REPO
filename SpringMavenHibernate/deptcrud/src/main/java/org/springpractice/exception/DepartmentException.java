package org.springpractice.exception;

public class DepartmentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DepartmentException() {
	}

	public DepartmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentException(String message) {
		super(message);
	}

	public DepartmentException(Throwable cause) {
		super(cause);
	}
}