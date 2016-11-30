package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.login;
import org.hibernate.post;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class pos
 */
@WebServlet("/pos")
public class pos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
	       
	       Session session =	sessionFactory.openSession();
	       session.beginTransaction();
	    
			String mob=request.getParameter("mob");
			String pst=request.getParameter("t2");
			post user1= new post();
user1.setMob(mob);
user1.setPosts(pst);
		      session.save(user1);
		         System.out.println("hello");
		         session.getTransaction().commit();
			       session.close();
			       response.setContentType("text/html");
			       request.setAttribute("t2", mob);
			       request.getRequestDispatcher("/wall.jsp").forward(request, response);

			       
	}

}
