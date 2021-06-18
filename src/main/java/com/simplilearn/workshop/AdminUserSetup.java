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
		
			
		LoginUsers user = new LoginUsers();
		
		session.beginTransaction();
		//user.setID(1); 
		   user.setUsername("Admin"); 
		   user.setPassword("Admin"); 
				
		//execute database operations
		session.save(user);
		session.getTransaction().commit();

		session.close();
				
		HibernateUtils.getSessionFactory().close();
		

	}

	
}
