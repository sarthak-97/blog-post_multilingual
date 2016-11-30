package org.hibernate;

import org.hibernate.cfg.Configuration;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
	      
	      Session session =	sessionFactory.openSession();
	      session.beginTransaction();
	     
	      session.getTransaction().commit();
	      session.close();
	      
	}

}
