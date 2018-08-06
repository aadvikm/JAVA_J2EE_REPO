package com.LocationCrud;

public class LocationField {
	
	private Long locId;
	private String city;
	
	public LocationField() {
		super();
	}

	public LocationField(Long locId, String city) {
		super();
		this.locId = locId;
		this.city = city;
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

	@Override
	public String toString() {
		return "LocationField [locId=" + locId + ", city=" + city + "]";
	}

}
