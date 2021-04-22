package com.capgemini.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.exception.OrderNotFoundException;

@Repository
public interface BooksOrderDao extends JpaRepository<BooksOrder, Integer>{
//	public int placeBooksOrder(Books book);
//	public int cancelOrder(int orderId) throws OrderNotFoundException;
//	public int updateOrder(BooksOrder order) throws OrderNotFoundException;
//	public List<BooksOrder> viewOrdersList();
//	public Optional<BooksOrder> viewOrderById(int orderId) throws OrderNotFoundException;
}
