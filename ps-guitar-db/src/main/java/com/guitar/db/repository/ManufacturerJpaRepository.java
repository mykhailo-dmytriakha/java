package com.guitar.db.repository;

import com.guitar.db.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author by mdmytriaha on 04.10.16.
 */
@Repository
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {
}