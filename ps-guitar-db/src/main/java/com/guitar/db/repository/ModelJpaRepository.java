package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface ModelJpaRepository extends JpaRepository<Model, Long> {
	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);

	List<Model> findByModelTypeNameIn(Collection<String> modelTypeName);

	@Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
	List<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest,
	                                         @Param("highest") BigDecimal high,
	                                         @Param("wood") String wood);

	@Query(name = "Model.findAllModelsByType")
	List<Model> findAllModelsByType(@Param("name") String modelType);
}
