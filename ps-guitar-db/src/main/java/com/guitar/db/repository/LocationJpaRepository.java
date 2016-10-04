package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author by mdmytriaha on 03.10.16.
 */
@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
}
