package com.capgemini.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.service.BookService;


/*********************************************************************************************************************
 * @author Rakshit Singh
 * Description: This is the rest controller class for Books. 
 * Created Date: 23 April, 2021 
 * Version : v1.0.0
 ********************************************************************************************************************/


@RestController
@RequestMapping("/book")
public class BooksController {
	@Autowired
	BookService booksService;
	

	
	/*****************************************************************************************
	 * Method      : getAllBooks     
	 * @return       List of Books
	 * Description : This method fetches List of all books 
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	@GetMapping(value="/all",produces="application/json")
	public  ResponseEntity<List<Books>> getAllBooks(){
		return new ResponseEntity<List<Books>> (booksService.viewAllBooks(),HttpStatus.OK);
	}
	
	
	/*****************************************************************************************
	 * Method      : getBooksBySubject     
	 * @return       List of Books
	 * Description : This method fetches List of all books based on Subject 
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	
	@GetMapping(value="/sub/{Subject}",produces="application/json")
	public ResponseEntity<List<Books>> getBooksBySubject(@PathVariable("Subject")String Subject) { 
		List<Books> b=booksService.searchBookBySubject(Subject);
		if(b.isEmpty())	
			throw new BookNotFoundException("No book found with given value "+ Subject);
		else
			return new ResponseEntity<List<Books>>(booksService.searchBookBySubject(Subject),HttpStatus.OK);
	}
	
	
	/*****************************************************************************************
	 * Method      : getBooksByTitle     
	 * @return       List of Books
	 * Description : This method fetches List of all books based on Title 
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	@GetMapping(value="/{Title}",produces="application/json")
	public ResponseEntity<List<Books>> getBooksByTitle(@PathVariable("Title")String Title){ 
		List<Books> b=booksService.searchBookByTitle(Title);
		if(b.isEmpty())	
			throw new BookNotFoundException("No book found with given value "+ Title);
		else
			return new ResponseEntity<List<Books>>(booksService.searchBookByTitle(Title),HttpStatus.OK);
	}
	
	
	
	/*****************************************************************************************
	 * Method      : addBooks     
	 * @param        Book 
	 * @return       Response Entity of Object type
	 * Description : This method adds the Book details to the database
	 * @Postmapping : Post mapping requests a body from the user
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addBooks(@RequestBody Books book){
		booksService.addBook(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	
	/******************************************************************************************
	* Method      : modifyBooks     
	* @param        Book
	* @return       Response Entity of Object type
	* Description : This method modifies the Book details
	* @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
	******************************************************************************************/

	
	
	@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyBooks(@RequestBody Books book){
		booksService.updateBookDetails(book);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);	
	}

	
	
	/*****************************************************************************
	* Method      : deleteBook 
	* @param        Book Id
	* @return       Response Entity of Object type
	* Description : This method deletes the Book based on id.
	* @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
	******************************************************************************/	
	
	
	
	@DeleteMapping(value="/{bookid}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookid")int bookid)
	{
	
		try {
			booksService.removeBook(bookid);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
	
		catch(Exception e)
		{
			throw new BookNotFoundException("No book found with given value "+ bookid); 
		}
	}
}