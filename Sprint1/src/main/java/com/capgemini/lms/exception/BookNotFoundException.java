package com.capgemini.lms.exception;

/*********************************************************************************************************
 * @author       Rakshit Singh
 * Description : This is the Exception class for Books
 * Created Date: 23 April, 2021 
 * Version     : v1.1.0
 ********************************************************************************************************/


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
