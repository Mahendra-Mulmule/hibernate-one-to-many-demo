package code;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {
	
	private static SessionFactory sessionfactory;
	
	static {
		try {
			if(sessionfactory==null) {
				 sessionfactory=new  Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();
			}
			
		}catch(Exception e) {
			throw new RuntimeException("Error in creating session factory "+e.getMessage());
		}
		
	}
		
		public static SessionFactory getSessionFactory() {
			return sessionfactory;
		}
	}


