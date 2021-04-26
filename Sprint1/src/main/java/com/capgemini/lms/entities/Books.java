package com.capgemini.lms.entities;

import javax.persistence.*;

/********************************************************************************************************************************
 
 * @author Rakshit Singh
 * Description: This class is used for books entity
 * Version v1.1
 * Created date: 21 April 2021
 
********************************************************************************************************************************/

@Entity
@Table(name = "books")
public class Books {
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", title=" + title + ", subject=" + subject + ", author=" + author
				+ ", publisher=" + publisher + ", published_year=" + published_year + ", isbn_code=" + isbn_code
				+ ", quantity=" + quantity + ", book_cost=" + book_cost + ", shelf_details=" + shelf_details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		long temp;
		temp = Double.doubleToLongBits(book_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bookid;
		result = prime * result + ((isbn_code == null) ? 0 : isbn_code.hashCode());
		result = prime * result + published_year;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((shelf_details == null) ? 0 : shelf_details.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Books other = (Books) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (Double.doubleToLongBits(book_cost) != Double.doubleToLongBits(other.book_cost))
			return false;
		if (bookid != other.bookid)
			return false;
		if (isbn_code == null) {
			if (other.isbn_code != null)
				return false;
		} else if (!isbn_code.equals(other.isbn_code))
			return false;
		if (published_year != other.published_year)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (quantity != other.quantity)
			return false;
		if (shelf_details == null) {
			if (other.shelf_details != null)
				return false;
		} else if (!shelf_details.equals(other.shelf_details))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

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
	
	public Books(int bookid, String author, double book_cost, String isbn_code, int published_year, String publisher, int quantity,
			String shelf_details,  String subject, String title  ) {

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
