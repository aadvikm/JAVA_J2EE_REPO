package com.apache.elibrary.webservice.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.apache.elibrary.webservice.domain.AdminEntity;
import com.apache.elibrary.webservice.domain.BookDetail;
import com.apache.elibrary.webservice.domain.BookEntity;
import com.apache.elibrary.webservice.domain.IssueBookDetail;
import com.apache.elibrary.webservice.domain.LibrarianEntity;
import com.apache.elibrary.webservice.domain.StudentBookEntity;
import com.apache.elibrary.webservice.domain.StudentDetail;
import com.apache.elibrary.webservice.domain.ViewIssuedBook;

@Repository
public class ElibraryDaoImpl implements ElibraryDao {

	private static Logger LOG = Logger.getLogger(ElibraryDaoImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**Admin Crud **/
	public AdminEntity saveAdmin(AdminEntity adminEntity) throws Exception {
		LOG.info("Inside saveAdmin method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.persist(adminEntity);
		 tx.commit();
		 session.close();
		return adminEntity;
	}

	public AdminEntity updateAdmin(AdminEntity adminEntity) throws Exception {
		LOG.info("Inside updateAdmin method..");
		
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.merge(adminEntity);
		 tx.commit();
		 session.close();
		return adminEntity;
	}

	public AdminEntity getAdmin(Long adminId) throws Exception {
		LOG.info("Inside getAdmin method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 AdminEntity adminEntity =(AdminEntity)session.get(AdminEntity.class, adminId);
		 tx.commit();
		 session.close();
		return adminEntity;
	}

	public void deleteAdmin(AdminEntity adminEntity) throws Exception {
		LOG.info("Inside deleteAdmin method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.delete(adminEntity);
		 tx.commit();
		 session.close();
	}

	/**Librarian Crud **/
	public LibrarianEntity saveLibrarian(LibrarianEntity librarianEntity) throws Exception {
		LOG.info("Inside saveLibrarian method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.persist(librarianEntity);
		 tx.commit();
		 session.close();
		return librarianEntity;
	}

	public LibrarianEntity updateLibrarian(LibrarianEntity librarianEntity) throws Exception {
		LOG.info("Inside updateLibrarian method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.merge(librarianEntity);
		 tx.commit();
		 session.close();
		return librarianEntity;
	}

	public LibrarianEntity getLibrarian(Long librarianId) throws Exception {
		LOG.info("Inside getLibrarian method..");
		Session session=sessionFactory.openSession();
		 LibrarianEntity librarianEntity =(LibrarianEntity)session.get(LibrarianEntity.class, librarianId);
		 session.close();
		return librarianEntity;
	}

	public void deleteLibrarian(LibrarianEntity librarianEntity) throws Exception {
		LOG.info("Inside deleteLibrarian method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.delete(librarianEntity);
		 tx.commit();
		 session.close();
		
	}

	public AdminEntity getAdminEntityByUserId(String userId) throws Exception {
		LOG.info("Inside getAdminEntityByUserId method..");
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("getAdminEntityByUserId");
		query.setParameter("paramAdminUserId", userId);
		AdminEntity adminEntity = (AdminEntity)query.uniqueResult();
		session.close();
		return adminEntity;
	}

	public ArrayList<LibrarianEntity> getAllLibrarianEntities() throws Exception {
		LOG.info("Inside getLibrarianDetail method..");
		Session session = sessionFactory.openSession();
		Query query =session.getNamedQuery("LibrarianEntity.getAllLibrarianEntities");
		ArrayList<LibrarianEntity> entities = (ArrayList<LibrarianEntity>) query.list();
		session.close();
		return entities;
	}

	public LibrarianEntity getLibrarianEntityByUserId(String userId) throws Exception {
		LOG.info("Inside getLibrarianEntityByUserId method..");
		Session session = sessionFactory.openSession();
		Query query =session.getNamedQuery("LibrarianEntity.getLibrarianByUserId");
		query.setParameter("paramLibrarianUserId", userId);
		LibrarianEntity librarianEntity= (LibrarianEntity) query.uniqueResult();
		session.close();
		return librarianEntity;
	}

	public BookEntity saveBook(BookEntity bookEntity) throws Exception {
		LOG.info("Inside saveBook method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.persist(bookEntity);
		 tx.commit();
		 session.close();
		return bookEntity;
	}

	public BookEntity updateBook(BookEntity bookEntity) throws Exception {
		LOG.info("Inside updateBook method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.merge(bookEntity);
		 tx.commit();
		 session.close();
		return bookEntity;
	}

	public BookEntity getBook(Long bookId) throws Exception {
		LOG.info("Inside getBook method..");
		Session session=sessionFactory.openSession();
		BookEntity bookEntity =(BookEntity)session.get(BookEntity.class, bookId);
		 session.close();
		return bookEntity;
	}

	public void deleteBook(BookEntity bookEntity) throws Exception {
		LOG.info("Inside deleteBook method..");
		Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.delete(bookEntity);
		 tx.commit();
		 session.close();
		
	}

		public ArrayList<BookDetail> getAllBooks() throws Exception {
		LOG.info("Inside getAllBooks method..");
		Session session = sessionFactory.openSession();
		Query query =session.createSQLQuery("Select B.Book_id as bookId, B.Call_No as callNo, B.Book_Name as bookName, B.Author_name as authorName,B.Publisher as publisher, B.Quantity as quantity, count(BS.Book_id) as issued, (B.Quantity-count(BS.Book_id)) as remaining from Book B, Student_Book BS where B.Book_id(+) =BS.Book_id and BS.Return_Status ='N' group by B.Book_id, B.Quantity, B.Author_name, B.Call_No, B.Book_Name,B.Publisher");
		List list =query.list();
		ArrayList<BookDetail> bookDetail =new ArrayList<BookDetail>();
		
		Iterator i =list.iterator();
		while(i.hasNext()){
			Object[] obj =(Object[])i.next();
			BookDetail book =new BookDetail();
			book.setBookId(((BigDecimal)obj[0]).longValue());
			book.setCallNo((String)obj[1]);
			book.setBookName((String)obj[2]);
			book.setAuthorName((String)obj[3]);
			book.setPublisher((String)obj[4]);
			book.setQuantity(((BigDecimal)obj[5]).longValue());
			book.setIssued(((BigDecimal)obj[6]).longValue());
			book.setRemaining(((BigDecimal)obj[7]).longValue());
			bookDetail.add(book);
		}
		 session.close();
		return bookDetail;
	}

	
		public ArrayList<StudentDetail> getAllStudents() throws Exception {
			LOG.info("Inside getAllStudents method..");
			Session session = sessionFactory.openSession();
			Query query =session.createSQLQuery("Select S.Student_id as studentId, S.Student_User_Id as studentUserId, S.Name as name, S.email_id as emailId, S.DOB as dateOfBirth, S.mobile as mobileNo, S.Password as password from  Student S");
			List list =query.list();
			ArrayList<StudentDetail> StudentDetail =new ArrayList<StudentDetail>();
			Iterator i =list.iterator();
			while(i.hasNext()){
				Object[] obj =(Object[])i.next();
				StudentDetail student =new StudentDetail();
				student.setStudentId(((BigDecimal)obj[0]).longValue());
				student.setStudentUserId((String)obj[1]);
				student.setName((String)obj[2]);
				student.setEmailId((String)obj[3]);
				Date d = (Date) obj[4];
				student.setDateOfBirth(d);
				student.setMobileNo((String)obj[5]);
				student.setPassword((String)obj[6]);
				StudentDetail.add(student);
			}
			 session.close();
			return StudentDetail;
		}
	
		public IssueBookDetail getBookAndStudentList() throws Exception {
			LOG.info("Inside getBookAndStudentList method..");
			Session session = sessionFactory.openSession();
			ArrayList<BookDetail> arrBookDetail =this.getAllBooks();
			ArrayList<StudentDetail> arrStudentDetail=this.getAllStudents();
			IssueBookDetail issueBook =new IssueBookDetail();
			issueBook.setBookDetail(arrBookDetail);
			issueBook.setStudentDetail(arrStudentDetail);
			session.close();
			return issueBook;
		}

		public int getRemaingCount(Long bookId) throws Exception{
			LOG.info("Inside saveStudentBook method..");
			Session session=sessionFactory.openSession();
			 Query query =session.createSQLQuery("Select (B.Quantity -count(SB.Book_Id))as remaining from Book B, Student_Book SB where B.Book_Id =SB.Book_Id and SB.Return_Status ='N' and B.Book_Id =:bookId group by B.Book_Id, B.Quantity");
			 query.setParameter("bookId", bookId);
			 Integer remaining =((BigDecimal)query.uniqueResult()).intValue();
			 session.close();
			 return remaining;
		}
		
		public StudentBookEntity saveStudentBook(StudentBookEntity studentBookEntity) throws Exception {

		LOG.info("Inside saveStudentBook method..");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(studentBookEntity);
		tx.commit();
		session.close();
		return studentBookEntity;
			
			
		}

		public StudentBookEntity updateStudentBook(StudentBookEntity studentBookEntity) throws Exception {
			LOG.info("Inside updateStudentBook method..");
			Session session=sessionFactory.openSession();
			 Transaction tx=session.beginTransaction();
			 session.merge(studentBookEntity);
			 tx.commit();
			 session.close();
			return studentBookEntity;
		}

		public StudentBookEntity getStudentBook(Long studentBookId) throws Exception {
			LOG.info("Inside getStudentBook method..");
			Session session=sessionFactory.openSession();
			StudentBookEntity studentBookEntity =(StudentBookEntity)session.get(StudentBookEntity.class, studentBookId);
			 session.close();
			return studentBookEntity;
		}

		public void deleteStudentBook(StudentBookEntity studentBookEntity) throws Exception {
			LOG.info("Inside deleteStudentBook method..");
			Session session=sessionFactory.openSession();
			 Transaction tx=session.beginTransaction();
			 session.delete(studentBookEntity);
			 tx.commit();
			 session.close();
			
		}

		public ArrayList<ViewIssuedBook> getAllIssuedBooks() throws Exception {
			LOG.info("Inside getAllStudents method..");
			Session session = sessionFactory.openSession();
			Query query =session.createSQLQuery("Select SB.Student_Book_Id as studentBookId, SB.Book_Id as bookId, B.Call_No as callNo, S.Student_User_Id as studentUserId, SB.Student_Id as StudentId, S.Name as studentName, S.Mobile as mobileNo, SB.Issue_Date as issueDate, SB.Return_Status as returnStatus from Book B, Student S, Student_Book SB where B.Book_Id =SB.Book_Id and S.Student_Id =SB.Student_Id");
			List list =query.list();
			ArrayList<ViewIssuedBook> viewIssuedBookList =new ArrayList<ViewIssuedBook>();
			Iterator i =list.iterator();
			while(i.hasNext()){
				Object[] obj =(Object[])i.next();
				ViewIssuedBook viewIssuedBook =new ViewIssuedBook();
				viewIssuedBook.setStudentBookId(((BigDecimal)obj[0]).longValue());
				viewIssuedBook.setBookId(((BigDecimal)obj[1]).longValue());
				viewIssuedBook.setCallNo((String)obj[2]);
				viewIssuedBook.setStudentUserId((String)obj[3]);
				viewIssuedBook.setStudentId(((BigDecimal)obj[4]).longValue());
				viewIssuedBook.setStudentName((String)obj[5]);
				viewIssuedBook.setMobileNo((String)obj[6]);
				Date d = (Date) obj[7];
				viewIssuedBook.setIssueDate(d);
				viewIssuedBook.setReturnStatus(((Character)obj[8]).toString());
				viewIssuedBookList.add(viewIssuedBook);
			}
			session.close();
			return viewIssuedBookList;
		}

		public ViewIssuedBook returnBookFormDetail(Long studentBookId) throws Exception {
			LOG.info("Inside returnBookFormDetail method..");
			Session session = sessionFactory.openSession();
			Query query =session.createSQLQuery("Select SB.Student_Book_Id as studentBookId, SB.Book_Id as bookId, B.Call_No as callNo, S.Student_User_Id as studentUserId, SB.Student_Id as StudentId from Book B, Student S, Student_Book SB where B.Book_Id =SB.Book_Id and S.Student_Id =SB.Student_Id and SB.Student_Book_Id =:studentBookId");
			query.setParameter("studentBookId", studentBookId);
			List list =query.list();
			ArrayList<ViewIssuedBook> viewIssuedBookList =new ArrayList<ViewIssuedBook>();
			Iterator i =list.iterator();
			while(i.hasNext()){
				Object[] obj =(Object[])i.next();
				ViewIssuedBook  viewIssuedBook =new ViewIssuedBook();
				viewIssuedBook.setStudentBookId(((BigDecimal)obj[0]).longValue());
				viewIssuedBook.setBookId(((BigDecimal)obj[1]).longValue());
				viewIssuedBook.setCallNo((String)obj[2]);
				viewIssuedBook.setStudentUserId((String)obj[3]);
				viewIssuedBook.setStudentId(((BigDecimal)obj[4]).longValue());
				viewIssuedBookList.add(viewIssuedBook);
			}
			session.close();
			return viewIssuedBookList.get(0);
		}

		public void returningBook(Long studentBookId) throws Exception {
			LOG.info("Inside returnBookFormDetail method..");
			Session session = sessionFactory.openSession();
			StudentBookEntity studentBookEntity =this.getStudentBook(studentBookId);
			studentBookEntity.setReturnStatus("Y");
			studentBookEntity.setReturnDate(new Date());
			this.updateStudentBook(studentBookEntity);
			session.close();
		}

	

}
