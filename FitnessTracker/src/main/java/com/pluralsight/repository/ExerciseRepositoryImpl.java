package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author by mdmytriaha on 18.10.16.
 */
@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	private EntityManager em;

	public Exercise save(Exercise exercise) {
		em.persist(exercise);
		em.flush();
		return exercise;
	}
}
