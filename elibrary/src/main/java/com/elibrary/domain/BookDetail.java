package com.elibrary.domain;

import java.math.BigDecimal;

public class BookDetail {
	private Long bookId;
	private String callNo;
	private String bookName;
	private String authorName;
	private String publisher;
	private Long quantity;
	private Long issued;
	private Long remaining;
	
	public BookDetail() {
		// TODO Auto-generated constructor stub
	}

	public BookDetail(Long bookId, String callNo, String bookName, String authorName, String publisher, Long quantity, Long issued, Long remaining ) {
		super();
		this.bookId = bookId;
		this.callNo = callNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.quantity = quantity;
		this.issued = issued;
		this.remaining = remaining;
	}
	public BookDetail( String callNo, String bookName, String authorName, String publisher, Long quantity) {
		super();
		this.callNo = callNo;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public BookDetail(Long bookId,Long quantity, Long issued, Long remaining ) {
		this.bookId=bookId;
		this.quantity=quantity;
		this.issued=issued;
		this.remaining=remaining;
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
	

	public Long getIssued() {
		return issued;
	}

	public void setIssued(Long issued) {
		this.issued = issued;
	}

	public Long getRemaining() {
		return remaining;
	}

	public void setRemaining(Long remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "BookDetail [bookId=" + bookId + ", callNo=" + callNo + ", bookName=" + bookName + ", authorName="
				+ authorName + ", publisher=" + publisher + ", quantity=" + quantity + "]";
	}

}
