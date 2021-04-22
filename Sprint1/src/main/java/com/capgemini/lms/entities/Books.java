package com.capgemini.lms.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	private String title;
	private String subject;
	private String author;
	private String publisher;
	private int published_year;
	private String isbn_code;
	private int quantity;
	private double book_cost;
	private String shelf_details;
	
	public Books() {
		super();
	}
	
	public Books(int bookid, String title, String subject, String author, String publisher, int published_year,
			String isbn_code, int quantity, double book_cost, String shelf_details) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publisher = publisher;
		this.published_year = published_year;
		this.isbn_code = isbn_code;
		this.quantity = quantity;
		this.book_cost = book_cost;
		this.shelf_details = shelf_details;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}

	public String getIsbn_code() {
		return isbn_code;
	}

	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBook_cost() {
		return book_cost;
	}

	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;
	}

	public String getShelf_details() {
		return shelf_details;
	}

	public void setShelf_details(String shelf_details) {
		this.shelf_details = shelf_details;
	}
	
	
	
}
