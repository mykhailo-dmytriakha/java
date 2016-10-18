package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		Query query = em.createQuery("select g from Goal g");
		return (List<Goal>) query.getResultList();
	}
}
