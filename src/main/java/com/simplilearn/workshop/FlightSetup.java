package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.workshop.model.FlightRoute;
import com.simplilearn.workshop.model.FlightSchedule;
import com.simplilearn.workshop.utils.HibernateUtils;


@SuppressWarnings("serial")
@WebServlet("/FlightSetup")
public class FlightSetup extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		String backJSP = "/FlightSetup.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backJSP);
		
	if (request.getParameter("logout") != null) {
    		
			String backlogin = "/Login.jsp";
			RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher(backlogin);
    		dispatcher2.forward(request,response); 
    		
    	}else {
    		
    		if (request.getParameter("save") != null) {
    			
		String flightname = request.getParameter("Flight Name");			
		String sourcecity = request.getParameter("Source city");
		String destinationcity = request.getParameter("Destination city");
		float price= Float.parseFloat(request.getParameter("Price"));
		String departuredate = request.getParameter("departuredate");
		String arrivaldate = request.getParameter("arrivaldate");

		
		FlightSchedule flightschedule = new FlightSchedule();
		flightschedule.setFlightname(flightname); 
		flightschedule.setDeparturedate(departuredate);
		flightschedule.setArrivaldate(arrivaldate);
		
		FlightRoute flightroute = new FlightRoute();
		flightroute.setFlightname(flightname);
		flightroute.setSourcecity(sourcecity);
		flightroute.setDestinationcity(destinationcity);
		flightroute.setPrice(price);
		flightroute.addSchedule(flightschedule);
		
		Session session = HibernateUtils.getSessionFactory().openSession();
				
		session.beginTransaction();
		
		//execute database operations
		session.save(flightroute);
		session.save(flightschedule);
		session.getTransaction().commit();
		
		session.close();
				
		//HibernateUtils.getSessionFactory().close();
		
		String message = "Flight route and schedule successfully added";
		request.setAttribute("message", message);
		dispatcher.forward(request,response); 
		
		
	 } else {
    		if (request.getParameter("removeroute") != null) {
    			
    			String flightname = request.getParameter("removeflight");			
    	    			
    			Session session = HibernateUtils.getSessionFactory().openSession();
				Transaction transaction = session.getTransaction();
				transaction.begin();
				
								
				@SuppressWarnings("unchecked")
				Query routequery = session.createQuery("delete from FlightSchedule as fs where fs.flightname = :name");
				routequery.setParameter("name", flightname);
				routequery.executeUpdate();
				session.getTransaction().commit();
				session.close();
				
				String message = "Flight route and schedule successfully deleted";
				request.setAttribute("message", message);
				dispatcher.forward(request,response); 
									
    		}
    	}
     	
    }

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	

}
