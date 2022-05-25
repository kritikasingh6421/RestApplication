/**
 * 
 */
package com.nagarro.rest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Book is class which allow an application to initialize Book attributes
 * like code, book name, author and date during new
 * object creation for book.
 * @author kritikasingh02
 *
 */
@Entity
@Table(name="BOOK")
@Data
@Builder
public class Book {

	/**
	 * 
	 */
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookCode
	 * @param bookName
	 * @param author
	 * @param date
	 */
	public Book(int bookCode, String bookName, String author, String date) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.date = date;
	}

	@Id
	@NotNull
	@Column(name="bookCode")
	private int bookCode;// Deceleration of code attribute
	
	@NotNull
	@Column(name="bookName")
	private String bookName;// Deceleration of Book name attribute
	
	@NotNull
	@Column(name="author")
	private String author;// Deceleration of author attribute
	
	@NotNull
	@Column(name="date")
	private String date;// Deceleration of date attribute

	/**
	 * @return the bookCode
	 */
	public int getBookCode() {
		return bookCode;
	}

	/**
	 * @param bookCode the bookCode to set
	 */
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
