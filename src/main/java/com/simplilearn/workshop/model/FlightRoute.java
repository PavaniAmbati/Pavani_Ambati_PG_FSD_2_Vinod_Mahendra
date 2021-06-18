package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class FlightRoute {
	
	
	private int route_id;
	private String flightname;
	private String sourcecity;
	private String destinationcity;
	private float price;
	
	//one to many
	@OneToMany (mappedBy = 	"flightroute")
	private List<FlightSchedule> schedule = new ArrayList<FlightSchedule>();
			
	public FlightRoute() {
		super();
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getSourcecity() {
		return sourcecity;
	}

	public void setSourcecity(String sourcecity) {
		this.sourcecity = sourcecity;
	}

	public String getDestinationcity() {
		return destinationcity;
	}

	public void setDestinationcity(String destinationcity) {
		this.destinationcity = destinationcity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public List<FlightSchedule> getSchedule() {
			return schedule;
		}

		public void setSchedule(List<FlightSchedule> schedule) {
			this.schedule = schedule;
		}
		
	
	//Business method to define it is two-way relationship
		public void addSchedule(FlightSchedule scheduleItem) {
			scheduleItem.setFlightroute(this);
			schedule.add(scheduleItem);
		
		

		}
		

}
