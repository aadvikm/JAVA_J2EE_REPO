package com.hibernatepractice;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*2) Create a Country Entity using hibernate annotation.
 *  Please perform Save, Update, Fetch and Delete Operation. Use sequence genearator to autogenerate id. 
 *
 *5) Establish necessary relationship in Country with Location.
 * When fetching a country entity, it should give the list of location details too.*/

@Entity
@Table(name="COUNTRIES")
public class CountryEntity implements Serializable {
	 	@Id
	 	@Column(name="COUNTRY_ID")
		private String countryId;
	 	
	 	@Column(name="COUNTRY_NAME")
		private String countryName;
	 	
	 	@Column(name="REGION_ID")
		private Integer regionId;
		
	 	@OneToMany(fetch =FetchType.LAZY, mappedBy="countryId")
	 	private Set<LocationEntity> location;
		
		public CountryEntity() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getCountryId() {
			return countryId;
		}


		public void setCountryId(String countryId) {
			this.countryId = countryId;
		}


		public String getCountryName() {
			return countryName;
		}


		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}


		public Integer getRegionId() {
			return regionId;
		}


		public void setRegionId(Integer regionId) {
			this.regionId = regionId;
		}

		
		

		public Set<LocationEntity> getLocation() {
			return location;
		}


		public void setLocation(Set<LocationEntity> location) {
			this.location = location;
		}


		@Override
		public String toString() {
			return "CountryEntity [countryId=" + countryId + ", countryName=" + countryName + ", regionId=" + regionId
					+ ", location=" + location + "]";
		}


		
		
		
		
		
	

}
