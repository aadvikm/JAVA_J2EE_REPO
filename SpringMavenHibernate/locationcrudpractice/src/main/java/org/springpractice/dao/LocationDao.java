package org.springpractice.dao;

import java.util.List;

import org.springpractice.domain.Country;
import org.springpractice.domain.LocationDetail;
import org.springpractice.domain.LocationEntity;
import org.springpractice.exception.LocationException;

public interface LocationDao {

	/**
	 * Method that returns Location Entity.
	 *  
	 * @param locationId
	 * @return
	 * @throws Exception
	 */
	public LocationEntity getLocationEntity(Long locationId) throws Exception;
	
	/**
	 * Method to save a new location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationEntity saveLocationEntity(LocationEntity locationEntity) throws Exception;
	
	/**
	 * Method to update an existing location entity.
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public LocationEntity updateLocationEntity(LocationEntity locationEntity) throws Exception;
	
	/**
	 * Method to delete an existing location entity. 
	 * 
	 * @param locationEntity
	 * @return
	 * @throws LocationException
	 */
	public void deleteLocationEntity(LocationEntity locationEntity) throws Exception;
	
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
	public List<Country> getCountryList() throws Exception;
	
	public List<LocationDetail> getLocations() throws Exception;
	
}
