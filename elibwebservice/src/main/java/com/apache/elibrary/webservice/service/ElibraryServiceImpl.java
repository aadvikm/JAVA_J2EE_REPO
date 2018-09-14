package com.apache.elibrary.webservice.service;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.elibrary.webservice.dao.ElibraryDao;
import com.apache.elibrary.webservice.domain.AdminDetail;
import com.apache.elibrary.webservice.domain.AdminEntity;
import com.apache.elibrary.webservice.domain.BookDetail;
import com.apache.elibrary.webservice.domain.BookEntity;
import com.apache.elibrary.webservice.domain.IssueBookDetail;
import com.apache.elibrary.webservice.domain.LibrarianDetail;
import com.apache.elibrary.webservice.domain.LibrarianEntity;
import com.apache.elibrary.webservice.domain.StudentBookDetail;
import com.apache.elibrary.webservice.domain.StudentBookEntity;
import com.apache.elibrary.webservice.domain.ViewIssuedBook;
import com.apache.elibrary.webservice.exception.ElibraryException;

@WebService(endpointInterface = "com.apache.elibrary.webservice.service.ElibraryService", serviceName = "elibraryServiceImpl")
public  class ElibraryServiceImpl implements ElibraryService {

	private static Logger LOG = Logger.getLogger(ElibraryServiceImpl.class);
	
	
	private ElibraryDao elibraryDao;
	
	
	
	public ElibraryDao getElibraryDao() {
		return elibraryDao;
	}

	public void setElibraryDao(ElibraryDao elibraryDao) {
		this.elibraryDao = elibraryDao;
	}

	/**Admin Crud**/
	
	public AdminEntity saveAdmin(AdminDetail adminDetail) throws ElibraryException{
		LOG.info("Inside  ElibraryService SaveAdmin Method..");
		try{
			AdminEntity adminEntity =new AdminEntity();
			BeanUtils.copyProperties(adminDetail, adminEntity);
			elibraryDao.saveAdmin(adminEntity);
			return adminEntity;
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService saveAdmin..", ex);
			throw new ElibraryException(ex);
		}
		
	}

	public AdminEntity updateAdmin(AdminDetail adminDetail) throws ElibraryException {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminDetail getAdmin(Long adminId) throws ElibraryException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAdmin(Long adminId) throws ElibraryException{
		// TODO Auto-generated method stub
		
	}

	public LibrarianDetail saveLibrarian(LibrarianDetail librarianDetail) throws ElibraryException{
		LOG.info("Inside ElibraryService  SaveLibrarian  Method..");
		try{
			LibrarianEntity librarianEntity =new LibrarianEntity();
			librarianEntity.setLibrarianUserId(librarianDetail.getLibrarianUserId());
			librarianEntity.setName(librarianDetail.getName());
			librarianEntity.setEmailId(librarianDetail.getEmailId());
			librarianEntity.setPassword(librarianDetail.getPassword());
			librarianEntity.setMobileNo(librarianDetail.getMobileNo());
			elibraryDao.saveLibrarian(librarianEntity);
			LibrarianDetail librarianDetail1 =this.getLibrarian(librarianDetail.getLibrarianId());
			return librarianDetail1;
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService saveLibrarian..", ex);
			throw new ElibraryException(ex);
		}
		
	}

	public LibrarianDetail updateLibrarian(LibrarianDetail librarianDetail) throws ElibraryException{
		LOG.info("Inside ElibraryService  updateLibrarian  Method..");
		try{
			LibrarianEntity librarianEntity =elibraryDao.getLibrarian(librarianDetail.getLibrarianId());
			librarianEntity.setLibrarianUserId(librarianDetail.getLibrarianUserId());
			librarianEntity.setName(librarianDetail.getName());
			librarianEntity.setPassword(librarianDetail.getPassword());
			librarianEntity.setMobileNo(librarianDetail.getMobileNo());
			librarianEntity.setEmailId(librarianDetail.getEmailId());
			elibraryDao.updateLibrarian(librarianEntity);
			LibrarianDetail librarianDetail1 =this.getLibrarian(librarianDetail.getLibrarianId());
			return librarianDetail1;
			
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService updateLibrarian..", ex);
			throw new ElibraryException(ex);
		}
	
	}

	public LibrarianDetail getLibrarian(Long librarianId)throws ElibraryException {
		LOG.info("Inside ElibraryService  getLibrarian  Method..");
		try{
			LibrarianDetail librarianDetail =new LibrarianDetail();
			LibrarianEntity librarianEntity = elibraryDao.getLibrarian(librarianId);
			BeanUtils.copyProperties(librarianEntity, librarianDetail);
			return librarianDetail;
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService getLibrarian..", ex);
			throw new ElibraryException(ex);
		}
		
	}

	public void deleteLibrarian(Long librarianId)throws ElibraryException {
		LOG.info("Inside  ElibraryService deleteLibrarian method..");
		try{
			LibrarianEntity librarianEntity =elibraryDao.getLibrarian(librarianId);
			elibraryDao.deleteLibrarian(librarianEntity);
			
		}catch(Exception ex){
			LOG.error("Exception Occurred in ElibraryService DeleteLibrarian", ex);
			throw new ElibraryException(ex);
		}
	}

	public boolean authenticateAdmin(String adminUserId, String password) throws ElibraryException {
		LOG.info("Inside  ElibraryService authendicateAdmin method..");
		try{
			AdminEntity adminEntity =elibraryDao.getAdminEntityByUserId(adminUserId);
			if(adminEntity.getPassword().equals(password)){
				return true;
			}
			
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
		return false;
	}

	public ArrayList<LibrarianDetail> getLibrarians() throws ElibraryException {
		LOG.info("Inside getLibrarians....");
		try{
			 ArrayList<LibrarianEntity> librarianEnitites =elibraryDao.getAllLibrarianEntities();
			 ArrayList<LibrarianDetail> librarianDetailList = new ArrayList<LibrarianDetail>();
			 for(LibrarianEntity entity : librarianEnitites){
				 librarianDetailList.add(new LibrarianDetail(entity));
			 }
			 return librarianDetailList;
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
	}

	public boolean authenticateLibrarian(String librarianUserId, String password) throws ElibraryException {
		LOG.info("Inside  ElibraryService authenticateLibrarian method..");
		try{
			LibrarianEntity librarianEntity =elibraryDao.getLibrarianEntityByUserId(librarianUserId);
			if(librarianEntity.getPassword().equals(password)){
				return true;
			}
			
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
		return false;
	}

	public BookDetail saveBook(BookDetail bookDetail) throws ElibraryException {
		LOG.info("Inside ElibraryService  saveBook  Method..");
		try{
			BookEntity bookEntity =new BookEntity();
			bookEntity.setCallNo(bookDetail.getCallNo());
			bookEntity.setBookName(bookDetail.getBookName());
			bookEntity.setAuthorName(bookDetail.getAuthorName());
			bookEntity.setPublisher(bookDetail.getPublisher());
			bookEntity.setQuantity(bookDetail.getQuantity());
			 elibraryDao.saveBook(bookEntity);
			 BookDetail bookDetail1 =this.getBook(bookEntity.getBookId());
			return bookDetail1;
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService saveBook..", ex);
			throw new ElibraryException(ex);
		}
	}

	public BookDetail updateBook(BookDetail bookDetail) throws ElibraryException {
		LOG.info("Inside ElibraryService  updateBook  Method..");
		try{
			BookEntity bookEntity =elibraryDao.getBook(bookDetail.getBookId());
			bookEntity.setCallNo(bookDetail.getCallNo());
			bookEntity.setBookName(bookDetail.getBookName());
			bookEntity.setAuthorName(bookDetail.getAuthorName());
			bookEntity.setPublisher(bookDetail.getPublisher());
			bookEntity.setQuantity(bookDetail.getQuantity());
			elibraryDao.updateBook(bookEntity);
			BookDetail bookDetail1 =this.getBook(bookDetail.getBookId());
			return bookDetail1;
			
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService updateBook..", ex);
			throw new ElibraryException(ex);
		}
	
	}

	public BookDetail getBook(Long bookId) throws ElibraryException {
		LOG.info("Inside ElibraryService  getBook  Method..");
		try{
			BookDetail bookDetail =new BookDetail();
			BookEntity bookEntity = elibraryDao.getBook(bookId);
			BeanUtils.copyProperties(bookEntity, bookDetail);
			return bookDetail;
		}catch(Exception ex){
			LOG.error("Exception  Occurred in  ElibraryService getBook..", ex);
			throw new ElibraryException(ex);
		}
	}

	public void deleteBook(Long bookId) throws ElibraryException {
		LOG.info("Inside  ElibraryService deleteBook method..");
		try{
			BookEntity bookEntity =elibraryDao.getBook(bookId);
			elibraryDao.deleteBook(bookEntity);
			
		}catch(Exception ex){
			LOG.error("Exception Occurred in ElibraryService DeleteBook", ex);
			throw new ElibraryException(ex);
		}
		
	}

	public ArrayList<BookDetail> getAllBooks() throws ElibraryException {
		LOG.info("Inside getBooks....");
		try{
			 ArrayList<BookDetail> bookDetailList =elibraryDao.getAllBooks();
			 return bookDetailList;
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
	}

	public IssueBookDetail getBookAndStudentList() throws ElibraryException {
		LOG.info("Inside getBookAndStudentList....");
		try{
			IssueBookDetail issueBookDetail=elibraryDao.getBookAndStudentList();
			 return issueBookDetail;
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
	}

	public void saveStudentBookDetail(Long studentId, Long bookId) throws ElibraryException {
		
		LOG.info("Inside saveIssueBook....");
		try{
			int remainingCount = elibraryDao.getRemaingCount(bookId);
			if(remainingCount>0){
				StudentBookDetail studentBookDetail =new StudentBookDetail();
				studentBookDetail.setStudentId(studentId);
				studentBookDetail.setBookId(bookId);
				Date d =new Date();
				studentBookDetail.setIssueDate(d);
				studentBookDetail.setReturnStatus("N");
				studentBookDetail.setReturnDate(null);
				StudentBookEntity studentBookEntity =new StudentBookEntity();
				BeanUtils.copyProperties(studentBookDetail, studentBookEntity);
				elibraryDao.saveStudentBook(studentBookEntity);
			}
			else{
				ElibraryException elibraryException= new ElibraryException("No remaining book available to be issued.!");
				throw elibraryException;
			}
			
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
	}

	public ArrayList<ViewIssuedBook> getAllIssuedBooks() throws ElibraryException {
		LOG.info("Inside getAllIssuedBooks....");
		try{
			 ArrayList<ViewIssuedBook> viewIssuedBookList =elibraryDao.getAllIssuedBooks();
			 return viewIssuedBookList;
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
	}

	public ViewIssuedBook returnBookFormDetail(Long studentBookId) throws ElibraryException {
		LOG.info("Inside returnBookFormDetail....");
		try{
			ViewIssuedBook viewIssuedBook =elibraryDao.returnBookFormDetail(studentBookId);
			 return viewIssuedBook;
		}catch(Exception ex){
			LOG.error("Exception Occurred", ex);
			throw new ElibraryException(ex);
		}
	}

	public void returningBook(Long studentBookId) throws ElibraryException {
		LOG.info("Inside  ElibraryService returningBook method..");
		try{
			elibraryDao.returningBook(studentBookId);
			
		}catch(Exception ex){
			LOG.error("Exception Occurred in ElibraryService returningBook", ex);
			throw new ElibraryException(ex);
		}
		
	}

	
	
}
