package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.service.BookServiceImpl;


/******************************************************************************************************************
 * @author Rakshit Singh
 * Description: This is the JUNIT class for Books module. 
 * Created Date: 26 April, 2021 
 * Version : v1.1.0
 *****************************************************************************************************************/


@SpringBootTest
//public 
	class TestBooks {
	@Autowired
	BooksDao booksDao;
	@Autowired
	BookServiceImpl bookService;
	@Test
	void testaddBook() {
		Books b1=new Books(5,"Esha",261,"Mno",2006,"Time",18,"Bad","Rollgroup","Everything");
		assertEquals("Esha",bookService.addBook(b1).getAuthor());	
	}
	
	@Test
	void testServiceUpdateBooks() {
		Books b2=new Books(4,"Ujjain",164,"Pqr",2016,"Time",18,"Bad","Rollgroup","Everything");
		booksDao.save(b2);
		Books test=booksDao.findById(4).get();
		assertEquals("Ujjain",test.getAuthor());
	}
		
		
//	@Test
//		void testDeleteBook( ) {
//			Books b3=new Books(7,"Eeepr",115,"sfd",2020,"Lot",20,"Bad","Rollq","Qthing");
//			bookService.addBook(b3);
//			Books book= bookService.searchBookByCode("sfd");
//			bookService.removeBook(book.getBookid());
//			assertThrows(EmptyResultDataAccessException.class,()->bookService.searchBookByCode("sfd").getBookid());
//	}
	
	@Test
		void testGetAllBooksBySubject() {
			List<Books> b=bookService.searchBookBySubject("Rolldown");
			List<Books> expb=new ArrayList<Books>();
			expb.add(booksDao.findById(2).get());
			assertArrayEquals(expb.toArray(),b.toArray());
		}
	
	@Test
		void testGetAllBooksByTitle() {
			List<Books> t=bookService.searchBookByTitle("Anything");
			List<Books> expt=new ArrayList<Books>();
			expt.add(booksDao.findById(2).get());
			assertArrayEquals(expt.toArray(),t.toArray());
		}
	
	@Test
	void testGetAllBooks() {
		List<Books> bks=bookService.viewAllBooks();
	
		List< Books> expectedBookss= new ArrayList<Books>();
		expectedBookss.add(booksDao.findById(4).get());
//		expectedBookss.add(booksDao.findById(78).get());
		expectedBookss.add(booksDao.findById(1).get());
		expectedBookss.add(booksDao.findById(2).get());
		expectedBookss.add(booksDao.findById(3).get());
		expectedBookss.add(booksDao.findById(41).get());
		
		assertArrayEquals(expectedBookss.toArray(),bks.toArray());
	}
	
	
}
