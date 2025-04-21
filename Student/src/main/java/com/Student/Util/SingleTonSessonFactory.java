package com.Student.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTonSessonFactory {
	
	private static  SessionFactory instance;
	
	static {
		try {
			if (instance==null) {
				instance=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		} catch (Exception e) {
			throw new RuntimeException("Error in creating session factory "+e.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return instance;
	}

}
