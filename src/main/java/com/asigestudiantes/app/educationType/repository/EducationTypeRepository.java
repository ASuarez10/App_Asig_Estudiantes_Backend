package com.asigestudiantes.app.educationType.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Education_type;

@Repository
public interface EducationTypeRepository extends JpaRepository<Education_type, Long>{

	@Query("SELECT DISTINCT e.education_type_name FROM Education_type e")
	List<String> listDistinctNames();
	
}
