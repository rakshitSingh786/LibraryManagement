package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;

public interface BooksOrderService {
	public BooksOrder placeBooksOrder(BooksOrder order);
	public int cancelOrder(int orderId);
	public Optional<BooksOrder> updateOrder(BooksOrder order);
	public List<BooksOrder> viewOrdersList();
	public Optional<BooksOrder> viewOrderById(int orderId);
}
