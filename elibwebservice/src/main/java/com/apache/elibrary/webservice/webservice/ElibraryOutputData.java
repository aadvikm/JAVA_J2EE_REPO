package com.apache.elibrary.webservice.webservice;

import java.util.ArrayList;

import com.apache.elibrary.webservice.domain.AdminDetail;
import com.apache.elibrary.webservice.domain.BookDetail;
import com.apache.elibrary.webservice.domain.IssueBookDetail;
import com.apache.elibrary.webservice.domain.JsonResponse;
import com.apache.elibrary.webservice.domain.LibrarianDetail;
import com.apache.elibrary.webservice.domain.StudentBookDetail;
import com.apache.elibrary.webservice.domain.StudentDetail;
import com.apache.elibrary.webservice.domain.UserProfile;
import com.apache.elibrary.webservice.domain.ViewIssuedBook;

public class ElibraryOutputData {
	private String errorMessage;
	private UserProfile userProfile;
	private JsonResponse jsonResponse;
	private ArrayList<ViewIssuedBook> viewIssuedBookList;
	private  ArrayList<BookDetail> bookDetailList;
	private  ArrayList<LibrarianDetail> libDetail;
	private AdminDetail adminDetail;
	private LibrarianDetail librarianDetail;
	private BookDetail bookDetail;
	private StudentBookDetail studentBookDetail;
	private StudentDetail studentDetail;
	private IssueBookDetail issueBookDetail;
	
	
	
	public ElibraryOutputData() {
		// TODO Auto-generated constructor stub
	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



	public UserProfile getUserProfile() {
		return userProfile;
	}



	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}



	public JsonResponse getJsonResponse() {
		return jsonResponse;
	}



	public void setJsonResponse(JsonResponse jsonResponse) {
		this.jsonResponse = jsonResponse;
	}



	public ArrayList<ViewIssuedBook> getViewIssuedBookList() {
		return viewIssuedBookList;
	}



	public void setViewIssuedBookList(ArrayList<ViewIssuedBook> viewIssuedBookList) {
		this.viewIssuedBookList = viewIssuedBookList;
	}



	public ArrayList<BookDetail> getBookDetailList() {
		return bookDetailList;
	}



	public void setBookDetailList(ArrayList<BookDetail> bookDetailList) {
		this.bookDetailList = bookDetailList;
	}



	public ArrayList<LibrarianDetail> getLibDetail() {
		return libDetail;
	}



	public void setLibDetail(ArrayList<LibrarianDetail> libDetail) {
		this.libDetail = libDetail;
	}



	public AdminDetail getAdminDetail() {
		return adminDetail;
	}



	public void setAdminDetail(AdminDetail adminDetail) {
		this.adminDetail = adminDetail;
	}



	public LibrarianDetail getLibrarianDetail() {
		return librarianDetail;
	}



	public void setLibrarianDetail(LibrarianDetail librarianDetail) {
		this.librarianDetail = librarianDetail;
	}



	public BookDetail getBookDetail() {
		return bookDetail;
	}



	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
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



	public IssueBookDetail getIssueBookDetail() {
		return issueBookDetail;
	}



	public void setIssueBookDetail(IssueBookDetail issueBookDetail) {
		this.issueBookDetail = issueBookDetail;
	}


}