package com.apache.webservice.tutorial.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.webservice.tutorial.dao.LocationDao;
import com.apache.webservice.tutorial.domain.Country;
import com.apache.webservice.tutorial.domain.LocationDetail;
import com.apache.webservice.tutorial.domain.LocationEntity;
import com.apache.webservice.tutorial.exception.LocationException;

@Service
public class LocationServiceImpl implements LocationService{

	private static Logger LOG = Logger.getLogger(LocationServiceImpl.class);
	
	@Autowired
	private LocationDao locationDao;
	
	public LocationEntity saveLocation(LocationDetail locationDetail) throws LocationException {
		try{
			LocationEntity locationEntity = convertLocationDetailToEntity(locationDetail);
			return locationDao.saveLocationEntity(locationEntity);
		}
		catch(Exception exception){
			LOG.error("Error occurred in save location...", exception);
			throw new LocationException(exception);
		}
	}

	public LocationEntity updateLocation(LocationDetail locationDetail) throws LocationException {
		try{
			//You must fetch it from DB before updating and persisting
			LocationEntity locationEntity = locationDao.getLocationEntity(locationDetail.getLocId());
			locationEntity = convertLocationDetailToEntity(locationEntity, locationDetail);
			return locationDao.updateLocationEntity(locationEntity);
		}
		catch(Exception exception){
			LOG.error("Error occurred in update location...", exception);
			throw new LocationException(exception);
		}
	}

	public void deleteLocation(Long locationId) throws LocationException {
		try{
			LocationEntity locationEntity = locationDao.getLocationEntity(locationId);
			locationDao.deleteLocationEntity(locationEntity);
		}
		catch(Exception exception){
			LOG.error("Error occurred in delete location...", exception);
			throw new LocationException(exception);
		}
	}

	public LocationDetail getLocationDetail(Long locationId) throws LocationException {
		try{
			LocationDetail locationDetail = locationDao.getLocationDetail(locationId);
			locationDetail.setCountryList(getCountryList());
			return locationDetail;
		}
		catch(Exception exception){
			LOG.error("Error occurred in get location detail...", exception);
			throw new LocationException(exception);
		}
	}

	public ArrayList<Country> getCountryList() throws LocationException {
		try{
			return (ArrayList<Country>) locationDao.getCountryList();
		}
		catch(Exception exception){
			LOG.error("Error occurred in get country list...", exception);
			throw new LocationException(exception);
		}
	}
	
	public ArrayList<LocationDetail> getLocations() throws LocationException {
		try{
			return (ArrayList<LocationDetail>) locationDao.getLocations();
		}
		catch(Exception exception){
			LOG.error("Error occurred in get location list...", exception);
			throw new LocationException(exception);
		}
	}
	
	/**
	 * Helper method to convert location detail to entity.
	 * 
	 * @param locationDetail
	 * @throws Exception
	 */
	private LocationEntity convertLocationDetailToEntity(LocationEntity locationEntity, LocationDetail locationDetail) throws Exception{
		locationEntity.setStreetAdd(locationDetail.getStreetAdd());
		locationEntity.setPostalCode(locationDetail.getPostalCode());
		locationEntity.setStateProvince(locationDetail.getStateProvince());
		locationEntity.setCity(locationDetail.getCity());
		locationEntity.setCountryId(locationDetail.getCountryId());
		return locationEntity;
	}
	
	private LocationEntity convertLocationDetailToEntity(LocationDetail locationDetail) throws Exception{
		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setLocId(locationDetail.getLocId());
		return convertLocationDetailToEntity(locationEntity, locationDetail);
	}

}
