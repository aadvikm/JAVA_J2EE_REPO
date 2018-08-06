
public class LocationEntity {
	

	private Integer locId;
	private String streetAdd;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
	
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
