package org.springpractice.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springpractice.domain.JsonResponse;
import org.springpractice.domain.LocationDetail;
import org.springpractice.domain.LocationEntity;
import org.springpractice.exception.LocationException;
import org.springpractice.service.LocationService;

@Controller
public class LocationController {
	
	private static Logger LOG = Logger.getLogger(LocationController.class);
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value="/getlocations", method= RequestMethod.GET)
	@ResponseBody
	public JsonResponse getLocations(){
		LOG.info("Inside get location detail controller mapping...");
		try{
			ArrayList<LocationDetail> locationDetailList = locationService.getLocations();
			return getJsonResponse(locationDetailList);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in getLocationDetail...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
		catch(Exception exception){
			LOG.error("Error occurred in getLocationDetail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	@RequestMapping(value="/savelocation", method= RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveLocation(@RequestBody LocationDetail locationDetail){
		LOG.info("Inside save loacation controller mapping...");
		try{
			LocationEntity locationEntity = locationService.saveLocation(locationDetail);
			locationDetail = locationService.getLocationDetail(locationEntity.getLocId());
			return getJsonResponse(locationDetail);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in saveLocation...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
		catch(Exception exception){
			LOG.error("Error occurred in saveLocation...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}
	
	@RequestMapping(value="/updatelocation", method= RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateLocation(@RequestBody LocationDetail locationDetail){
		LOG.info("Inside update location controller mapping...");
		try{
			LocationEntity locationEntity = locationService.saveLocation(locationDetail);
			locationDetail = locationService.getLocationDetail(locationEntity.getLocId());
			return getJsonResponse(locationDetail);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in updateLocation...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
		catch(Exception exception){
			LOG.error("Error occurred in updateLocation...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}
	
	@RequestMapping(value="/deletelocation/{locationId}", method= RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteLocation(@PathVariable(value="locationId") Long locationId){
		LOG.info("Inside delete location controller mapping...");
		try{
			locationService.deleteLocation(locationId);
			return new JsonResponse();
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in deleteLocation...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
		catch(Exception exception){
			LOG.error("Error occurred in deleteLocation...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}
	
	@RequestMapping(value="/getlocationdetail", method= RequestMethod.POST)
	@ResponseBody
	public JsonResponse getLocationDetail(@RequestParam(value="locationId") Long locationId){
		LOG.info("Inside get location detail controller mapping...");
		try{
			LocationDetail locationDetail = locationService.getLocationDetail(locationId);
			return getJsonResponse(locationDetail);
		}
		catch(LocationException locationException){
			LOG.error("Error occurred in getLocationDetail...", locationException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
		catch(Exception exception){
			LOG.error("Error occurred in getLocationDetail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}
	
	private JsonResponse getJsonResponse(LocationDetail locationDetail) throws Exception{
		JsonResponse response = new JsonResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setJsonData(objectMapper.writeValueAsString(locationDetail));
		return response;
	}
	
	private JsonResponse getJsonResponse(ArrayList<LocationDetail> locationDetailList) throws Exception{
		JsonResponse response = new JsonResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setJsonData(objectMapper.writeValueAsString(locationDetailList));
		return response;
	}
	
}
