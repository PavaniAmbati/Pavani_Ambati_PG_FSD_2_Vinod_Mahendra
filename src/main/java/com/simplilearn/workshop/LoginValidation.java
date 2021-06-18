package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.model.LoginUsers;
import com.simplilearn.workshop.utils.HibernateUtils;

@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	String username;
		username=request.getParameter("username");
    	String password;
		password=request.getParameter("password");
		String backJSP = "/AdminPage.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backJSP);
		
		String backLogin = "/Login.jsp";
		RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(backLogin);
		
		String backUpdate = "/PasswordUpdate.jsp";
		RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher(backUpdate);
		
		if (request.getParameter("UpdatePassword") != null) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Update password");
			
				dispatcher2.forward(request,response);
		}else {

		if (request.getParameter("Login") != null) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//begin a transaction
		session.beginTransaction();
		
		LoginUsers user = new LoginUsers();
		//user.setID(1); 
		   user.setUsername("Admin"); 
		   user.setPassword("Admin"); 
				
		//execute database operations
		session.save(user);
		session.getTransaction().commit();
		
		LoginUsers loadedUser = (LoginUsers) session.get(LoginUsers.class,1);
		
		if (username.equals(loadedUser.getUsername()) && password.equals(loadedUser.getPassword()) ) {
			
			
			dispatcher.forward(request,response);
			

			
		} else {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("login failed");
			String message = "Username or password did not match";
			request.setAttribute("message", message);
			dispatcher1.forward(request,response);

			
		}
		
		session.getTransaction().commit(); //auto update
		
		//flush and close session
		session.close();
		} 
		
		
		}
    }	
		
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	doGet(request, response);
    	
    }
  }
		
	

	
    
    

