package com.apache.elibrary.webservice.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class BookEntity {
	@Id
	@Column(name = "BOOK_ID")
	@SequenceGenerator(name = "bookSeqGen", sequenceName = "BOOK_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "bookSeqGen", strategy = GenerationType.SEQUENCE)
	private Long bookId;
	
	@Column(name="CALL_NO")
	private String callNo;
	
	@Column(name="BOOK_NAME")
	private String bookName;
	
	@Column(name="AUTHOR_NAME")
	private String authorName;
	
	@Column(name="PUBLISHER")
	private String publisher;
	
	@Column(name="QUANTITY")
	private Long quantity;
	
	public BookEntity() {
		// TODO Auto-generated constructor stub
	}

	public BookEntity(Long bookId, String callNo, String bookName, String authorName, String publisher, Long quantity) {
		super();
		this.bookId = bookId;
		this.callNo = callNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", callNo=" + callNo + ", bookName=" + bookName + ", authorName="
				+ authorName + ", publisher=" + publisher + ", quantity=" + quantity + "]";
	}
	
	
	

}
