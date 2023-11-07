package com.asigestudiantes.app.criterion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Criterion;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, String>{
	
	@Query("SELECT c FROM Criterion c")
	Iterable<Criterion> findAllCriteriaJPQL();
	
}
