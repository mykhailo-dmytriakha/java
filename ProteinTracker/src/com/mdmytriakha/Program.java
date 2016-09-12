package com.mdmytriakha;

import org.hibernate.Session;

import java.util.Date;

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
		user.addHistory(new UserHistory(new Date(), "set name to DouLohnPaul"));
		user.getProteinData().setGoal(170);
		user.addHistory(new UserHistory(new Date(), "set goal to 170"));

		user.setGoalAlert(new GoalAlert("congratulations!"));
		session.save(user);

		session.getTransaction().commit();
		//-----
		session.beginTransaction();

		User loadedUser = session.get(User.class, 1);
//		System.out.println(loadedUser);

		loadedUser.setName("PaulNew");
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		loadedUser.addHistory(new UserHistory(new Date(), "added 50 protein"));

		user.setProteinData(new ProteinData());
//		System.out.println(loadedUser);

		session.getTransaction().commit();
		session.close();
	}
}