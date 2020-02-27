package com.docsconsole.tutorials.hibernate5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	public Book() {
	}

	public Book(String bookName, Double bookPrice, Author author) {

		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "BOOK_PRICE")
	private Double bookPrice;

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID", nullable = false)
	private Author author;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}