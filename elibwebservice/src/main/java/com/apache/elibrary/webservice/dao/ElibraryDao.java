package com.apache.elibrary.webservice.dao;

import java.util.ArrayList;

import com.apache.elibrary.webservice.domain.AdminEntity;
import com.apache.elibrary.webservice.domain.BookDetail;
import com.apache.elibrary.webservice.domain.BookEntity;
import com.apache.elibrary.webservice.domain.IssueBookDetail;
import com.apache.elibrary.webservice.domain.LibrarianEntity;
import com.apache.elibrary.webservice.domain.StudentBookEntity;
import com.apache.elibrary.webservice.domain.StudentDetail;
import com.apache.elibrary.webservice.domain.ViewIssuedBook;

public interface ElibraryDao {
	    /** Admin Dao**/
	
		public AdminEntity saveAdmin(AdminEntity adminEntity) throws Exception;
		public AdminEntity updateAdmin(AdminEntity adminEntity) throws Exception;
		public AdminEntity getAdmin(Long adminId) throws Exception;
		public void deleteAdmin(AdminEntity adminEntity) throws Exception;
		
		/**Librarian Dao **/
		public LibrarianEntity saveLibrarian(LibrarianEntity librarianEntity) throws Exception;
		public LibrarianEntity updateLibrarian(LibrarianEntity librarianEntity) throws Exception;
		public LibrarianEntity getLibrarian(Long librarianId) throws Exception;
		public void deleteLibrarian(LibrarianEntity librarianEntity) throws Exception;
		
		public AdminEntity getAdminEntityByUserId(String userId) throws Exception;
		
		public ArrayList<LibrarianEntity> getAllLibrarianEntities() throws Exception;
		
		public LibrarianEntity getLibrarianEntityByUserId(String userId) throws Exception;
		
		
		/*Book Dao*/
		public BookEntity saveBook(BookEntity bookEntity) throws Exception;
		public BookEntity updateBook(BookEntity bookEntity) throws Exception;
		public BookEntity getBook(Long bookId) throws Exception;
		public void deleteBook(BookEntity bookEntity) throws Exception;
		
		public ArrayList<BookDetail> getAllBooks() throws Exception;
		public ArrayList<StudentDetail> getAllStudents() throws Exception;
		public IssueBookDetail getBookAndStudentList() throws Exception;
		
		/*Student Book Dao*
		 */
		public int getRemaingCount(Long bookId) throws Exception;
		public StudentBookEntity saveStudentBook(StudentBookEntity studentBookEntity) throws Exception;
		public StudentBookEntity updateStudentBook(StudentBookEntity studentBookEntity) throws Exception;
		public StudentBookEntity getStudentBook(Long studentBookId) throws Exception;
		public void deleteStudentBook(StudentBookEntity studentBookEntity) throws Exception;
		
		public ArrayList<ViewIssuedBook> getAllIssuedBooks() throws Exception;
		
		public ViewIssuedBook returnBookFormDetail(Long studentBookId) throws Exception;
		
		public void returningBook(Long studentBookId) throws Exception;
}
