package com.struts2practice.domain;

import java.util.ArrayList;

public class LocationDetail {
	
	private Long locId;
	private String city;
	private String streetAdd;
	private String postalCode;
	private String stateProvince;
	private ArrayList<Country> countryList;
	private String countryId;
	
	public LocationDetail() {
		super();
	}

	public LocationDetail(Long locId, String city) {
		super();
		this.locId = locId;
		this.city = city;
	}

	public LocationDetail(Long locId, String city, String streetAdd, String postalCode, String stateProvince,
			ArrayList<Country> countryList, String countryId) {
		super();
		this.locId = locId;
		this.city = city;
		this.streetAdd = streetAdd;
		this.postalCode = postalCode;
		this.stateProvince = stateProvince;
		this.countryList = countryList;
		this.countryId =countryId;
	}

	public Long getLocId() {
		return locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetAdd() {
		return streetAdd;
	}

	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public ArrayList<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<Country> countryId) {
		this.countryList = countryId;
	}
	
	

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "LocationDetail [locId=" + locId + ", city=" + city + ", streetAdd=" + streetAdd + ", postalCode="
				+ postalCode + ", stateProvince=" + stateProvince + ", countryList=" + countryList + ", countryId="
				+ countryId + "]";
	}



	

}
