package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author by mdmytriaha on 17.10.16.
 */
@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;

	public Goal save(Goal goal) {
		em.persist(goal);
		em.flush();
		return goal;
	}

	@Override
	public List<Goal> findAllGoals() {
//		Query query = em.createQuery("select g from Goal g");

		TypedQuery<Goal> query = em.createNamedQuery(Goal.FIND_All, Goal.class);
		return query.getResultList();
	}

	@Override
	public List<GoalReport> findAllGoalReports() {
//		Query query = em.createQuery("select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) " +
//				"from Goal g, Exercise e where g.id = e.goal.id");

		TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
		return query.getResultList();
	}
}
