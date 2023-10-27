package com.asigestudiantes.app.career.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long>{

	@Query("SELECT DISTINCT c.career_name FROM Career c")
	List<String> listDistinctNames();
	
}
