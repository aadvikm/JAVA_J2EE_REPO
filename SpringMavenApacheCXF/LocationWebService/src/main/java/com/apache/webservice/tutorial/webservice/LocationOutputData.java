package com.apache.webservice.tutorial.webservice;

import java.util.ArrayList;

import com.apache.webservice.tutorial.domain.Country;
import com.apache.webservice.tutorial.domain.LocationDetail;

public class LocationOutputData {
	
	private String errorMessage;
	private LocationDetail locationDetail;
	private ArrayList<Country> countryList;
	private ArrayList<LocationDetail> locationDetailList;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocationDetail getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(LocationDetail locationDetail) {
		this.locationDetail = locationDetail;
	}
	public ArrayList<Country> getCountryList() {
		return countryList;
	}
	public void setCountryList(ArrayList<Country> countryList) {
		this.countryList = countryList;
	}
	public ArrayList<LocationDetail> getLocationDetailList() {
		return locationDetailList;
	}
	public void setLocationDetailList(ArrayList<LocationDetail> locationDetailList) {
		this.locationDetailList = locationDetailList;
	}

}
