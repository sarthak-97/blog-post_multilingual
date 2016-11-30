package org.hibernate;

import org.hibernate.cfg.Configuration;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login user= new login();
		user.setmob("4876876");

		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();        		
	      
	      Session session =	sessionFactory.openSession();
	      session.beginTransaction();
	     session.save(user);
	      session.getTransaction().commit();
	      session.close();
	      
	}

}
