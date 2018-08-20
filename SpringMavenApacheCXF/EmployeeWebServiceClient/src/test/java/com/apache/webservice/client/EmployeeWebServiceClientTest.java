package com.apache.webservice.client;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apache.webservice.tutorial.webservice.EmployeeOutputData;
import com.apache.webservice.tutorial.webservice.EmployeeWebService;
import com.apache.webservice.tutorial.webservice.Manager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/employee-service-client-context.xml" })
public class EmployeeWebServiceClientTest {
	
	@Autowired
	private EmployeeWebService employeeWebService;
	
	@Test
	public void getGetManagerList(){
		try{
			EmployeeOutputData outputData = employeeWebService.getManagerList(null);
			ArrayList<Manager> managerList = (ArrayList<Manager>) outputData.getManagerList();
			for(Manager manager : managerList){
				System.out.println(manager.getManagerId() +" --- "+ manager.getManagerName());
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

}
