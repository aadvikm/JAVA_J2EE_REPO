package com.struts2practice.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2practice.domain.JsonResponse;
import com.struts2practice.domain.LocationDetail;
import com.struts2practice.domain.LocationEntity;
import com.struts2practice.exception.LocationException;
import com.struts2practice.service.LocationService;
import com.struts2practice.service.LocationServiceImpl;

public class LocationAction extends ActionSupport{
	
	private static Logger LOG = Logger.getLogger(LocationAction.class);
	
	private LocationService locationService = new LocationServiceImpl();
	
	
	public void getLocations() throws Exception{
		LOG.info("Inside get location detail controller mapping...");
		try{
			ArrayList<LocationDetail> locationDetailList = locationService.getLocations();
			writeJsonIntoResponse(locationDetailList);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in getLocationDetail...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
		catch(Exception exception){
			LOG.error("Error occurred in getLocationDetail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
	}

	public void saveLocation(LocationDetail locationDetail) throws Exception{
		LOG.info("Inside save loacation controller mapping...");
		try{
			LocationEntity locationEntity = locationService.saveLocation(locationDetail);
			locationDetail = locationService.getLocationDetail(locationEntity.getLocId());
			writeJsonIntoResponse(locationDetail);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in saveLocation...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
		catch(Exception exception){
			LOG.error("Error occurred in saveLocation...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
	}
	
	public void updateLocation(LocationDetail locationDetail) throws Exception{
		LOG.info("Inside update location controller mapping...");
		try{
			LocationEntity locationEntity = locationService.saveLocation(locationDetail);
			locationDetail = locationService.getLocationDetail(locationEntity.getLocId());
			writeJsonIntoResponse(locationDetail);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in updateLocation...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
		catch(Exception exception){
			LOG.error("Error occurred in updateLocation...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
	}
	
	public void deleteLocation(Long locationId) throws Exception{
		LOG.info("Inside delete location controller mapping...");
		try{
			locationService.deleteLocation(locationId);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in deleteLocation...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
		catch(Exception exception){
			LOG.error("Error occurred in deleteLocation...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
	}
	
	public void getLocationDetail(Long locationId) throws Exception{
		LOG.info("Inside get location detail controller mapping...");
		try{
			LocationDetail locationDetail = locationService.getLocationDetail(locationId);
			writeJsonIntoResponse(locationDetail);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in getLocationDetail...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
		catch(Exception exception){
			LOG.error("Error occurred in getLocationDetail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			writeJsonIntoResponse(response);
		}
	}
	
	private void writeJsonIntoResponse(JsonResponse data) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
	    response.getWriter().write(objectMapper.writeValueAsString(data));
	}
	
	private void writeJsonIntoResponse(LocationDetail locationDetail) throws Exception{
		JsonResponse jsonResponse = new JsonResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		jsonResponse.setJsonData(objectMapper.writeValueAsString(locationDetail));
		writeJsonIntoResponse(jsonResponse);
	}
	
	private void writeJsonIntoResponse(ArrayList<LocationDetail> locationDetailList) throws Exception{
		JsonResponse jsonResponse = new JsonResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		jsonResponse.setJsonData(objectMapper.writeValueAsString(locationDetailList));
		writeJsonIntoResponse(jsonResponse);
	}
	
}
