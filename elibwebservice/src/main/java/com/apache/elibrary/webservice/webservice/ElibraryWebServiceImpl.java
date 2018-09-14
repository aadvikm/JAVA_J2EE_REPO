package com.apache.elibrary.webservice.webservice;

import java.util.ArrayList;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.apache.elibrary.webservice.domain.AdminEntity;
import com.apache.elibrary.webservice.domain.LibrarianDetail;
import com.apache.elibrary.webservice.exception.ElibraryException;
import com.apache.elibrary.webservice.service.ElibraryService;


public class ElibraryWebServiceImpl implements ElibraryWebService{

	public ElibraryWebServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static Logger LOG = Logger.getLogger(ElibraryWebServiceImpl.class);
	
	private ElibraryService elibraryService;

	public ElibraryService getElibraryService() {
		return elibraryService;
	}

	public void setElibraryService(ElibraryService elibraryService) {
		this.elibraryService = elibraryService;
	}

	public ElibraryOutputData saveAdmin(ElibraryInputData elibraryInputData) {
		try{
			ElibraryOutputData outputData = new ElibraryOutputData();
			AdminEntity adminEntity = elibraryService.saveAdmin(elibraryInputData.getAdminDetail());
			outputData.setAdminDetail(elibraryService.getAdmin(adminEntity.getAdminId()));
			return outputData;
		}
		catch(ElibraryException elibraryException){
			LOG.error("Error Occured...", elibraryException);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(elibraryException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public ElibraryOutputData updateAdmin(ElibraryInputData elibraryInputData) {
		try{
			ElibraryOutputData outputData = new ElibraryOutputData();
			AdminEntity adminEntity = elibraryService.updateAdmin(elibraryInputData.getAdminDetail());
			outputData.setAdminDetail(elibraryService.getAdmin(adminEntity.getAdminId()));
			return outputData;
		}
		catch(ElibraryException elibraryException){
			LOG.error("Error Occured...", elibraryException);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(elibraryException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public ElibraryOutputData getAdmin(Long adminId) {
		try{
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setAdminDetail(elibraryService.getAdmin(adminId));
			return outputData;
		}
		catch(ElibraryException elibraryException){
			LOG.error("Error Occured...", elibraryException);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(elibraryException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public void deleteAdmin(Long adminId) {
		try{
			ElibraryOutputData outputData = new ElibraryOutputData();
			elibraryService.deleteAdmin(adminId);
			
		}
		catch(ElibraryException elibraryException){
			LOG.error("Error Occured...", elibraryException);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(elibraryException.getMessage());
			
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			ElibraryOutputData outputData = new ElibraryOutputData();
			outputData.setErrorMessage(exception.getMessage());
			
		}
	}

	public ElibraryOutputData saveLibrarian(ElibraryInputData elibraryInputData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElibraryOutputData updateLibrarian(ElibraryInputData elibraryInputData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElibraryOutputData getLibrarian(Long librarianId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteLibrarian(Long librarianId) {
		// TODO Auto-generated method stub
		
	}

	public boolean authenticateAdmin(String adminUserId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<LibrarianDetail> getLibrarians() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authenticateLibrarian(String librarianUserId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public ElibraryOutputData saveBook(ElibraryInputData elibraryInputData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElibraryOutputData updateBook(ElibraryInputData elibraryInputData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElibraryOutputData getBook(Long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		
	}

	public ElibraryOutputData getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public ElibraryOutputData getBookAndStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveStudentBookDetail(Long studentId, Long bookId) {
		// TODO Auto-generated method stub
		
	}

	public ElibraryOutputData getAllIssuedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public ElibraryOutputData returnBookFormDetail(Long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void returningBook(Long studentBookId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
