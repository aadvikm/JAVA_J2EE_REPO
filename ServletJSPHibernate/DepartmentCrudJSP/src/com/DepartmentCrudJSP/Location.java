package com.DepartmentCrudJSP;

public class Location {
	
	private Long locationId;
	private String streetAddress;

	public Location() {
		super();
	}

	public Location(Long locationId, String streetAddress) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", streetAddress=" + streetAddress + "]";
	}
	
	

}
