package com.elibrary.service;

import java.util.ArrayList;

import com.elibrary.domain.AdminDetail;
import com.elibrary.domain.AdminEntity;
import com.elibrary.domain.BookDetail;
import com.elibrary.domain.IssueBookDetail;
import com.elibrary.domain.LibrarianDetail;
import com.elibrary.domain.ViewIssuedBook;
import com.elibrary.exception.ElibraryException;

public interface ElibraryService {
	
	
	/**Admin Crud**/
	
	public AdminEntity saveAdmin(AdminDetail adminDetail) throws ElibraryException;
	public AdminEntity updateAdmin(AdminDetail adminDetail) throws ElibraryException;
	public AdminDetail getAdmin(Long adminId) throws ElibraryException;
	public void deleteAdmin(Long adminId) throws ElibraryException;
	
	
	/** Librarian Crud**/
	
	public LibrarianDetail saveLibrarian(LibrarianDetail librarianDetail) throws ElibraryException;
	public LibrarianDetail updateLibrarian(LibrarianDetail librarianDetail) throws ElibraryException;
	public LibrarianDetail getLibrarian(Long librarianId) throws ElibraryException;
	public void deleteLibrarian(Long librarianId) throws ElibraryException;
	
	
	public boolean authenticateAdmin(String adminUserId, String password) throws ElibraryException;
	
	public ArrayList<LibrarianDetail> getLibrarians() throws ElibraryException;
	
	public boolean authenticateLibrarian(String librarianUserId, String password) throws ElibraryException;
	
	/*Book Crud*/
	
	public BookDetail saveBook(BookDetail bookDetail) throws ElibraryException;
	public BookDetail updateBook(BookDetail bookDetail) throws ElibraryException;
	public BookDetail getBook(Long bookId) throws ElibraryException;
	public void deleteBook(Long bookId) throws ElibraryException;
	
	public ArrayList<BookDetail> getAllBooks() throws ElibraryException;
	
	public IssueBookDetail getBookAndStudentList() throws ElibraryException;
	
	public void saveStudentBookDetail(Long studentId, Long bookId) throws ElibraryException;
	
	public ArrayList<ViewIssuedBook> getAllIssuedBooks() throws ElibraryException;
	
	public ViewIssuedBook returnBookFormDetail(Long bookId) throws ElibraryException;
	
	public void returningBook(Long studentBookId) throws ElibraryException;
	
}
