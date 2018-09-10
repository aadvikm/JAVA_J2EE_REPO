package com.struts2practice.service;

import java.util.ArrayList;

import com.struts2practice.domain.Country;
import com.struts2practice.domain.LocationDetail;
import com.struts2practice.domain.LocationEntity;
import com.struts2practice.exception.LocationException;

public interface LocationService {

	/**
	 * Method to save a new location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationEntity saveLocation(LocationDetail locationDetail) throws LocationException;
	
	/**
	 * Method to update an existing location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationEntity updateLocation(LocationDetail locationDetail) throws LocationException;
	
	/**
	 * Method to delete an existing location entity. 
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public void deleteLocation(Long locationId) throws LocationException;
	
	/**
	 * Method that returns location detail. 
	 * 
	 * @param locationId
	 * @return
	 * @throws LocationException
	 */
	public LocationDetail getLocationDetail(Long locationId) throws LocationException;
	
	/**
	 * Returns list of countries from COUNTRY table. 
	 * 
	 * @return
	 * @throws LocationException
	 */
	public ArrayList<Country> getCountryList() throws LocationException;
	
	/**
	 * Returns list of locations from LOCATION table. 
	 * 
	 * @return
	 * @throws LocationException
	 */
	public ArrayList<LocationDetail> getLocations() throws LocationException;
}
