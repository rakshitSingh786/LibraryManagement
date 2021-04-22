package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;
@Repository
public interface BooksDao extends JpaRepository<Books, Integer> {
//	public int addBook(Books book);
//	public int updateBookDetails(Books book);
//	public int removeBook(int bookid) throws BookNotFoundException;
	List<Books> searchBookByTitle(String keyword) throws BookNotFoundException;
	List<Books> searchBookBySubject(String keyword) throws BookNotFoundException;
//	public List<Books> viewAllBooks();
	
}
