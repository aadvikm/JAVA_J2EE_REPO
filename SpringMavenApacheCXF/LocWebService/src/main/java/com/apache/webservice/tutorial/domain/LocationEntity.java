package com.apache.webservice.tutorial.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class LocationEntity implements Serializable{
	       
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="LOCATION_ID")
	@SequenceGenerator(name = "locationSeqGen", sequenceName = "LOCATIONS_SEQ", allocationSize=1)
	@GeneratedValue(generator = "locationSeqGen")
	private Long locId;
	@Column(name="STREET_ADDRESS")
	private String streetAdd;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	@Column(name="COUNTRY_ID")
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
	
}
