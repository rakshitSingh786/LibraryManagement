package com.capgemini.lms.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

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
import com.capgemini.lms.exception.OrderNotFoundException;
import com.capgemini.lms.exception.PublisherNotFoundException;
import com.capgemini.lms.service.BookService;
import com.capgemini.lms.service.BooksOrderService;

/*********************************************************************************************************************
 * @author Rakshit Singh
 * Description: This is the rest controller class for Books Order. 
 * Created Date: 23 April, 2021 
 * Version : v1.0.0
 ********************************************************************************************************************/



@RestController
@RequestMapping("/bookorder")
public class BooksOrderController {
	@Autowired
	BooksOrderService booksOrderService;
	
	
	/*****************************************************************************************
	 * Method      : getAllBooksOrder     
	 * @return       List of Books Order
	 * Description : This method fetches List of all books order 
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/

	
	@GetMapping(value="/all",produces="application/json")
	public  ResponseEntity<List<BooksOrder>> getAllBooksOrder(){
		return new ResponseEntity<List<BooksOrder>> (booksOrderService.viewOrdersList(),HttpStatus.OK);
	}

	
	
	/*****************************************************************************************
	 * Method      : getBookOrderById       
	 * @param      : order Id
	 * @return       BooksOrder object
	 * Description : This method fetches a Book Order based on the order id.
	 * @getmapping : Get mapping expects a PathVariable to be passed 
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	
	
	@GetMapping(value="/{orderId}",produces="application/json")
	public ResponseEntity<BooksOrder> getBookOrderById(@PathVariable("orderId") int orderId){
		Optional<BooksOrder> b=booksOrderService.viewOrderById(orderId);
		if(b.isPresent())	
			return new ResponseEntity<BooksOrder>(booksOrderService.viewOrderById(orderId).get(),HttpStatus.OK);
		else
			throw new OrderNotFoundException("No book found with given value "+ orderId);
			
	}
	
	
	/*****************************************************************************************
	 * Method      : addBooksOrder     
	 * @param        Books Order
	 * @return       Response Entity of Object type
	 * Description : This method adds the Books Order details to the database
	 * @Postmapping : Post mapping requests a body from the user
	 *               which is then used to return the entity object 
	 *               that is fetched from the database.
	 ****************************************************************************************/
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addBooksOrder(@RequestBody BooksOrder booksorder){
		booksOrderService.placeBooksOrder(booksorder);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}



/******************************************************************************************
* Method      : modifyBooksOrder     
* @param        BooksOrder
* @return       Response Entity of Object type
* Description : This method modifies the Book Order details
* @PutMapping annotation  is used for mapping HTTP PUT requests onto specific handler methods.
******************************************************************************************/

	@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyBooksOrder(@RequestBody BooksOrder booksorder){
		Optional<BooksOrder> b=booksOrderService.updateOrder(booksorder);
		if(b.isPresent())
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		else
			throw new OrderNotFoundException("No book found with given value "+ booksorder);
			
	}
	
	
	
	/*****************************************************************************
	* Method      : deleteBookOrder 
	* @param        Order Id
	* @return       Response Entity of Object type
	* Description : This method deletes the Book Order based on id.
	* @deletemapping: @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods.
	******************************************************************************/
	
	
	@DeleteMapping(value="/{orderId}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId")int orderId)
	{	
	Optional<BooksOrder> b= (Optional)booksOrderService.viewOrderById(orderId);
	if(b.isPresent())
	{
		booksOrderService.cancelOrder(orderId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	else
		throw new PublisherNotFoundException("No book order found with given value "+orderId);
	}



}