package com.capgemini.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.exception.OrderNotFoundException;

/*********************************************************************************************************
 * @author      Rakshit Singh
 * Description : This is the DAO class for Books Order
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *********************************************************************************************************/

@Repository
public interface BooksOrderDao extends JpaRepository<BooksOrder, Integer>{

}
