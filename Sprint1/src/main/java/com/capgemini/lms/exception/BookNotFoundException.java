package com.capgemini.lms.exception;

public class BookNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	 String message;
	  public BookNotFoundException(String message)
	  {
		  this.message=message;
	  }
	  
	  @Override
	  public String getMessage() {
		  return message;
	  }

}
