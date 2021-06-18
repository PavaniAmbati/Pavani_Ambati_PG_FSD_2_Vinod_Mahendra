package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.simplilearn.workshop.model.FlightRoute;
import com.simplilearn.workshop.model.SourceCity;
import com.simplilearn.workshop.utils.HibernateUtils;
import com.simplilearn.workshop.utils.MySQLDatabaseUtils;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		

		
		//createsource();
		//createdestination();
		
		String newsource = request.getParameter("new source");
		String newdestination = newdestination=request.getParameter("new destination");
		String newflight = newflight=request.getParameter("new flight");
		
		String deletesource;
		deletesource=request.getParameter("Source city");
		
		String deletedestination;
		deletedestination=request.getParameter("Destination city");
		
		String deleteflight;
		deleteflight=request.getParameter("Flight Name");
		
		String backJSP = "/AdminPage.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backJSP);
		
		String backSetup = "/FlightSetup.jsp";
		RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(backSetup);
		
		String backlogin = "/Login.jsp";
		RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher(backlogin);
		
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
			out.println(newsource);
			
			String message = "source city successfully added";
			request.setAttribute("message", message);
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
			
			String message = "destination city successfully added";
			request.setAttribute("message", message);
			dispatcher.forward(request,response); 
			
	    } else {
	    	if (request.getParameter("add flight") != null) {
		    	Session session = HibernateUtils.getSessionFactory().openSession();
				session.beginTransaction();
		    	FlightList flight = new FlightList();
				flight.setFlight_name(newflight);
				session.save(flight);
				session.getTransaction().commit();
				session.close();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("flight added");
				
				String message = "flight successfully added";
				request.setAttribute("message", message);
				dispatcher.forward(request,response); 
	    	
	   }else {
	    	if (request.getParameter("next") != null) {
		    					
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("done");
				dispatcher1.forward(request,response); 
	    	
	   }else {
	    	if (request.getParameter("delete source") != null) {
		    	
	    		Session session = HibernateUtils.getSessionFactory().openSession();
				Transaction transaction = session.getTransaction();
				transaction.begin();
				
								
				@SuppressWarnings("unchecked")
				Query query = session.createQuery("delete from SourceCity as city where city.city = :city");
				query.setParameter("city", deletesource);
				
				query.executeUpdate();
				session.getTransaction().commit();
				session.close();
				
				String message = "source city successfully deleted";
				request.setAttribute("message", message);
				dispatcher.forward(request,response);  
				
		    } else {
		    	
		    	if (request.getParameter("delete destination") != null) {
		    	Session session = HibernateUtils.getSessionFactory().openSession();
				Transaction transaction = session.getTransaction();
				transaction.begin();
				
								
				@SuppressWarnings("unchecked")
				Query query = session.createQuery("delete from DestinationCity as city where city.city = :city");
				query.setParameter("city", deletedestination);
				
				query.executeUpdate();
				session.getTransaction().commit();
				session.close();
				
				String message = "destination city successfully deleted";
				request.setAttribute("message", message);
				dispatcher.forward(request,response); 
		    	
		    } else {
		    	
		    	if (request.getParameter("delete flight") != null) {
		    	Session session = HibernateUtils.getSessionFactory().openSession();
				Transaction transaction = session.getTransaction();
				transaction.begin();
				
								
				@SuppressWarnings("unchecked")
				Query query = session.createQuery("delete from FlightList as flight where flight.flight_name = :flight");
				query.setParameter("flight", deleteflight);
				
				query.executeUpdate();
				session.getTransaction().commit();
				session.close();
				
				String message = "flight successfully deleted";
				request.setAttribute("message", message);
				dispatcher.forward(request,response); 
		    	
		    } else {
		    	if (request.getParameter("logout") != null) {
		    		
		    		dispatcher2.forward(request,response); 
		    		
		    	}
		    	
		    	
		    }
		  }

		}	    	
	    	
	  }  
		
	} 
	
}
	


}

}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}

	/*
	    	
	    	
	    	
	    
		
	//}
//}

//}
	
//}

	

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

