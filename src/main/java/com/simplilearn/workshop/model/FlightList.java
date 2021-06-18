package com.simplilearn.workshop.model;

import javax.persistence.Entity;

@Entity
public class FlightList {
	
	private int flight_id;
	private String flight_name;
	
	public FlightList() {
		super();
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}


}
	
	


