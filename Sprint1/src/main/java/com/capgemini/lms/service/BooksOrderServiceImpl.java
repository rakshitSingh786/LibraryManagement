package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.BooksOrderDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;

/*********************************************************************************************************
 * @author     Rakshit Singh
 * Description : This is the Service Implementation class for Books Order
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 ********************************************************************************************************/

@Service
public class BooksOrderServiceImpl implements BooksOrderService {
	
	@Autowired
	BooksOrderDao booksorderdao;
	
	@Override
	public BooksOrder placeBooksOrder(BooksOrder order) {
		booksorderdao.save(order);
		return order;
	}

	@Override
	public int cancelOrder(int orderId) {
		booksorderdao.deleteById(orderId);
		return orderId;
	}

	@Override
	public Optional<BooksOrder> updateOrder(BooksOrder order) {
		booksorderdao.save(order);
		return Optional.of(order);
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		return booksorderdao.findAll();
	}

	@Override
	public Optional<BooksOrder> viewOrderById(int orderId) {
		return booksorderdao.findById(orderId);
	}
	
	
}
