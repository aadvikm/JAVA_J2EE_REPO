package com.LocationCrud;

public class LocationEntity {
	private Long locId;
	private String streetAdd;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
	
	
	public LocationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LocationEntity(Long locId, String streetAdd, String postalCode, String city, String stateProvince,
			String countryId) {
		super();
		this.locId = locId;
		this.streetAdd = streetAdd;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}


	public Long getLocId() {
		return locId;
	}
	public void setLocId(Long locId) {
		this.locId = locId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "LocationEntity [locId=" + locId + ", streetAdd=" + streetAdd + ", postalCode=" + postalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}
	
	
}
