package com.mdmytriakha;

import org.hibernate.Session;

/**
 * @author Mykhailo on 9/7/2016.
 */
public class Program {
	public static void main(String[] args) {
		System.out.println("hello");
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		user.setName("DouJohnPaul");
		user.setGoal(150);
		session.save(user);

		session.getTransaction().commit();
		//-----
		session.beginTransaction();

		User loadedUser = session.get(User.class, 4);
		System.out.println(loadedUser);

		loadedUser.setName("PaulNew1");
		loadedUser.setTotal(loadedUser.getTotal() + 50);

		System.out.println(loadedUser);

		session.getTransaction().commit();
		session.close();
	}
}