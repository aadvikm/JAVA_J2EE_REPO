package com.apache.webservice.tutorial.webservice;

import com.apache.webservice.tutorial.exception.LocationException;

public interface LocationWebService {

	/**
	 * Method to save a new location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationOutputData saveLocation(LocationInputData locationInputData);
	
	/**
	 * Method to update an existing location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationOutputData updateLocation(LocationInputData locationInputData);
	
	/**
	 * Method to delete an existing location entity. 
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationOutputData deleteLocation(LocationInputData locationInputData);
	
	/**
	 * Method that returns location detail. 
	 * 
	 * @param locationId
	 * @return
	 * @throws LocationException
	 */
	public LocationOutputData getLocationDetail(LocationInputData locationInputData);
	
	/**
	 * Returns list of countries from COUNTRY table. 
	 * 
	 * @return
	 * @throws LocationException
	 */
	public LocationOutputData getCountryList(LocationInputData locationInputData);
	
	/**
	 * Returns list of locations from LOCATION table. 
	 * 
	 * @return
	 * @throws LocationException
	 */
	public LocationOutputData getLocations(LocationInputData locationInputData);
	
}
