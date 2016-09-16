package com.mdmytriakha.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

/**
 * @author by Mykhailo on 9/7/2016.
 */
public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		try {
			File configFile = new File("resources/hibernate.cfg.xml");
			Configuration configuration = new Configuration().configure(configFile);
			sessionFactory = configuration.buildSessionFactory(/*serviceRegistry*/);
		} catch (HibernateException e) {
			System.out.println("Problem creating session factory! " + e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
