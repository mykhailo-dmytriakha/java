package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by mdmytriaha on 03.10.16.
 */
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
}
