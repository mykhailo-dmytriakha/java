package com.pluralsight.service;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;

import java.util.List;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);
}