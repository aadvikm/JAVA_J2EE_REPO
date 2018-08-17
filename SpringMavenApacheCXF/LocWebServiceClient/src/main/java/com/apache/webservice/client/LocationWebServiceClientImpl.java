package com.apache.webservice.client;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.webservice.tutorial.webservice.Country;
import com.apache.webservice.tutorial.webservice.LocationDetail;
import com.apache.webservice.tutorial.webservice.LocationWebService;

@Service
public class LocationWebServiceClientImpl implements LocationWebServiceClient{

	@Autowired
	private LocationWebService locationWebService;

	public LocationDetail saveLocation(LocationDetail locationDetail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public LocationDetail updateLocation(LocationDetail locationDetail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteLocation(Long locationId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public LocationDetail getLocationDetail(Long locationId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Country> getCountryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LocationDetail> getLocations() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
