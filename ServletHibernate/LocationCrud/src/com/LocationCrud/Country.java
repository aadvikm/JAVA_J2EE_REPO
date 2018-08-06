package com.LocationCrud;

public class Country {
	private String countryId;
	
	public Country() {
		super();
	}

	public Country(String countryId) {
		super();
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + "]";
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	

}
