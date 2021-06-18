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

import com.simplilearn.workshop.model.LoginUsers;
import com.simplilearn.workshop.utils.HibernateUtils;


@WebServlet("/PasswordUpdate")
public class PasswordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username;
		username=request.getParameter("username");
    	String oldpassword;
		oldpassword=request.getParameter("oldpassword");
		String newpassword;
		newpassword=request.getParameter("newpassword");
		String backJSP = "/PasswordUpdate.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(backJSP);
		
		String backLogin = "/Login.jsp";
		RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(backLogin);
		
		if (request.getParameter("Back") != null) {
			
			dispatcher1.forward(request,response);
		}else {

		if (request.getParameter("Update") != null) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		//begin a transaction
		session.beginTransaction();
		LoginUsers loadedUser = (LoginUsers) session.get(LoginUsers.class,1);
		
		if (username.equals(loadedUser.getUsername()) && oldpassword.equals(loadedUser.getPassword()) ) {
			
			
			LoginUsers user = (LoginUsers)session.get(LoginUsers.class,1);
			user.setPassword(newpassword);
			session.update(user); 
			session.getTransaction().commit();
			session.close();
			String message = "Password successfully updated";
			request.setAttribute("message", message);
			dispatcher.forward(request,response);
			

			
		} else {
			
			
			String message = "Entered credentials mismatched. Password could not be updated";
			request.setAttribute("message", message);
			dispatcher.forward(request,response);
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
