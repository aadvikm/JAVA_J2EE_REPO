package com.apache.elibrary.webservice.domain;

import java.util.Date;

public class StudentBookDetail {
	private Long bookId;
	private Long studentId;
	private Long studentBookId;
	private Date issueDate;
	private Date returnDate;
	private String returnStatus;
	
	public StudentBookDetail() {
		super();
	}

	public StudentBookDetail(Long bookId, Long studentId, Long studentBookId, Date issueDate, Date returnDate,
			String returnStatus) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
		this.studentBookId = studentBookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.returnStatus = returnStatus;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getStudentBookId() {
		return studentBookId;
	}

	public void setStudentBookId(Long studentBookId) {
		this.studentBookId = studentBookId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	@Override
	public String toString() {
		return "StudentBookDetail [bookId=" + bookId + ", studentId=" + studentId + ", studentBookId=" + studentBookId
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", returnStatus=" + returnStatus + "]";
	}
	
	

}
