package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.model.RegistrationSale;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String backJSP = "/Summary.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backJSP);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String flightname = request.getParameter("flightname");
		String sourcecity = request.getParameter("sourcecity");
		String destinationcity = request.getParameter("destinationcity");
		String departuredate = request.getParameter("departuredate");
		String arrivaldate = request.getParameter("arrivaldate");
		String paymentmethod = request.getParameter("paymentmethod");
		String cardnumber = request.getParameter("cardnumber");
		float price = Float.parseFloat(request.getParameter("price"));
		int travelers = Integer.parseInt(request.getParameter("travelers"));
		float totalpaid = price*travelers;
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		RegistrationSale register = new RegistrationSale();
		register.setFirstname(firstname);
		register.setLastname(lastname);
		register.setEmail(email);
		register.setPhone(phone);
		register.setFlightname(flightname);
		register.setSourcecity(sourcecity);
		register.setDestinationcity(destinationcity);
		register.setDeparturedate(departuredate);
		register.setArrivaldate(arrivaldate);
		register.setPaymentmethod(paymentmethod);
		register.setCardnumber(cardnumber);
		register.setTotalpaid(totalpaid);
		register.setNooftravelers(travelers); 
		register.setPrice(price);
						
		
		session.save(register);
		session.getTransaction().commit();
		session.close(); 
		//dispatcher.forward(request,response);
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title> FlyAway </title>");
	    out.println("</head>");
	    out.println("<body style=background-color:mintcream;>");
	    out.println("<h1 style=font-family:Gabriola; color:darkblue;font-size: 50px;> FlyAway</h1>");
	    out.println("<h4 style=color:darkblue> Airline Booking Portal</h4>");
	    out.println("<hr size = 2 color=black />");
	    out.println("<h3>Summary</h3>");
	    out.println("<br><br>");
	    
		out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>First Name</th>");
        out.println("<th>LastName</th>");
        out.println("<th>Email</th>");
        out.println("<th>Phone</th>");
        out.println("<th>Flight Name</th>");
        out.println("<th>Departure City</th>");
        out.println("<th>Destination City</th>");
        out.println("<th>Departure Date</th>");
        out.println("<th>Arrival Date</th>");
        out.println("<th>Payment Method</th>");
        out.println("<th>Ticket Price</th>");
        out.println("<th>Number of Travelers</th>");
        out.println("<th>Total Paid</th>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>" + firstname + "</td>");
        out.println("<td>" + lastname + "</td>");
        out.println("<td>" + email + "</td>");
        out.println("<td>" + phone + "</td>");
        out.println("<td>" + flightname + "</td>");
        out.println("<td>" + sourcecity + "</td>");
        out.println("<td>" + destinationcity + "</td>");
        out.println("<td>" + departuredate + "</td>");
        out.println("<td>" + arrivaldate + "</td>");
        out.println("<td>" + paymentmethod + "</td>");
        out.println("<td>" + price + "</td>");
        out.println("<td>" + travelers + "</td>");
        out.println("<td>" + totalpaid + "</td>");
        out.println("</tr>");
	   
     
        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
