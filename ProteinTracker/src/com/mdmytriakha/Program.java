package com.mdmytriakha;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Mykhailo on 9/7/2016.
 */
public class Program {
	public static void main(String[] args) {
		System.out.println("hello");
		PopulateSampleData();
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();

//		Query query = session.createQuery("from GoalAlert ").setFirstResult(2).setMaxResults(3);
//		Query query = session.getNamedQuery("GetAllGoalAlerts");

		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("name", "joe"))
				.add(Restrictions.eq("id", 1));

		List<User> users = criteria.list();
		for (User  user : users){
			System.out.println(user.getName());
		}

		session.getTransaction().commit();
		session.close();

		HibernateUtils.getSessionFactory().close();
	}

	private static void PopulateSampleData() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();

		User joe = CreateUser("Joe", 500, 50, "Good job", "You made it!");
		session.save(joe);
		User bob = CreateUser("Bod", 300, 20, "Taco time!");
		session.save(bob);
		User amy = CreateUser("Amy", 250, 200, "Yes!!!");
		session.save(amy);

		session.getTransaction().commit();
		session.close();
	}

	private static User CreateUser(String name, int goal, int total, String... alerts) {
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "Set total to " + total));
		for(String alert : alerts){
			user.getGoalAlerts().add(new GoalAlert(alert));
		}

		return user;
	}
}