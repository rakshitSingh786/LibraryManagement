package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.entities.Books;


/*********************************************************************************************************
 * @author     Rakshit Singh
 * Description : This is the Service Implementation class for Books
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 ********************************************************************************************************/

@Service
public class BookServiceImpl implements BookService  {
	 @Autowired
     BooksDao booksdao;
     
     
	@Override
	public Books addBook(Books book) {
		booksdao.save(book);
		return book;
	}

	@Override
	public Books updateBookDetails(Books book) {
		booksdao.save(book);
		return book;
		
	}

	@Override
	public int removeBook(int bookid) {
		booksdao.deleteById(bookid);
		return bookid;
		
	}

	@Override
	public List<Books> searchBookByTitle(String keyword) {
		return booksdao.searchBookByTitle(keyword);
		
	}

	@Override
	public List<Books> searchBookBySubject(String keyword) {
		return booksdao.searchBookBySubject(keyword);
	}

	@Override
	public List<Books> viewAllBooks() {
		return booksdao.findAll();
	}
	
	
	public Optional<Books> viewBooksById(int bookId) {
		return booksdao.findById(bookId);
	}
	
//	public Books searchBookByCode(String code)
//	{
//		return booksdao.searchBookByCode(code);
//	}


}
