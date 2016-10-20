package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author by mdmytriaha on 17.10.16.
 */
public interface GoalRepository extends JpaRepository<Goal, Long> {

	@Query("select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) " +
			"from Goal g, Exercise e where g.id = e.goal.id")
	List<GoalReport> findAllGoalReports();
}
