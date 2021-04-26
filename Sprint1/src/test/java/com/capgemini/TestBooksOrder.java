package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.dao.BooksOrderDao;
import com.capgemini.lms.dao.PublisherDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.service.BooksOrderService;

/******************************************************************************************************************
 * @author Rakshit Singh
 * Description: This is the JUNIT class for Books Order module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************************************************************************************************/


@SpringBootTest
public class TestBooksOrder {
	@Autowired
	BooksOrderService booksOrderService;
	@Autowired
	BooksDao booksDao;
	@Autowired
	PublisherDao publisherDao;
	@Autowired
	BooksOrderDao booksOrderDao;
	@Test
	void testAddBooksOrder() {
		BooksOrder bo1=new BooksOrder(9000, Date.valueOf("2015-02-21"), "Pending", 98, booksDao.findById(41).get(), 
				publisherDao.findById(103).get());
		assertEquals("Pending",booksOrderService.placeBooksOrder(bo1).getOrderStatus());
	}
	
	
	
	@Test
	void testUpdateBooksOrder() {
		BooksOrder b= booksOrderDao.findById(1001).get();
		b.setQuantity(10);
		booksOrderService.updateOrder(b);
		assertEquals(10,booksOrderService.viewOrderById(1001).get().getQuantity());	
	}
	
	
	@Test
	void testGetAllBooksOrder() {
		List<BooksOrder> bko=booksOrderService.viewOrdersList();
	
		List< BooksOrder> expectedBooksOrders= new ArrayList<BooksOrder>();
		expectedBooksOrders.add(booksOrderDao.findById(81).get());
//		expectedBooksOrders.add(booksOrderDao.findById(78).get());
		expectedBooksOrders.add(booksOrderDao.findById(1001).get());
		expectedBooksOrders.add(booksOrderDao.findById(1002).get());
		expectedBooksOrders.add(booksOrderDao.findById(1003).get());
		
		assertArrayEquals(expectedBooksOrders.toArray(),bko.toArray());
	}
	
	@Test
	void testGetBookOrder() {
		BooksOrder bko=booksOrderService.viewOrderById(1003).get();		
		assertEquals("Confirmed",bko.getOrderStatus());
	}
	
}
