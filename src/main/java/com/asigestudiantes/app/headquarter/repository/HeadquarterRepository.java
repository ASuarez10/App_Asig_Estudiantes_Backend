package com.asigestudiantes.app.headquarter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asigestudiantes.app.model.Headquarter;

@Repository
public interface HeadquarterRepository extends JpaRepository<Headquarter, Long>{

	@Query("SELECT DISTINCT h.headquarter_city FROM Headquarter h")
	List<String> listDistinctNames();
	
}
