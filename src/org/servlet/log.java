package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.login;

import org.hibernate.cfg.Configuration;



/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
	       
	       Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	    
			String mob=request.getParameter("t1");
			  
		       Query queryResult = session.createQuery("from login ");
		       java.util.List allUsers;
		       String pa;
		       int na;
		       int f;
		       f=0;
		       
		       allUsers = queryResult.list();
		       System.out.println(allUsers.size());
		       for (int i = 0; i  < allUsers.size() ; i++) {
		      login user = (login) allUsers.get(i);
		      pa=user.getmob(); 
		      na=user.getM();
		      System.out.println(pa);
		      if( pa.equals(mob) && na==0)
		        {
		    	  System.out.println("welcom");
		            f=1;
		        	
		        	break; 
		        
	}
	}
		     
		       if(f==1)
		       {
		    	   response.setContentType("text/html");
			       request.setAttribute("t2", mob);
			       request.getRequestDispatcher("/wall.jsp").forward(request, response);

		       }    	       else
		       {
		    	   response.sendRedirect("home.html");
		       }
		       
		     
		       session.getTransaction().commit();
		       session.close();
		       
		}
	}


