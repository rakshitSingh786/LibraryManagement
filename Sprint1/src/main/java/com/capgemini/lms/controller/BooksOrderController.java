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

@RestController
@RequestMapping("/bookorder")
public class BooksOrderController {
	@Autowired
	BooksOrderService booksOrderService;
	

	@GetMapping(value="/all",produces="application/json")
	public  ResponseEntity<List<BooksOrder>> getAllBooksOrder(){
		return new ResponseEntity<List<BooksOrder>> (booksOrderService.viewOrdersList(),HttpStatus.OK);
	}

	@GetMapping(value="/{orderId}",produces="application/json")
	public ResponseEntity<BooksOrder> getBookOrderById(@PathVariable("orderId") int orderId){
		Optional<BooksOrder> b=booksOrderService.viewOrderById(orderId);
		if(b.isPresent())	
			return new ResponseEntity<BooksOrder>(booksOrderService.viewOrderById(orderId).get(),HttpStatus.OK);
		else
			throw new OrderNotFoundException("No book found with given value "+ orderId);
			
	}
	
@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addBooksOrder(@RequestBody BooksOrder booksorder){
		booksOrderService.placeBooksOrder(booksorder);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyBooksOrder(@RequestBody BooksOrder booksorder){
		Optional<BooksOrder> b=booksOrderService.updateOrder(booksorder);
		if(b.isPresent())
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		else
			throw new OrderNotFoundException("No book found with given value "+ booksorder);
			
	}
	
@DeleteMapping(value="/{orderId}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId")int orderId)
	{
//		try
//		{
//		booksOrderService.cancelOrder(orderId);;
//		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//		}
//		catch(Exception e)
//		{
//			throw new OrderNotFoundException("No book order found with given value "+ orderId);
//		}
	
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