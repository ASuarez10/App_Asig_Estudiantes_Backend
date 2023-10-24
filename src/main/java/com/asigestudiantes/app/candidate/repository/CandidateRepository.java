package com.asigestudiantes.app.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

	@Query("SELECT DISTINCT c.city FROM Candidate c")
	List<String> listDistinctCities();
	
	@Query("SELECT DISTINCT c.estate FROM Candidate c")
	List<String> listDistinctEstates();
	
	@Query("SELECT DISTINCT c.sex FROM Candidate c")
	List<String> listDistinctSexes();
	
}
