package com.simplilearn.workshop.model;

import javax.persistence.Entity;

@Entity
public class DestinationCity {
	
	private int destination_id;
	private String city;
	
	public DestinationCity() {
		super();
	}

	public int getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(int destination_id) {
		this.destination_id = destination_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
}
