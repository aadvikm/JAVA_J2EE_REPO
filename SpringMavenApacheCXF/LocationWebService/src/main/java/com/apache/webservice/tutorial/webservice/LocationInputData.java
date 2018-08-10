package com.apache.webservice.tutorial.webservice;

import com.apache.webservice.tutorial.domain.LocationDetail;

public class LocationInputData {
	
	private Long locationId;
	private LocationDetail locationDetail;
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public LocationDetail getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(LocationDetail locationDetail) {
		this.locationDetail = locationDetail;
	}

}
