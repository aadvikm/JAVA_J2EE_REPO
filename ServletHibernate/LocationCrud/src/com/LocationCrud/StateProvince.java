package com.LocationCrud;

public class StateProvince {
	private String stateProvince;
	
	public StateProvince() {
		// TODO Auto-generated constructor stub
	}

	public StateProvince(String stateProvince) {
		super();
		this.stateProvince = stateProvince;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	@Override
	public String toString() {
		return "State [stateProvince=" + stateProvince + "]";
	}

}
