package com.apache.elibrary.webservice.webservice;

import com.apache.elibrary.webservice.domain.AdminDetail;
import com.apache.elibrary.webservice.domain.BookDetail;
import com.apache.elibrary.webservice.domain.IssueBookDetail;
import com.apache.elibrary.webservice.domain.LibrarianDetail;
import com.apache.elibrary.webservice.domain.StudentBookDetail;
import com.apache.elibrary.webservice.domain.StudentDetail;
import com.apache.elibrary.webservice.domain.ViewIssuedBook;

public class ElibraryInputData {
	
	private AdminDetail adminDetail;
	private BookDetail bookDetail;
	private LibrarianDetail librarianDetail;
	private StudentBookDetail studentBookDetail;
	private StudentDetail studentDetail;
	private ViewIssuedBook viewIssuedBook;
	private IssueBookDetail issueBookDetail;
	private Long adminId;
	
	
	public ElibraryInputData() {
		super();
	}

	public AdminDetail getAdminDetail() {
		return adminDetail;
	}

	public void setAdminDetail(AdminDetail adminDetail) {
		this.adminDetail = adminDetail;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public LibrarianDetail getLibrarianDetail() {
		return librarianDetail;
	}

	public void setLibrarianDetail(LibrarianDetail librarianDetail) {
		this.librarianDetail = librarianDetail;
	}

	public StudentBookDetail getStudentBookDetail() {
		return studentBookDetail;
	}

	public void setStudentBookDetail(StudentBookDetail studentBookDetail) {
		this.studentBookDetail = studentBookDetail;
	}

	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	public ViewIssuedBook getViewIssuedBook() {
		return viewIssuedBook;
	}

	public void setViewIssuedBook(ViewIssuedBook viewIssuedBook) {
		this.viewIssuedBook = viewIssuedBook;
	}

	

	public IssueBookDetail getIssueBookDetail() {
		return issueBookDetail;
	}

	public void setIssueBookDetail(IssueBookDetail issueBookDetail) {
		this.issueBookDetail = issueBookDetail;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	

}
