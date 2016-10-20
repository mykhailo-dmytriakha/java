package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author by mdmytriaha on 18.10.16.
 */
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
