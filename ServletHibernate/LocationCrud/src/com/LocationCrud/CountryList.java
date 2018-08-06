package com.LocationCrud;

import java.util.ArrayList;

public class CountryList {
	private ArrayList<Country> countryList;
	
	
	public CountryList() {
		// TODO Auto-generated constructor stub
	}


	public CountryList(ArrayList<Country> countryList) {
		super();
		this.countryList = countryList;
	}


	public ArrayList<Country> getCountryList() {
		return countryList;
	}


	public void setCountryList(ArrayList<Country> countryList) {
		this.countryList = countryList;
	}


	@Override
	public String toString() {
		return "CountryList [countryList=" + countryList + "]";
	}

}
