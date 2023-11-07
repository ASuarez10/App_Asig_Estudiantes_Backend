package com.asigestudiantes.app.criteriaConfiguration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asigestudiantes.app.model.CriteriaConfiguration;

@Repository
public interface CriteriaConfigurationRepository extends JpaRepository<CriteriaConfiguration, Long>{

	@Modifying
	@Transactional
	@Query("DELETE FROM CriteriaConfiguration c WHERE c.automatized = :isAutomatized")
	void deleteByAutomatized(@Param("isAutomatized") int isAutomatized);
}
