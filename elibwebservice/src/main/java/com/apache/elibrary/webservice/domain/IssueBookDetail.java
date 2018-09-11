package com.apache.elibrary.webservice.domain;

import java.util.ArrayList;

public class IssueBookDetail {
	
	private ArrayList<BookDetail> bookDetail;
	private ArrayList<StudentDetail> studentDetail;
	private String studentName;
	private String mobileNo;
	
	public IssueBookDetail() {
		super();
	}

	public IssueBookDetail(ArrayList<BookDetail> bookDetail, ArrayList<StudentDetail> studentDetail, String studentName,
			String mobileNo) {
		super();
		this.bookDetail = bookDetail;
		this.studentDetail = studentDetail;
		this.studentName = studentName;
		this.mobileNo = mobileNo;
	}

	public ArrayList<BookDetail> getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(ArrayList<BookDetail> bookDetail) {
		this.bookDetail = bookDetail;
	}

	public ArrayList<StudentDetail> getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(ArrayList<StudentDetail> studentDetail) {
		this.studentDetail = studentDetail;
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

	@Override
	public String toString() {
		return "IssueBookDetail [bookDetail=" + bookDetail + ", studentDetail=" + studentDetail + ", studentName="
				+ studentName + ", mobileNo=" + mobileNo + "]";
	}

}
