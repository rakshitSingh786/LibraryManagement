package com.capgemini.lms.exception;

public class OrderNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	String message;
	  public OrderNotFoundException(String message)
	  {
		  this.message=message;
	  }
	  
	  @Override
	  public String getMessage() {
		  return message;
	  }

}
