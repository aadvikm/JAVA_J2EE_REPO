package com.elibrary.test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.elibrary.domain.LibrarianDetail;
import com.elibrary.domain.LibrarianEntity;
import com.elibrary.service.ElibraryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/dispatcher-servlet-test.xml" })
public class ElibraryServiceTest {

	@Autowired
	private ElibraryService elibraryService;
	
	@Test
	public void getLibrariansTest(){
		try{
			ArrayList<LibrarianDetail> librarians = elibraryService.getLibrarians();
			Assert.notEmpty(librarians);
		}
		catch(Exception exception){
			exception.printStackTrace();
			Assert.isNull(exception);
		}
		
	}
	
	@Test
	public void updateLibrarianTest(){
		try{
			LibrarianDetail librarianDetail = new LibrarianDetail();
			librarianDetail.setLibrarianId(1002L);
			librarianDetail.setLibrarianUserId("aadvik");
			librarianDetail.setEmailId("brindhu@gamil.com");
			librarianDetail.setMobileNo("mobileNo");
			librarianDetail.setName("Brindhu");
			librarianDetail.setPassword("myPassword");
			LibrarianDetail libDetail = elibraryService.updateLibrarian(librarianDetail);
			Assert.notNull(libDetail);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

}
