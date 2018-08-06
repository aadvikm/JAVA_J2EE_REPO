package com.hibernate.exercise;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*1) Create an Location Entity using hibernate annotation.
 *  Please perform Save, Update, Fetch and Delete Operation. Use sequence genearator to autogenerate id. 
 *  
 *4) Establish necessary relationship in Location with Country. 
 *  When fetching a location entity, it should give the country detail too.
 *
 *6) Please demo eager and lazy fetch using above relationships.*/

@Entity
@Table(name ="LOCATIONS")
public class LocationEntity implements Serializable{
	
	@Id
	@Column(name ="LOCATION_ID")
	@SequenceGenerator(name="locationSeq", sequenceName="LOCATIONS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "locationSeq")
	private Integer locId;
	
	@Column(name ="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	@Column(name="COUNTRY_ID")
	private String countryId;
	
	//@ManyToOne
	//@JoinColumn(name="COUNTRY_ID", nullable=true)
	//private CountryEntity countryId;
	
	public LocationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getLocId() {
		return locId;
	}


	public void setLocId(Integer locId) {
		this.locId = locId;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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



	/*public CountryEntity getCountryId() {
		return countryId;
	}


	public void setCountryId(CountryEntity countryId) {
		this.countryId = countryId;
	}*/
	
	
	@Override
	public String toString() {
		return "LocationEntity [locId=" + locId + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode
				+ ", city=" + city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}


}
