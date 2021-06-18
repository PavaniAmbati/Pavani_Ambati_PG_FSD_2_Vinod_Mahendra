package com.simplilearn.workshop.model;
import javax.persistence.Entity;

@Entity
public class RegistrationSale {
	
	private int custid;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String flightname;
	private String sourcecity;
	private String destinationcity;
	private String departuredate;
	private String arrivaldate;
	private String paymentmethod;
	private String cardnumber;
	private float totalpaid;
	private int nooftravelers;
	private float price;
	
	public RegistrationSale() {
		super();
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public float getTotalpaid() {
		return totalpaid;
	}

	public void setTotalpaid(float totalpaid) {
		this.totalpaid = totalpaid;
	}
	
	public int getNooftravelers() {
		return nooftravelers;
	}

	public void setNooftravelers(int nooftravelers) {
		this.nooftravelers = nooftravelers;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
