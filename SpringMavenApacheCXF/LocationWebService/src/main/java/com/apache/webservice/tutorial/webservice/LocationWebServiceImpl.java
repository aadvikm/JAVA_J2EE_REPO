package com.apache.webservice.tutorial.webservice;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.apache.webservice.tutorial.domain.LocationEntity;
import com.apache.webservice.tutorial.exception.LocationException;
import com.apache.webservice.tutorial.service.LocationService;

@WebService(endpointInterface = "com.apache.webservice.tutorial.webservice.LocationWebService", serviceName = "locationWebServiceImpl")
public class LocationWebServiceImpl implements LocationWebService {
	
	private static Logger LOG = Logger.getLogger(LocationWebServiceImpl.class);
	
	@Autowired
	private LocationService locationService;
	

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public LocationOutputData saveLocation(LocationInputData locationInputData) {
		try{
			LocationOutputData outputData = new LocationOutputData();
			LocationEntity locationEntity = locationService.saveLocation(locationInputData.getLocationDetail());
			outputData.setLocationDetail(locationService.getLocationDetail(locationEntity.getLocId()));
			return outputData;
		}
		catch(LocationException locationException){
			LOG.error("Error Occured...", locationException);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(locationException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public LocationOutputData updateLocation(LocationInputData locationInputData) {
		try{
			LocationOutputData outputData = new LocationOutputData();
			LocationEntity locationEntity = locationService.updateLocation(locationInputData.getLocationDetail());
			outputData.setLocationDetail(locationService.getLocationDetail(locationEntity.getLocId()));
			return outputData;
		}
		catch(LocationException locationException){
			LOG.error("Error Occured...", locationException);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(locationException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public LocationOutputData deleteLocation(LocationInputData locationInputData) {
		try{
			LocationOutputData outputData = new LocationOutputData();
			locationService.deleteLocation(locationInputData.getLocationId());
			return outputData;
		}
		catch(LocationException locationException){
			LOG.error("Error Occured...", locationException);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(locationException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public LocationOutputData getLocationDetail(LocationInputData locationInputData) {
		try{
			LocationOutputData outputData = new LocationOutputData();
			outputData.setLocationDetail(locationService.getLocationDetail(locationInputData.getLocationId()));
			return outputData;
		}
		catch(LocationException locationException){
			LOG.error("Error Occured...", locationException);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(locationException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public LocationOutputData getCountryList(LocationInputData locationInputData) {
		try{
			LocationOutputData outputData = new LocationOutputData();
			outputData.setCountryList(locationService.getCountryList());
			return outputData;
		}
		catch(LocationException locationException){
			LOG.error("Error Occured...", locationException);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(locationException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}

	public LocationOutputData getLocations(LocationInputData locationInputData) {
		try{
			LocationOutputData outputData = new LocationOutputData();
			outputData.setLocationDetailList(locationService.getLocations());
			return outputData;
		}
		catch(LocationException locationException){
			LOG.error("Error Occured...", locationException);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(locationException.getMessage());
			return outputData;
		}
		catch(Exception exception){
			LOG.error("Error Occured...", exception);
			LocationOutputData outputData = new LocationOutputData();
			outputData.setErrorMessage(exception.getMessage());
			return outputData;
		}
	}
	
	@PostConstruct
	public void init() {
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
