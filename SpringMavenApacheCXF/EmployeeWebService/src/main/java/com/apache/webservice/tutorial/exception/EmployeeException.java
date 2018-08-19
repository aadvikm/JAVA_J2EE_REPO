package com.apache.webservice.tutorial.exception;

public class EmployeeException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public EmployeeException() {}
  
  public EmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
  public EmployeeException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public EmployeeException(String message) {
    super(message);
  }
  
  public EmployeeException(Throwable cause) {
    super(cause);
  }
}