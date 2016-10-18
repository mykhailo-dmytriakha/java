package com.pluralsight.service;

import com.pluralsight.model.Goal;

import java.util.List;

/**
 * @author by mdmytriaha on 17.10.16.
 */
public interface GoalService {
	Goal save(Goal goal);

	List<Goal> findAllGoals();
}
