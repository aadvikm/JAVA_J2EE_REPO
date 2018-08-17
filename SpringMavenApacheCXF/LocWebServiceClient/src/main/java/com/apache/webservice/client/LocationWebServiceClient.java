package com.apache.webservice.client;

import java.util.ArrayList;

import com.apache.webservice.tutorial.webservice.Country;
import com.apache.webservice.tutorial.webservice.LocationDetail;


public interface LocationWebServiceClient {
	
	/**
	 * Method to save a new location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationDetail saveLocation(LocationDetail locationDetail) throws Exception;
	
	/**
	 * Method to update an existing location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationDetail updateLocation(LocationDetail locationDetail) throws Exception;
	
	/**
	 * Method to delete an existing location entity. 
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public void deleteLocation(Long locationId) throws Exception;
	
	/**
	 * Method that returns location detail. 
	 * 
	 * @param locationId
	 * @return
	 * @throws LocationException
	 */
	public LocationDetail getLocationDetail(Long locationId) throws Exception;
	
	/**
	 * Returns list of countries from COUNTRY table. 
	 * 
	 * @return
	 * @throws LocationException
	 */
	public ArrayList<Country> getCountryList() throws Exception;
	
	/**
	 * Returns list of locations from LOCATION table. 
	 * 
	 * @return
	 * @throws LocationException
	 */
	public ArrayList<LocationDetail> getLocations() throws Exception;

}
