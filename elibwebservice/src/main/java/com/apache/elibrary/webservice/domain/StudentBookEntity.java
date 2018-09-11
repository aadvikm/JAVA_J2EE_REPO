package com.apache.elibrary.webservice.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="STUDENT_BOOK")
public class StudentBookEntity {
	@Id
	@Column(name = "STUDENT_BOOK_ID")
	@SequenceGenerator(name = "studentBookSeqGen", sequenceName = "STUDENT_BOOK_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "studentBookSeqGen", strategy = GenerationType.SEQUENCE)
	private Long studentBookId;
	
	@Column(name="STUDENT_ID")
	private Long studentId;
	
	@Column(name="BOOK_ID")
	private Long bookId;
	
	@Column(name="ISSUE_DATE")
	private Date issueDate;
	
	@Column(name="RETURN_DATE")
	private Date returnDate;
	
	@Column(name="RETURN_STATUS")
	private String returnStatus;
	
	
	public StudentBookEntity() {
		// TODO Auto-generated constructor stub
	}


	public StudentBookEntity(Long studentBookId, Long studentId, Long bookId, Date issueDate, Date returnDate,
			String returnStatus) {
		super();
		this.studentBookId = studentBookId;
		this.studentId = studentId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.returnStatus = returnStatus;
	}


	public Long getStudentBookId() {
		return studentBookId;
	}


	public void setStudentBookId(Long studentBookId) {
		this.studentBookId = studentBookId;
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
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
		return "StudentBookEntity [studentBookId=" + studentBookId + ", studentId=" + studentId + ", bookId=" + bookId
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", returnStatus=" + returnStatus + "]";
	}

}
