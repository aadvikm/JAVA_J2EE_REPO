package com.elibrary.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elibrary.domain.BookDetail;
import com.elibrary.domain.IssueBookDetail;
import com.elibrary.domain.JsonResponse;
import com.elibrary.domain.LibrarianDetail;
import com.elibrary.domain.UserProfile;
import com.elibrary.domain.ViewIssuedBook;
import com.elibrary.exception.ElibraryException;
import com.elibrary.service.ElibraryService;

@Controller
public class LoginController {
		private static Logger LOG =Logger.getLogger(LoginController.class);
		
		@Autowired
		private ElibraryService elibraryService;
		
		@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		public String elibrary() {
			return "elibrary";
		}
		
		@RequestMapping(value = { "/authenticateAdmin" }, method = {
				org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public UserProfile authenticateAdmin(@RequestParam("adminId") String adminUserId, @RequestParam("password") String password){
			LOG.info("Inside authendicationAdmin Method ");
			try{
				boolean flag = elibraryService.authenticateAdmin(adminUserId, password);
				if(flag){
					return new UserProfile(adminUserId, "Admin");
				}
				else
					return null;
				
			}catch(Exception ex){
				LOG.error("Exception Occurred.", ex);
				return null;
			}
			
		}
		
		@RequestMapping(value = { "/addLibrarian" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse saveLibrarian(@RequestBody LibrarianDetail librarianDetail){
			LOG.info("Inside saveLibrarian Method ");
			try{
				LibrarianDetail librarianDetail1 = elibraryService.saveLibrarian(librarianDetail);
				librarianDetail = elibraryService.getLibrarian(librarianDetail1.getLibrarianId());
				return getJsonResponse(librarianDetail);
			}catch(Exception ex){
				LOG.error("Error occurred in saveLibrarian...", ex);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		
		private JsonResponse getJsonResponse(LibrarianDetail librarianDetail) throws Exception {
			JsonResponse response = new JsonResponse();
			ObjectMapper objectMapper = new ObjectMapper();
			response.setJsonData(objectMapper.writeValueAsString(librarianDetail));
			return response;
		}
		
		@RequestMapping(value = { "/logout" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		@ResponseBody
		public String logout(HttpSession session){
			LOG.info("Invalidating session in the Logout method..");
			session.invalidate();
			return null;
		}
		
		@RequestMapping(value = { "/getAllLibrarians" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		@ResponseBody
		public JsonResponse getLibrarianDetail(){
			LOG.info("Inside getLibrarianDetail Method..");
			try{
			 ArrayList<LibrarianDetail> libDetail =elibraryService.getLibrarians();
			 JsonResponse response = new JsonResponse();
			 response.setJsonObject(libDetail);
			 return response;
			}catch(Exception ex){
				LOG.error("Error occurred in saveLibrarian...", ex);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
		}

		@RequestMapping(value = { "/editLibrarian" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse editLibrarian(@RequestParam("librarianId") Long librarianId){
			LOG.info("Inside editLibrarian Method..");
			try{
				LibrarianDetail librarianDetail =elibraryService.getLibrarian(librarianId);
				JsonResponse response = new JsonResponse();
				response.setJsonObject(librarianDetail);
				return response;
			}catch(Exception exception){
				LOG.error("Error occurred in editLibrarian...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		@RequestMapping(value = { "/updateLibrarian" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse updateLibrarian(@RequestBody LibrarianDetail librarianDetail){
			LOG.info("Inside updateLibrarian Method..");
			try{
				LibrarianDetail librarianDetail1=elibraryService.updateLibrarian(librarianDetail);
				JsonResponse response = new JsonResponse();
				response.setJsonObject(librarianDetail1);
				return response;
			}catch(Exception exception){
				LOG.error("Error occurred in updateLibrarian...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		
		@RequestMapping(value = { "/deleteLibrarian" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse deleteLibrarian(@RequestParam("librarianId") Long librarianId){
			LOG.info("Inside deleteLibrarian Method..");
			try{
				elibraryService.deleteLibrarian(librarianId);
				return new JsonResponse();
				
			}catch(Exception exception){
				LOG.error("Error occurred in deleteLibrarian...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		

		@RequestMapping(value = { "/authenticateLibrarian" }, method = {org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse authenticateLibrarian(@RequestParam("librarianId") String librarianUserId, @RequestParam("password") String password){
			LOG.info("Inside authenticateLibrarian Method ");
			try{
				boolean flag = elibraryService.authenticateLibrarian(librarianUserId, password);
				if(flag){
					UserProfile userProfile= new UserProfile(librarianUserId, "Librarian");
					JsonResponse response =new JsonResponse();
					response.setJsonObject(userProfile);
					return response;
				}
				else
					return null;
				
			}catch(Exception exception){
				LOG.error("Error occurred in deleteLibrarian...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		
		
		@RequestMapping(value = { "/addBook" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse saveBook(@RequestBody BookDetail bookDetail){
			LOG.info("Inside saveBook Method ");
			try{
				BookDetail bookDetail1 = elibraryService.saveBook(bookDetail);
				bookDetail = elibraryService.getBook(bookDetail1.getBookId());
				return getJsonResponse(bookDetail);
			}catch(Exception ex){
				LOG.error("Error occurred in saveBook.", ex);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		

		private JsonResponse getJsonResponse(BookDetail bookDetail) throws Exception {
			JsonResponse response = new JsonResponse();
			ObjectMapper objectMapper = new ObjectMapper();
			response.setJsonData(objectMapper.writeValueAsString(bookDetail));
			return response;
		}
		
		@RequestMapping(value = { "/getAllBooks" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		@ResponseBody
		public JsonResponse getAllBooks(){
			LOG.info("Inside getAllBooks Method..");
			try{
			 ArrayList<BookDetail> bookDetail =elibraryService.getAllBooks();
			 JsonResponse response = new JsonResponse();
			 response.setJsonObject(bookDetail);
			 return response;
			}catch(Exception ex){
				LOG.error("Error occurred in getAllBooks...", ex);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
		}
		
		@RequestMapping(value = { "/deleteBook" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse deleteBook(@RequestParam("bookId") Long bookId){
			LOG.info("Inside deleteBook Method..");
			try{
				elibraryService.deleteBook(bookId);
				return new JsonResponse();
				
			}catch(Exception exception){
				LOG.error("Error occurred in deleteBook...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		@RequestMapping(value = { "/getBookAndStudentList" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		@ResponseBody
		public JsonResponse getBookAndStudentList(){
			LOG.info("Inside getBookAndStudentList Method ");
			try{
				IssueBookDetail issuBookdetail =elibraryService.getBookAndStudentList();
				 JsonResponse response = new JsonResponse();
				response.setJsonObject(issuBookdetail);
				return response;
			}catch(Exception ex){
				LOG.error("Error occurred in getBookAndStudentList.", ex);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		
		

		@RequestMapping(value = { "/saveStudentBookDetail" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse saveStudentBookDetail(@RequestParam("studentId") Long studentId, @RequestParam("bookId") Long bookId){
			LOG.info("Inside saveStudentBookDetail Method..");
			try{
				elibraryService.saveStudentBookDetail(studentId,bookId);
				return new JsonResponse();
				
			}catch(ElibraryException elibraryException){
				LOG.error("Error occurred in saveStudentBookDetail...", elibraryException);
				JsonResponse response = new JsonResponse();
				String msg =elibraryException.getMessage();
				String[] s =msg.split(":");
				String originalMsg = s[1];
				response.setErrorMessage(originalMsg);
				return response;
			}
			catch(Exception exception){
				LOG.error("Error occurred in saveStudentBookDetail...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		
		@RequestMapping(value = { "/getAllIssuedBooks" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		@ResponseBody
		public JsonResponse getAllIssuedBooks(){
			LOG.info("Inside getAllIssuedBooks Method..");
			try{
			 ArrayList<ViewIssuedBook> viewIssuedBookList =elibraryService.getAllIssuedBooks();
			 JsonResponse response = new JsonResponse();
			 response.setJsonObject(viewIssuedBookList);
			 return response;
			}catch(Exception ex){
				LOG.error("Error occurred in getAllIssuedBooks...", ex);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
		}
		
		@RequestMapping(value = { "/returnBookForm" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		@ResponseBody
		public JsonResponse returnBookForm(@RequestParam("studentBookId") Long studentBookId){
			LOG.info("Inside returnBookForm Method..");
			try{
				ViewIssuedBook viewIssuedBook =elibraryService.returnBookFormDetail(studentBookId);
				JsonResponse response = new JsonResponse();
				response.setJsonObject(viewIssuedBook);
				return response;
				
			}catch(Exception exception){
				LOG.error("Error occurred in returnBookForm...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
		
		
		
		@RequestMapping(value = { "/returningBook" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
		@ResponseBody
		public JsonResponse returningBook(@RequestParam("studentBookId") Long studentBookId){
			LOG.info("Inside returningBook Method..");
			try{
				elibraryService.returningBook(studentBookId);
				return new JsonResponse();
				
			}catch(Exception exception){
				LOG.error("Error occurred in returningBook...", exception);
				JsonResponse response = new JsonResponse();
				response.setErrorMessage("Error Occurred. Please try again later.");
				return response;
			}
			
		}
}
