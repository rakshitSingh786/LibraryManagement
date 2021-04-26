package com.capgemini.lms.entities;

import java.util.Date;

import javax.persistence.*;

/********************************************************************************************************************************

 * @author Rakshit Singh
 * Description: This class is used for books order entity
 * Version v1.1
 * Created date: 21 April 2021
 
********************************************************************************************************************************/

@Entity
@Table(name = "booksorder")
public class BooksOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookid")
	private Books books;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "publisherId")
	private Publishers publishers;
	
	private int quantity;
	private Date orderDate;
	private String orderStatus;
	public BooksOrder() {
		super();
	}
	public BooksOrder(int orderId, Date orderDate, String orderStatus,  int quantity, 
			Books books, Publishers publishers) {
//		BooksOrder bo1=new BooksOrder(9000,"15-FEB-21 12.00.00.000000 AM","Pending",98,5,900);
		super();
		this.orderId = orderId;
		this.books = books;
		this.publishers = publishers;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Publishers getPublishers() {
		return publishers;
	}
	public void setPublishers(Publishers publishers) {
		this.publishers = publishers;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	@Override
	public String toString() {
		return "BooksOrder [orderId=" + orderId + ", books=" + books + ", publishers=" + publishers + ", quantity="
				+ quantity + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BooksOrder other = (BooksOrder) obj;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
