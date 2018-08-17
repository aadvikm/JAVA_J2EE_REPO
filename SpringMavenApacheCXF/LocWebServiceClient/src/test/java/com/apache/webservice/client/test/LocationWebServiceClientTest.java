package com.apache.webservice.client.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apache.webservice.tutorial.webservice.LocationDetail;
import com.apache.webservice.tutorial.webservice.LocationInputData;
import com.apache.webservice.tutorial.webservice.LocationOutputData;
import com.apache.webservice.tutorial.webservice.LocationWebService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/location-service-client-context.xml" })
public class LocationWebServiceClientTest {

	@Autowired
	private LocationWebService locationWebService;
	
	/*@Test
	public void getGetCountries(){
		try{
			LocationOutputData outputData = locationWebService.getCountryList(null);
			ArrayList<Country> countryList = (ArrayList<Country>) outputData.getCountryList();
			for(Country country : countryList){
				System.out.println(country.getCountryId() +" --- "+ country.getCountryName());
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}*/
	@Test
	public void getGetLocationDetail(){
		try{
			LocationInputData inputData = new LocationInputData();
			inputData.setLocationId(1700L);
			LocationOutputData outputData =	locationWebService.getLocationDetail(inputData);
			LocationDetail locDetail =(LocationDetail)outputData.getLocationDetail();
			System.out.println("LocId :"+locDetail.getLocId());
			System.out.println("StreetAdd :"+locDetail.getStreetAdd());
			System.out.println("City :"+locDetail.getCity());
			System.out.println("Postal Code :"+locDetail.getPostalCode());
			System.out.println("State Province :"+locDetail.getStateProvince());
			System.out.println("Country Id :"+locDetail.getCountryId());
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}
