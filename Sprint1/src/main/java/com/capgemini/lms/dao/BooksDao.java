package com.capgemini.lms.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;

/*********************************************************************************************************
 * @author      Rakshit Singh
 * Description : This is the DAO class for Books
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *********************************************************************************************************/

@Repository
public interface BooksDao extends JpaRepository<Books, Integer> {
	List<Books> searchBookByTitle(String keyword) throws BookNotFoundException;
	List<Books> searchBookBySubject(String keyword) throws BookNotFoundException;	
}
