package com.pluralsight.repository;

import com.pluralsight.model.Goal;

import java.util.List;

/**
 * @author by mdmytriaha on 17.10.16.
 */
public interface GoalRepository {
	Goal save(Goal goal);

	List findAllGoals();
}
