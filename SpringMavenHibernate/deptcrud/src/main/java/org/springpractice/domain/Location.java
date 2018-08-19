package org.springpractice.domain;

public class Location {
	private Long locId;

	private String city;

	public Location() {
	}

	public Location(Long locId, String city) {
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

	public String toString() {
		return "Location [locId=" + locId + ", city=" + city + "]";
	}
}
