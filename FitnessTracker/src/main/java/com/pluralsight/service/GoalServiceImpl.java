package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author by mdmytriaha on 17.10.16.
 */
@Service("goalService")
@Transactional
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;

	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

	@Override
	public List<Goal> findAllGoals() {
		return goalRepository.findAllGoals();
	}
}
