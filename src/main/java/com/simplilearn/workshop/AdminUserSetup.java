package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.model.LoginUsers;
import com.simplilearn.workshop.utils.HibernateUtils;


@WebServlet("/AdminUserSetup")
public class AdminUserSetup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		
		//session.beginTransaction();
		//LoginUsers user = new LoginUsers();
				
		//begin a transaction
		//session.beginTransaction();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Login users");
		
		/*
		//user.setID(1); 
		   user.setUsername("Admin"); 
		   user.setPassword("Admin"); 
				
		//execute database operations
		session.save(user);
				
				//commit a transaction
		session.getTransaction().commit();
		*/
		session.close();
		
		HibernateUtils.getSessionFactory().close();
	}

	
}
