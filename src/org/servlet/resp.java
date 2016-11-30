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
 * Servlet implementation class resp
 */
@WebServlet("/resp")
public class resp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String mob=request.getParameter("t1");

				
			SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
		       
		       Session session =	sessionFactory.openSession();
		       session.beginTransaction();

		       Query queryResult = session.createQuery("from login");
		       java.util.List allUsers;
		       String pa,na;
		       
		       allUsers = queryResult.list();
		       int f;
		       f=0;
		       for (int i = 0; i < allUsers.size(); i++) {
		        login user = (login) allUsers.get(i);
		        pa=user.getmob();
		        
		        if(mob.equals(pa)){
		         f=1;
		         break; 
		         }
		        }
		         
		           if(f!=1){
		  login user= new login();  
		      
		     user.setmob(mob);
		       session.save(user);
		       session.getTransaction().commit();
		       session.close(); 
		       user=null;
		       System.out.println(mob);
		       response.sendRedirect("home.html");
		       

		           } 
		           else
		           {   System.out.println("duplicate");
		          
		           }
		            
			 }   

		
	}


