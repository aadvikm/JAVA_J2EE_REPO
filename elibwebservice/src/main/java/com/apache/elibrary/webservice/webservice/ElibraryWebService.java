package com.apache.elibrary.webservice.webservice;

import java.util.ArrayList;

import javax.jws.WebService;

import com.apache.elibrary.webservice.domain.AdminDetail;
import com.apache.elibrary.webservice.domain.AdminEntity;
import com.apache.elibrary.webservice.domain.BookDetail;
import com.apache.elibrary.webservice.domain.IssueBookDetail;
import com.apache.elibrary.webservice.domain.LibrarianDetail;
import com.apache.elibrary.webservice.domain.ViewIssuedBook;
import com.apache.elibrary.webservice.exception.ElibraryException;


public interface ElibraryWebService {
/**Admin Crud**/
	
	public ElibraryOutputData saveAdmin(ElibraryInputData elibraryInputData);
	public ElibraryOutputData updateAdmin(ElibraryInputData elibraryInputData);
	public ElibraryOutputData getAdmin(Long adminId);
	public void deleteAdmin(Long adminId);
	
	
	/** Librarian Crud**/
	
	public ElibraryOutputData saveLibrarian(ElibraryInputData elibraryInputData);
	public ElibraryOutputData updateLibrarian(ElibraryInputData elibraryInputData);
	public ElibraryOutputData getLibrarian(Long librarianId);
	public void deleteLibrarian(Long librarianId);
	
	
	public boolean authenticateAdmin(String adminUserId, String password);
	
	public ArrayList<LibrarianDetail> getLibrarians();
	
	public boolean authenticateLibrarian(String librarianUserId, String password);
	
	/*Book Crud*/
	
	public ElibraryOutputData saveBook(ElibraryInputData elibraryInputData);
	public ElibraryOutputData updateBook(ElibraryInputData elibraryInputData);
	public ElibraryOutputData getBook(Long bookId);
	public void deleteBook(Long bookId);
	
	public ElibraryOutputData getAllBooks();
	
	public ElibraryOutputData getBookAndStudentList();
	
	public void saveStudentBookDetail(Long studentId, Long bookId);
	
	public ElibraryOutputData getAllIssuedBooks();
	
	public ElibraryOutputData returnBookFormDetail(Long bookId);
	
	public void returningBook(Long studentBookId);
	
}
