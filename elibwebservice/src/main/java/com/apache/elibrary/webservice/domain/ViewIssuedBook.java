package com.apache.elibrary.webservice.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewIssuedBook {
	private Long studentBookId;
	private Long bookId;
	private String callNo;
	private Long studentId;
	private String studentUserId;
	private String studentName;
	private String mobileNo;
	private Date issueDate;
	private String returnStatus;
	
	public ViewIssuedBook() {
		super();
	}

	public ViewIssuedBook(Long studentBookId, Long bookId, String callNo, Long studentId, String studentUserId, String studentName,
			String mobileNo, Date issueDate, String returnStatus) {
		super();
		this.studentBookId=studentBookId;
		this.bookId = bookId;
		this.callNo = callNo;
		this.studentId = studentId;
		this.studentUserId = studentUserId;
		this.studentName = studentName;
		this.mobileNo = mobileNo;
		this.issueDate = issueDate;
		this.returnStatus = returnStatus;
	}
	
	public ViewIssuedBook(Long studentBookId,Long bookId, String callNo, Long studentId, String studentUserId){
		super();
		this.studentBookId=studentBookId;
		this.bookId = bookId;
		this.callNo = callNo;
		this.studentId = studentId;
		this.studentUserId = studentUserId;
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

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	
	public String getIssueDateAsString() {
		if(this.getIssueDate() !=null){
			DateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(this.getIssueDate());
			return strDate;
		}
		return null;
	}
	
	
	public Long getStudentBookId() {
		return studentBookId;
	}

	public void setStudentBookId(Long studentBookId) {
		this.studentBookId = studentBookId;
	}

	@Override
	public String toString() {
		return "ViewIssuedBook [studentBookId=" + studentBookId + ", bookId=" + bookId + ", callNo=" + callNo
				+ ", studentId=" + studentId + ", studentUserId=" + studentUserId + ", studentName=" + studentName
				+ ", mobileNo=" + mobileNo + ", issueDate=" + issueDate + ", returnStatus=" + returnStatus + "]";
	}

	
	

}
