package com.simplilearn.workshop.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity

public class FlightSchedule {
			
		
		
		private int sched_id;
		private String flightname;
		//private String sourcecity;
		//private String destinationcity;
		private String departuredate;
		private String arrivaldate;
		@ManyToOne
		
		//relationship (many flight schedule is associated with one fight route)
		
		private FlightRoute flightroute;
		
		
		public FlightSchedule() {
			super();
		}

		public FlightSchedule(String departuredate, String arrivaldate) {
			this.departuredate = departuredate;
			this.arrivaldate = arrivaldate;
		}
		
		public int getSched_id() {
			return sched_id;
		}

		public void setSched_id(int sched_id) {
			this.sched_id = sched_id;
		}
		
				
		public String getFlightname() {
			return flightname;
		}

		public void setFlightname(String flightname) {
			this.flightname = flightname;
		}

		public String getDeparturedate() {
			return departuredate;
		}

		public void setDeparturedate(String departuredate) {
			this.departuredate = departuredate;
		}

		public String getArrivaldate() {
			return arrivaldate;
		}

		public void setArrivaldate(String arrivaldate) {
			this.arrivaldate = arrivaldate;
		}

		public FlightRoute getFlightroute() {
			return flightroute;
		}

		public void setFlightroute(FlightRoute flightroute) {
			this.flightroute = flightroute;
		}
		 
}
