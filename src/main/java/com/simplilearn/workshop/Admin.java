package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.workshop.model.DestinationCity;
import com.simplilearn.workshop.model.FlightList;
import com.simplilearn.workshop.model.SourceCity;
import com.simplilearn.workshop.utils.HibernateUtils;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		

		//createsource();
		//createdestination();
		
		//Session session = HibernateUtils.getSessionFactory().openSession();
		
		//begin a transaction
		//session.beginTransaction();
		
		String newsource;
		newsource=request.getParameter("new source");
		
		String newdestination;
		newdestination=request.getParameter("new destination");
		
		String newflight;
		newflight=request.getParameter("new flight");
		
		//String deletesource;
		//deletesource=request.getParameter("Source city");
		
		//String deletedestination;
		//deletedestination=request.getParameter("Destination city");
		
		String backJSP = "/AdminPage.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backJSP);
		
		if (request.getParameter("add source") != null) {
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			SourceCity source = new SourceCity();
			source.setCity(newsource);
			session.save(source);
			session.getTransaction().commit();
			session.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Source added");
			
			dispatcher.forward(request,response); 
		  } else {
	    	if (request.getParameter("add destination") != null) {
	    	Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
	    	DestinationCity destination = new DestinationCity();
			destination.setCity(newdestination);
			session.save(destination);
			session.getTransaction().commit();
			session.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Destination added");
			
			dispatcher.forward(request,response); 
			
	    } else {
	    	if (request.getParameter("add flight") != null) {
		    	Session session = HibernateUtils.getSessionFactory().openSession();
				session.beginTransaction();
		    	FlightList flight = new FlightList();
				flight.setName(newflight);
				session.save(flight);
				session.getTransaction().commit();
				session.close();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("flight added");
				
				dispatcher.forward(request,response); 
	    	
	    }
	    	
	    	
	    	
	    	/*
	    	
	    	
	    	else {
	    	
	    	if (request.getParameter("delete source") != null) {
		    	

				
	    		Session session = HibernateUtils.getSessionFactory().openSession();
				Transaction transaction = session.getTransaction();
				transaction.begin();
				
				@SuppressWarnings("unchecked")
				Query query = session.createQuery("select source_id from SourceCity where city = :city");
				query.setParameter("city", deletesource);
				
							
				//int id = query.getParameter(0)   //getFirstResult();
				
				//PrintWriter out = response.getWriter();
				//out.println(id);
				
				/*SourceCity source = (SourceCity)session.load(SourceCity.class, id);
			
				session.delete(source);
				session.getTransaction().commit();
				session.close();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("source deleted");
				
				dispatcher.forward(request,response); */
				/*
		    } else {
		    	if (request.getParameter("delete destination") != null) {
			    	Session session = HibernateUtils.getSessionFactory().openSession();
					session.beginTransaction();
			    	DestinationCity destination = new DestinationCity();
					destination.setCity(deletedestination);
					session.delete(deletedestination);
					session.getTransaction().commit();
					session.close();
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("Destination deleted");
					
					dispatcher.forward(request,response);
		    	
		    }
	    }*/

	    
		
	}
}

}
	
}

	

	/*
	private void createsource() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		SourceCity source = new SourceCity();
		source.setCity("Chicago");
		session.save(source);
		session.getTransaction().commit();
		session.close();
		
		
		
	}
	
	private void createdestination() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		DestinationCity destination = new DestinationCity();
		destination.setCity("Chicago");
		session.save(destination);
		session.getTransaction().commit();
		session.close();		
	}
*/

